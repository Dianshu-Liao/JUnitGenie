package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

class DigestUtils_updateDigest_106_0_Test {

    @Test
    void testUpdateDigestWithValidFile() throws NoSuchAlgorithmException, IOException {
        // Prepare a message digest instance
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Create a temporary file
        Path tempFile = Files.createTempFile("testFile", ".txt");
        Files.write(tempFile, "Hello, World!".getBytes());
        try {
            // Call the method under test
            MessageDigest resultDigest = DigestUtils.updateDigest(digest, tempFile);
            // Validate the result
            byte[] expectedDigest = digest.digest();
            assertArrayEquals(expectedDigest, resultDigest.digest());
        } finally {
            // Clean up the temporary file
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    void testUpdateDigestWithEmptyFile() throws NoSuchAlgorithmException, IOException {
        // Prepare a message digest instance
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Create a temporary empty file
        Path tempFile = Files.createTempFile("emptyFile", ".txt");
        try {
            // Call the method under test
            MessageDigest resultDigest = DigestUtils.updateDigest(digest, tempFile);
            // Validate the result for an empty file
            byte[] expectedDigest = digest.digest();
            assertArrayEquals(expectedDigest, resultDigest.digest());
        } finally {
            // Clean up the temporary file
            Files.deleteIfExists(tempFile);
        }
    }
}
