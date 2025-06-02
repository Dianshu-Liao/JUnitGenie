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

class DigestUtils_updateDigest_101_0_Test {

    @Test
    void testUpdateDigest() throws NoSuchAlgorithmException {
        // Arrange
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] input = "test".getBytes();
        // Act
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        // Assert
        byte[] expectedDigest = messageDigest.digest(input);
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithDifferentInput() throws NoSuchAlgorithmException {
        // Arrange
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] input = "example".getBytes();
        // Act
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        // Assert
        byte[] expectedDigest = messageDigest.digest(input);
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithEmptyInput() throws NoSuchAlgorithmException {
        // Arrange
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] input = new byte[0];
        // Act
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        // Assert
        byte[] expectedDigest = messageDigest.digest(input);
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }
}
