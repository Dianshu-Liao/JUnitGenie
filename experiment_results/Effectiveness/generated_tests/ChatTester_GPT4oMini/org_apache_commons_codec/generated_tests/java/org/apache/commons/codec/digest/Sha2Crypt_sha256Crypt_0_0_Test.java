package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sha2Crypt_sha256Crypt_0_0_Test {

    @Test
    void testSha256CryptWithNullSalt() {
        // Arrange
        byte[] keyBytes = "testKey".getBytes();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithEmptyKey() {
        // Arrange
        byte[] keyBytes = "".getBytes();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithLongKey() {
        // Arrange
        byte[] keyBytes = "thisIsAVeryLongKeyThatExceedsStandardLengths".getBytes();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithSpecialCharacters() {
        // Arrange
        byte[] keyBytes = "special@#$%&*characters".getBytes();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithNullKey() {
        // Arrange
        byte[] keyBytes = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes);
        });
    }

    @Test
    void testSha256CryptWithShortKey() {
        // Arrange
        byte[] keyBytes = "short".getBytes();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithWhitespaceKey() {
        // Arrange
        byte[] keyBytes = "   ".getBytes();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }
}
