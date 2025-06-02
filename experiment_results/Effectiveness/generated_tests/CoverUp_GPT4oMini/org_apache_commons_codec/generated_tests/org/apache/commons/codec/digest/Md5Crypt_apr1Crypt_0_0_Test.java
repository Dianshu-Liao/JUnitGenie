package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.B64;
import org.apache.commons.codec.digest.Md5Crypt;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Md5Crypt_apr1Crypt_0_0_Test {

    @Test
    void testApr1CryptWithValidInput() throws Exception {
        // Arrange
        String input = "testPassword";
        byte[] keyBytes = input.getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    @Test
    void testApr1CryptWithEmptyInput() throws Exception {
        // Arrange
        byte[] keyBytes = new byte[0];
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    @Test
    void testApr1CryptWithNullInput() throws Exception {
        // Arrange
        byte[] keyBytes = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            Md5Crypt.apr1Crypt(keyBytes);
        });
    }

    @Test
    void testApr1CryptWithLongInput() throws Exception {
        // Arrange
        String input = "This is a very long password that exceeds typical lengths.";
        byte[] keyBytes = input.getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    // Reflection test for private method if needed
    @Test
    void testPrivateMethodUsingReflection() throws Exception {
        // This example assumes you have a private method to test
        // If there's a specific private method in Md5Crypt you want to test, replace it accordingly.
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", byte[].class, String.class);
        method.setAccessible(true);
        // Arrange
        String input = "testPassword";
        byte[] keyBytes = input.getBytes(StandardCharsets.UTF_8);
        String salt = B64.getRandomSalt(8);
        // Act
        String result = (String) method.invoke(null, keyBytes, salt);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }
}
