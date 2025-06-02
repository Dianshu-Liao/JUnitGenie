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

public class UnixCrypt_crypt_3_0_Test {

    @Test
    public void testCryptWithValidSalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "./";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithNullSaltGeneratesRandomSalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String result = UnixCrypt.crypt(input, null);
        assertNotNull(result);
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithInvalidSaltThrowsException() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String invalidSalt = "invalid_salt";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(input, invalidSalt);
        });
        assertEquals("Invalid salt value: " + invalidSalt, thrown.getMessage());
    }

    @Test
    public void testCryptWithEmptySalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(input, salt);
        });
        assertEquals("Invalid salt value: " + salt, thrown.getMessage());
    }

    @Test
    public void testCryptWithSpecialCharacterSalt() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        // Valid salt
        String salt = "./";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithDifferentInputsProducesDifferentOutputs() {
        byte[] input1 = "password1".getBytes(StandardCharsets.UTF_8);
        byte[] input2 = "password2".getBytes(StandardCharsets.UTF_8);
        String salt = "./";
        String result1 = UnixCrypt.crypt(input1, salt);
        String result2 = UnixCrypt.crypt(input2, salt);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testCryptWithSameInputAndSaltProducesSameOutput() {
        byte[] input = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "./";
        String result1 = UnixCrypt.crypt(input, salt);
        String result2 = UnixCrypt.crypt(input, salt);
        assertEquals(result1, result2);
    }
}
