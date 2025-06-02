package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Sha2Crypt;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Random;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sha2Crypt_sha256Crypt_2_0_Test {

    @Test
    void testSha256CryptWithNullSalt() throws Exception {
        // Arrange
        byte[] keyBytes = "password".getBytes();
        Random random = new SecureRandom();
        String expectedPrefix = "$5$";
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes, null, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(expectedPrefix), "Result should start with $5$");
    }

    @Test
    void testSha256CryptWithValidSalt() throws Exception {
        // Arrange
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=5000$abcdefgh";
        Random random = new SecureRandom();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(salt), "Result should start with the provided salt");
    }

    @Test
    void testSha256CryptWithInvalidSalt() {
        // Arrange
        byte[] keyBytes = "password".getBytes();
        String invalidSalt = "invalid_salt";
        Random random = new SecureRandom();
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, invalidSalt, random);
        });
        assertEquals("Invalid salt value: " + invalidSalt, thrown.getMessage());
    }

    @Test
    void testSha256CryptWithCustomRounds() throws Exception {
        // Arrange
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=10000$abcdefgh";
        Random random = new SecureRandom();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(salt), "Result should start with the provided salt");
    }

    @Test
    void testSha256CryptWithRandomSalt() throws Exception {
        // Arrange
        byte[] keyBytes = "password".getBytes();
        Random random = new SecureRandom();
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes, null, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith("$5$"), "Result should start with $5$");
        assertTrue(result.length() > 20, "Result should be longer than 20 characters");
    }
}
