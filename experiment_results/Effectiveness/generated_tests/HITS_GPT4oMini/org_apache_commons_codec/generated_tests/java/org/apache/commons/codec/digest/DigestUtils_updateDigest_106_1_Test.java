package org.apache.commons.codec.digest;

import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
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
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_106_1_Test {

    @TempDir
    Path tempDir;

    @Test
    public void testUpdateDigestWithValidFile() throws NoSuchAlgorithmException, IOException {
        // Arrange
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        Path filePath = tempDir.resolve("testFile.txt");
        Files.write(filePath, "Hello, World!".getBytes());
        // Act
        MessageDigest updatedDigest = DigestUtils.updateDigest(digest, filePath);
        // Assert
        byte[] expectedDigest = new byte[] { -34, -112, 91, -28, -45, -68, 113, 31, 61, 124, 111, -41, -51, -104, -72, 15, -105, -121, -59, -12, 105, -29, 20, 65, -112, -91, -33, -40, 29, 88, 49, -92 };
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    public void testUpdateDigestWithEmptyFile() throws NoSuchAlgorithmException, IOException {
        // Arrange
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        Path filePath = tempDir.resolve("emptyFile.txt");
        Files.createFile(filePath);
        // Act
        MessageDigest updatedDigest = DigestUtils.updateDigest(digest, filePath);
        // Assert
        byte[] expectedDigest = new byte[] { -100, -106, -114, 92, -93, -46, -91, 104, -54, -106, -78, 48, -72, 16, 99, -44, -44, 78, 55, -115, -23, 22, -118, -112, 88, -30, -113, -102, -69, -117, 111, 65 };
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    public void testUpdateDigestWithNonExistentFile() {
        // Arrange
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Path nonExistentFilePath = tempDir.resolve("nonExistentFile.txt");
        // Act & Assert
        try {
            DigestUtils.updateDigest(digest, nonExistentFilePath);
        } catch (IOException e) {
            // Expected exception
            return;
        }
        throw new AssertionError("Expected IOException was not thrown.");
    }
}
