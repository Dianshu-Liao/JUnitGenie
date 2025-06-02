package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_103_0_Test {

    private MessageDigest messageDigest;

    private File testFile;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException, IOException {
        // Initialize MessageDigest instance
        messageDigest = MessageDigest.getInstance("SHA-256");
        // Create a temporary file for testing
        testFile = File.createTempFile("testFile", ".txt");
        try (FileOutputStream fos = new FileOutputStream(testFile)) {
            fos.write("Hello, World!".getBytes());
        }
    }

    @Test
    public void testUpdateDigest_WithValidFile() throws IOException {
        // Expected SHA-256 hash of the file's content
        byte[] expectedHash = { (byte) 0xa4, (byte) 0x7f, (byte) 0x5e, (byte) 0x3e, (byte) 0x5c, (byte) 0x0b, (byte) 0x5e, (byte) 0x3b, (byte) 0x5b, (byte) 0x8d, (byte) 0x5f, (byte) 0x8e, (byte) 0x4b, (byte) 0x1e, (byte) 0x69, (byte) 0x8b, (byte) 0x69, (byte) 0x97, (byte) 0x1e, (byte) 0x29, (byte) 0x6e, (byte) 0x6a, (byte) 0x9b, (byte) 0x1f, (byte) 0x2a, (byte) 0x4f, (byte) 0x83, (byte) 0x68, (byte) 0x12, (byte) 0x11, (byte) 0x9f, (byte) 0x2f };
        // Call the focal method
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, testFile);
        // Verify the result
        assertArrayEquals(expectedHash, resultDigest.digest());
    }

    @Test
    public void testUpdateDigest_WithEmptyFile() throws IOException {
        // Create an empty temporary file
        File emptyFile = File.createTempFile("emptyFile", ".txt");
        // Call the focal method
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, emptyFile);
        // Verify the result
        // SHA-256 produces a 32-byte hash
        assertArrayEquals(new byte[32], resultDigest.digest());
    }

    @Test
    public void testUpdateDigest_WithNonExistentFile() {
        // Test with a non-existent file
        File nonExistentFile = new File("nonExistentFile.txt");
        // Expect IOException to be thrown
        try {
            DigestUtils.updateDigest(messageDigest, nonExistentFile);
        } catch (IOException e) {
            // Test passes if IOException is thrown
            return;
        }
        // If no exception is thrown, fail the test
        assert false;
    }

    @Test
    public void tearDown() {
        // Clean up the temporary files created during tests
        if (testFile != null && testFile.exists()) {
            testFile.delete();
        }
    }
}
