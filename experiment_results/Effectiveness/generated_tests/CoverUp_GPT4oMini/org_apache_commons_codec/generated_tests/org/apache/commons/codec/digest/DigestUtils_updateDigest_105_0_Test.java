package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_105_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        // Initialize the MessageDigest instance
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigestWithFullBuffer() throws IOException {
        // Input stream with data
        byte[] data = "Hello, World!".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        // Update digest
        MessageDigest result = DigestUtils.updateDigest(messageDigest, inputStream);
        // Expected hash
        byte[] expectedHash = messageDigest.digest(data);
        // Assert the result
        assertArrayEquals(expectedHash, result.digest());
    }

    @Test
    public void testUpdateDigestWithEmptyStream() throws IOException {
        // Empty input stream
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        // Update digest
        MessageDigest result = DigestUtils.updateDigest(messageDigest, inputStream);
        // Expected hash
        byte[] expectedHash = messageDigest.digest(new byte[0]);
        // Assert the result
        assertArrayEquals(expectedHash, result.digest());
    }

    @Test
    public void testUpdateDigestWithPartialBuffer() throws IOException {
        // Input stream with data
        byte[] data = "Hello".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        // Update digest
        MessageDigest result = DigestUtils.updateDigest(messageDigest, inputStream);
        // Expected hash
        byte[] expectedHash = messageDigest.digest(data);
        // Assert the result
        assertArrayEquals(expectedHash, result.digest());
    }

    @Test
    public void testUpdateDigestWithLargeData() throws IOException {
        // Input stream with large data
        // 2 KB of data
        byte[] data = new byte[2048];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        InputStream inputStream = new ByteArrayInputStream(data);
        // Update digest
        MessageDigest result = DigestUtils.updateDigest(messageDigest, inputStream);
        // Expected hash
        byte[] expectedHash = messageDigest.digest(data);
        // Assert the result
        assertArrayEquals(expectedHash, result.digest());
    }
}
