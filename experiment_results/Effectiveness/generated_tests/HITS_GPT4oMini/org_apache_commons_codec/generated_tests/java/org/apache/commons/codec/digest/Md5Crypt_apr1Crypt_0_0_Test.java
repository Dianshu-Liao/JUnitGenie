package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_0_0_Test {

    @Test
    public void testApr1CryptWithValidKey() {
        // Arrange
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1CryptWithEmptyKey() {
        // Arrange
        byte[] keyBytes = "".getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1CryptWithNullKey() {
        // Arrange
        byte[] keyBytes = null;
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1CryptWithSpecialCharacters() {
        // Arrange
        byte[] keyBytes = "!@#$%^&*()_+".getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1CryptWithLongKey() {
        // Arrange
        byte[] keyBytes = "thisIsAVeryLongPasswordThatExceedsTypicalLengths".getBytes(StandardCharsets.UTF_8);
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes);
        // Assert
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }
}
