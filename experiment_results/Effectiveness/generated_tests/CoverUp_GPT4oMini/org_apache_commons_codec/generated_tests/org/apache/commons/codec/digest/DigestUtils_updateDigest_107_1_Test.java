package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_107_1_Test {

    private MessageDigest messageDigest;

    private RandomAccessFile randomAccessFile;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException, IOException {
        // Initialize MessageDigest for SHA-256
        messageDigest = MessageDigest.getInstance("SHA-256");
        // Create a temporary file to use with RandomAccessFile
        File tempFile = File.createTempFile("testFile", ".txt");
        // Ensure the file is deleted on exit
        tempFile.deleteOnExit();
        // Write some test data to the file
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write("Hello, World!".getBytes());
        }
        // Initialize RandomAccessFile
        randomAccessFile = new RandomAccessFile(tempFile, "r");
    }

    @Test
    public void testUpdateDigest() throws IOException {
        // Calculate expected digest value
        byte[] expectedDigest = messageDigest.digest("Hello, World!".getBytes());
        // Use the focal method to update the digest
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, randomAccessFile);
        // Verify the digest value
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    // Clean up resources
    @AfterEach
    public void tearDown() throws IOException {
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }
}
