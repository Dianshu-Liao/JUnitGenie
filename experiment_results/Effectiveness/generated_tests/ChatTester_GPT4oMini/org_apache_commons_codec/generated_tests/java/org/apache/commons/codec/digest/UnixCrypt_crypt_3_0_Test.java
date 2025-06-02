package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class // Reflection test for private methods can be added here if necessary.
UnixCrypt_crypt_3_0_Test {

    @Test
    public void testCryptWithValidSalt() throws Exception {
        byte[] original = "password".getBytes();
        String salt = "ab";
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithNullSalt() throws Exception {
        byte[] original = "password".getBytes();
        String result = UnixCrypt.crypt(original, null);
        assertNotNull(result);
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithInvalidSalt() {
        byte[] original = "password".getBytes();
        // Invalid salt
        String invalidSalt = "1@";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(original, invalidSalt);
        });
        assertTrue(exception.getMessage().contains("Invalid salt value:"));
    }

    @Test
    public void testCryptWithShortSalt() {
        byte[] original = "password".getBytes();
        // Short salt
        String shortSalt = "a";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(original, shortSalt);
        });
        assertTrue(exception.getMessage().contains("Invalid salt value:"));
    }

    @Test
    public void testCryptWithEmptySalt() {
        byte[] original = "password".getBytes();
        // Empty salt
        String emptySalt = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(original, emptySalt);
        });
        assertTrue(exception.getMessage().contains("Invalid salt value:"));
    }

    @Test
    public void testCryptWithLongSalt() {
        byte[] original = "password".getBytes();
        // Longer than 2 characters
        String longSalt = "abcdef";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(original, longSalt);
        });
        assertTrue(exception.getMessage().contains("Invalid salt value:"));
    }

    @Test
    public void testCryptWithDifferentOriginalLengths() throws Exception {
        byte[] originalShort = "pw".getBytes();
        byte[] originalLong = "passwordpassword".getBytes();
        String salt = "ab";
        String resultShort = UnixCrypt.crypt(originalShort, salt);
        String resultLong = UnixCrypt.crypt(originalLong, salt);
        assertNotNull(resultShort);
        assertNotNull(resultLong);
        assertEquals(13, resultShort.length());
        assertEquals(13, resultLong.length());
    }

    @Test
    public void testCryptWithEdgeCaseOriginal() throws Exception {
        // Empty original
        byte[] original = new byte[0];
        String salt = "ab";
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithSpecialCharacters() throws Exception {
        // Special characters
        byte[] original = "!@#$%^&*()".getBytes();
        String salt = "ab";
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length());
    }
}
