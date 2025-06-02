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

public class UnixCrypt_crypt_5_0_Test {

    @Test
    public void testCryptWithValidSalt() {
        String original = "password";
        String salt = "ab";
        String expected = UnixCrypt.crypt(original, salt);
        assertNotNull(expected);
        // Valid output length for crypt
        assertEquals(13, expected.length());
    }

    @Test
    public void testCryptWithNullSalt() {
        String original = "password";
        String result = UnixCrypt.crypt(original, null);
        assertNotNull(result);
        // Valid output length for crypt
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithInvalidSalt() {
        String original = "password";
        // Invalid salt (less than 2 characters)
        String invalidSalt = "1";
        assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(original, invalidSalt);
        });
    }

    @Test
    public void testCryptWithSaltContainingSpecialCharacters() {
        String original = "password";
        // Special characters in salt
        String salt = "!@";
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        // Valid output length for crypt
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithEmptyString() {
        String original = "";
        String salt = "ab";
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        // Valid output length for crypt
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithLongInput() {
        String original = "thisisaverylongpasswordthatshouldstillwork";
        String salt = "xy";
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        // Valid output length for crypt
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithDifferentSalt() {
        String original = "password";
        String salt1 = "ab";
        String salt2 = "cd";
        String result1 = UnixCrypt.crypt(original, salt1);
        String result2 = UnixCrypt.crypt(original, salt2);
        // Different salts should produce different results
        assertNotEquals(result1, result2);
    }

    @Test
    public void testCryptWithSameInputAndSalt() {
        String original = "password";
        String salt = "ab";
        String result1 = UnixCrypt.crypt(original, salt);
        String result2 = UnixCrypt.crypt(original, salt);
        // Same input and salt should produce same result
        assertEquals(result1, result2);
    }
}
