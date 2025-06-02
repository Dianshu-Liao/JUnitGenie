package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Sha2Crypt;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sha2Crypt_sha256Crypt_0_0_Test {

    @Test
    public void testSha256CryptWithValidInput() throws Exception {
        // Arrange
        String input = "testInput";
        byte[] keyBytes = input.getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX), "Result should start with $5$");
    }

    @Test
    public void testSha256CryptWithNullInput() throws Exception {
        // Arrange
        byte[] keyBytes = null;
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX), "Result should start with $5$");
    }

    @Test
    public void testSha256CryptWithEmptyInput() throws Exception {
        // Arrange
        byte[] keyBytes = "".getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX), "Result should start with $5$");
    }

    @Test
    public void testSha256CryptWithSpecialCharacters() throws Exception {
        // Arrange
        String input = "!@#$%^&*()_+";
        byte[] keyBytes = input.getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX), "Result should start with $5$");
    }

    @Test
    public void testSha256CryptWithLongInput() throws Exception {
        // Arrange
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            input.append("longInput");
        }
        byte[] keyBytes = input.toString().getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX), "Result should start with $5$");
    }

    // Reflection Test for private methods (if needed)
    @Test
    public void testPrivateMethodUsingReflection() throws Exception {
        Method method = Sha2Crypt.class.getDeclaredMethod("sha256Crypt", byte[].class);
        method.setAccessible(true);
        String input = "testInput";
        byte[] keyBytes = input.getBytes(StandardCharsets.UTF_8);
        String result = (String) method.invoke(null, (Object) keyBytes);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX), "Result should start with $5$");
    }
}
