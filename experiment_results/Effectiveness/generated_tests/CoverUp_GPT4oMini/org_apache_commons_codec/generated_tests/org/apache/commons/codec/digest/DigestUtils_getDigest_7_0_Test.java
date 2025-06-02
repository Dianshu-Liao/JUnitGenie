package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
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

public class DigestUtils_getDigest_7_0_Test {

    @Test
    public void testGetDigestWithValidAlgorithm() throws NoSuchAlgorithmException {
        // Arrange
        String algorithm = "SHA-256";
        MessageDigest defaultDigest = MessageDigest.getInstance("MD5");
        // Act
        MessageDigest result = DigestUtils.getDigest(algorithm, defaultDigest);
        // Assert
        assertNotNull(result);
    }

    @Test
    public void testGetDigestWithInvalidAlgorithm() {
        // Arrange
        String invalidAlgorithm = "INVALID_ALGORITHM";
        MessageDigest defaultDigest = null;
        // Act
        MessageDigest result = DigestUtils.getDigest(invalidAlgorithm, defaultDigest);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetDigestWithNullDefaultDigest() throws NoSuchAlgorithmException {
        // Arrange
        String algorithm = "SHA-1";
        MessageDigest defaultDigest = null;
        // Act
        MessageDigest result = DigestUtils.getDigest(algorithm, defaultDigest);
        // Assert
        assertNotNull(result);
    }
}
