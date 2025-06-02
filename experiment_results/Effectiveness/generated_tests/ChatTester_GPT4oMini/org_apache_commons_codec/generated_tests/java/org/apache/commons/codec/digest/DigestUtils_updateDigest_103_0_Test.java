package org.apache.commons.codec.digest;

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
        messageDigest = MessageDigest.getInstance("SHA-256");
        testFile = File.createTempFile("testFile", ".txt");
    }

    @AfterEach
    public void tearDown() {
        if (testFile != null && testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testUpdateDigestWithValidFile() throws IOException {
        // Prepare test data
        String data = "Hello, World!";
        try (FileOutputStream fos = new FileOutputStream(testFile)) {
            fos.write(data.getBytes());
        }
        // Update digest
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, testFile);
        byte[] expectedDigest = messageDigest.digest();
        // Verify the result
        assertArrayEquals(expectedDigest, resultDigest.digest());
    }

    @Test
    public void testUpdateDigestWithNonExistentFile() {
        File nonExistentFile = new File("non_existent_file.txt");
        assertThrows(IOException.class, () -> {
            DigestUtils.updateDigest(messageDigest, nonExistentFile);
        });
    }

    @Test
    public void testUpdateDigestWithEmptyFile() throws IOException {
        // Create an empty file
        File emptyFile = File.createTempFile("emptyFile", ".txt");
        // Ensure it gets deleted after the test
        emptyFile.deleteOnExit();
        // Update digest
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, emptyFile);
        byte[] expectedDigest = messageDigest.digest();
        // Verify the result
        assertArrayEquals(expectedDigest, resultDigest.digest());
    }

    @Test
    public void testUpdateDigestWithNullFile() {
        assertThrows(NullPointerException.class, () -> {
            DigestUtils.updateDigest(messageDigest, (File) null);
        });
    }

    @Test
    public void testUpdateDigestWithNullDigest() {
        assertThrows(NullPointerException.class, () -> {
            DigestUtils.updateDigest(null, testFile);
        });
    }
}
