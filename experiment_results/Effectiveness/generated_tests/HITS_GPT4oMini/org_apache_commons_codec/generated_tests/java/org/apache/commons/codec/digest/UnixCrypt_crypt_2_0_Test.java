package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.regex.Pattern;

public class UnixCrypt_crypt_2_0_Test {

    @Test
    public void testCryptWithNullSalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String result = UnixCrypt.crypt(input);
        assertNotNull(result);
        // Check expected length for the output
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithValidSalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "ab";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        // Check expected length for the output
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithInvalidSalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        // Invalid salt (too short)
        String invalidSalt = "1";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(input, invalidSalt);
        });
        assertEquals("Invalid salt value: " + invalidSalt, thrown.getMessage());
    }

    @Test
    public void testCryptWithEmptyInput() {
        byte[] input = "".getBytes(StandardCharsets.UTF_8);
        String salt = "ab";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        // Check expected length for the output
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithLongInput() {
        byte[] input = "thisisaverylongpassword".getBytes(StandardCharsets.UTF_8);
        String salt = "cd";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        // Check expected length for the output
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithSpecialCharacters() {
        byte[] input = "!@#$%^&*()".getBytes(StandardCharsets.UTF_8);
        String salt = "ef";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        // Check expected length for the output
        assertEquals(13, result.length());
    }
}
