package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
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
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_104_0_Test {

    private DigestUtils digestUtils;

    private MessageDigest messageDigest;

    private File testFile;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException, IOException {
        messageDigest = MessageDigest.getInstance("SHA-256");
        digestUtils = new DigestUtils(messageDigest);
        // Create a temporary file for testing
        testFile = File.createTempFile("testFile", ".txt");
        try (FileOutputStream fos = new FileOutputStream(testFile)) {
            fos.write("Hello, World!".getBytes());
        }
    }

    @Test
    public void testUpdateDigest() throws Exception {
        // Use reflection to access the private method
        Method updateDigestMethod = DigestUtils.class.getDeclaredMethod("updateDigest", MessageDigest.class, FileChannel.class);
        updateDigestMethod.setAccessible(true);
        try (FileChannel fileChannel = FileChannel.open(testFile.toPath())) {
            // Invoke the private method
            MessageDigest resultDigest = (MessageDigest) updateDigestMethod.invoke(null, messageDigest, fileChannel);
            // Get the expected digest
            byte[] expectedDigest = messageDigest.digest();
            // Compare the result with the expected digest
            assertArrayEquals(expectedDigest, resultDigest.digest());
        }
    }

    @Test
    public void testUpdateDigestWithEmptyFile() throws Exception {
        // Create an empty temporary file
        File emptyFile = File.createTempFile("emptyFile", ".txt");
        emptyFile.deleteOnExit();
        Method updateDigestMethod = DigestUtils.class.getDeclaredMethod("updateDigest", MessageDigest.class, FileChannel.class);
        updateDigestMethod.setAccessible(true);
        try (FileChannel fileChannel = FileChannel.open(emptyFile.toPath())) {
            MessageDigest resultDigest = (MessageDigest) updateDigestMethod.invoke(null, messageDigest, fileChannel);
            // The digest of an empty file should be the initial state of the MessageDigest
            assertArrayEquals(new byte[messageDigest.getDigestLength()], resultDigest.digest());
        }
    }

    @Test
    public void testUpdateDigestWithLargeFile() throws Exception {
        // Create a large temporary file
        File largeFile = File.createTempFile("largeFile", ".txt");
        largeFile.deleteOnExit();
        try (FileOutputStream fos = new FileOutputStream(largeFile)) {
            for (int i = 0; i < 10000; i++) {
                fos.write("Hello, World!".getBytes());
            }
        }
        Method updateDigestMethod = DigestUtils.class.getDeclaredMethod("updateDigest", MessageDigest.class, FileChannel.class);
        updateDigestMethod.setAccessible(true);
        try (FileChannel fileChannel = FileChannel.open(largeFile.toPath())) {
            MessageDigest resultDigest = (MessageDigest) updateDigestMethod.invoke(null, messageDigest, fileChannel);
            // Get the expected digest
            byte[] expectedDigest = messageDigest.digest();
            // Compare the result with the expected digest
            assertArrayEquals(expectedDigest, resultDigest.digest());
        }
    }
}
