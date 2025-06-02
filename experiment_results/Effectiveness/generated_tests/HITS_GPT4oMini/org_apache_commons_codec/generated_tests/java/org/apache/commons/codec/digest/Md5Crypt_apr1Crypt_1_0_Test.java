package org.apache.commons.codec.digest;

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
    public void testApr1Crypt_NonNullOutput() {
        // Arrange
        byte[] keyBytes = "testPassword".getBytes();
        Random random = new SecureRandom();
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes, random);
        // Assert
        assertNotNull(result, "The output should not be null");
    }

    @Test
    public void testApr1Crypt_OutputStartsWithApr1Prefix() {
        // Arrange
        byte[] keyBytes = "testPassword".getBytes();
        Random random = new SecureRandom();
        // Act
        String result = Md5Crypt.apr1Crypt(keyBytes, random);
        // Assert
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The output should start with APR1_PREFIX");
    }

    @Test
    public void testApr1Crypt_DifferentInputsProduceDifferentOutputs() {
        // Arrange
        byte[] keyBytes1 = "testPassword1".getBytes();
        byte[] keyBytes2 = "testPassword2".getBytes();
        Random random = new SecureRandom();
        // Act
        String result1 = Md5Crypt.apr1Crypt(keyBytes1, random);
        String result2 = Md5Crypt.apr1Crypt(keyBytes2, random);
        // Assert
        assertTrue(!result1.equals(result2), "Different inputs should produce different outputs");
    }

    @Test
    public void testApr1Crypt_SameInputProducesConsistentOutput() {
        // Arrange
        byte[] keyBytes = "testPassword".getBytes();
        Random random = new SecureRandom();
        // Act
        String result1 = Md5Crypt.apr1Crypt(keyBytes, random);
        String result2 = Md5Crypt.apr1Crypt(keyBytes, random);
        // Assert
        assertTrue(result1.equals(result2), "Same input should produce the same output");
    }
}
