package org.apache.commons.codec.digest;

import org.junit.jupiter.api.function.Executable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

class DigestUtils_getDigest_6_0_Test {

    @Test
    void testGetDigest_ValidAlgorithm() {
        // Arrange
        String algorithm = "SHA-256";
        // Act
        MessageDigest digest = DigestUtils.getDigest(algorithm);
        // Assert
        assertNotNull(digest);
        assertEquals("SHA-256", digest.getAlgorithm());
    }

    @Test
    void testGetDigest_InvalidAlgorithm() {
        // Arrange
        String algorithm = "INVALID_ALGORITHM";
        // Act
        Executable executable = () -> DigestUtils.getDigest(algorithm);
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertNotNull(exception);
        assertTrue(exception.getCause() instanceof NoSuchAlgorithmException);
    }

    @Test
    void testGetDigest_MD5Algorithm() {
        // Arrange
        String algorithm = "MD5";
        // Act
        MessageDigest digest = DigestUtils.getDigest(algorithm);
        // Assert
        assertNotNull(digest);
        assertEquals("MD5", digest.getAlgorithm());
    }

    @Test
    void testGetDigest_SHA1Algorithm() {
        // Arrange
        String algorithm = "SHA-1";
        // Act
        MessageDigest digest = DigestUtils.getDigest(algorithm);
        // Assert
        assertNotNull(digest);
        assertEquals("SHA-1", digest.getAlgorithm());
    }

    @Test
    void testGetDigest_SHA512Algorithm() {
        // Arrange
        String algorithm = "SHA-512";
        // Act
        MessageDigest digest = DigestUtils.getDigest(algorithm);
        // Assert
        assertNotNull(digest);
        assertEquals("SHA-512", digest.getAlgorithm());
    }
}
