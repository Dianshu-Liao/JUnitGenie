package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Md5Crypt;
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
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_1_0_Test {

    @Test
    public void testApr1Crypt() throws Exception {
        // Arrange
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        Random random = new SecureRandom();
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
        assertTrue(result.length() > Md5Crypt.APR1_PREFIX.length());
    }

    @Test
    public void testApr1CryptWithNullRandom() throws Exception {
        // Arrange
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        Random random = null;
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
        assertTrue(result.length() > Md5Crypt.APR1_PREFIX.length());
    }

    @Test
    public void testApr1CryptWithEmptyKey() throws Exception {
        // Arrange
        byte[] keyBytes = "".getBytes(StandardCharsets.UTF_8);
        Random random = new SecureRandom();
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
        assertTrue(result.length() > Md5Crypt.APR1_PREFIX.length());
    }
}
