package org.apache.commons.codec.digest;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_107_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigest_withValidRandomAccessFile() throws IOException, NoSuchAlgorithmException {
        // Prepare test data
        byte[] data = "Hello, World!".getBytes();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("testfile.txt", "rw")) {
            randomAccessFile.write(data);
            // Reset the file pointer to the beginning
            randomAccessFile.seek(0);
            // Invoke the focal method
            MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, randomAccessFile);
            byte[] expectedDigest = MessageDigest.getInstance("SHA-256").digest(data);
            // Validate the result
            assertArrayEquals(expectedDigest, resultDigest.digest());
        }
    }

    @Test
    public void testUpdateDigest_withEmptyRandomAccessFile() throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("emptyfile.txt", "rw")) {
            // Invoke the focal method
            MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, randomAccessFile);
            // Validate that the digest is still empty (no data)
            byte[] expectedDigest = messageDigest.digest();
            assertArrayEquals(expectedDigest, resultDigest.digest());
        }
    }

    @Test
    public void testUpdateDigest_withNullMessageDigest() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("testfile.txt", "rw")) {
            randomAccessFile.write("Test".getBytes());
            randomAccessFile.seek(0);
            // Expecting an IllegalArgumentException when the messageDigest is null
            assertThrows(IllegalArgumentException.class, () -> {
                DigestUtils.updateDigest(null, randomAccessFile);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateDigest_withNullRandomAccessFile() {
        // Expecting a NullPointerException when the RandomAccessFile is null
        assertThrows(NullPointerException.class, () -> {
            DigestUtils.updateDigest(messageDigest, (RandomAccessFile) null);
        });
    }
}
