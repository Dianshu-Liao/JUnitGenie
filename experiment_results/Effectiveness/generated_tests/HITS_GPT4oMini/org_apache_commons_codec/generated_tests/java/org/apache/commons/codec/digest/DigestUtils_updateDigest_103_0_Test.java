package org.apache.commons.codec.digest;

import java.io.File;
import java.io.FileWriter;
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
        // Initialize the MessageDigest instance
        messageDigest = MessageDigest.getInstance("SHA-256");
        // Create a temporary test file
        testFile = File.createTempFile("testFile", ".txt");
        // Ensure the file is deleted after the test
        testFile.deleteOnExit();
        // Write some data to the file
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("This is a test file for DigestUtils.");
        }
    }

    @Test
    public void testUpdateDigest_ValidFile() throws IOException {
        // Expected hash value for the content of the file
        byte[] expectedDigest = messageDigest.digest("This is a test file for DigestUtils.".getBytes());
        // Call the method under test
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, testFile);
        // Assert that the result digest matches the expected digest
        assertArrayEquals(expectedDigest, resultDigest.digest());
    }

    @Test
    public void testUpdateDigest_EmptyFile() throws IOException, NoSuchAlgorithmException {
        // Create an empty temporary file
        File emptyFile = File.createTempFile("emptyFile", ".txt");
        // Ensure the file is deleted after the test
        emptyFile.deleteOnExit();
        // Call the method under test
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, emptyFile);
        // Assert that the digest of an empty file should be the same as the initial digest
        assertArrayEquals(messageDigest.digest(), resultDigest.digest());
    }

    @Test
    public void testUpdateDigest_NonExistentFile() {
        // Create a non-existent file
        File nonExistentFile = new File("nonExistentFile.txt");
        // Assert that an IOException is thrown
        try {
            DigestUtils.updateDigest(messageDigest, nonExistentFile);
        } catch (IOException e) {
            // Test passes if IOException is thrown
            return;
        }
        // If no exception was thrown, fail the test
        throw new AssertionError("Expected IOException was not thrown.");
    }
}
