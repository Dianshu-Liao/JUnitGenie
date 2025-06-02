package org.apache.commons.codec.digest;

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
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigestWithValidInputStream() throws IOException {
        String data = "Hello, World!";
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, inputStream);
        byte[] expectedDigest = messageDigest.digest();
        byte[] actualDigest = resultDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest);
    }

    @Test
    public void testUpdateDigestWithEmptyInputStream() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, inputStream);
        byte[] expectedDigest = messageDigest.digest();
        byte[] actualDigest = resultDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest);
    }

    @Test
    public void testUpdateDigestWithNullInputStream() {
        assertThrows(NullPointerException.class, () -> {
            DigestUtils.updateDigest(messageDigest, (InputStream) null);
        });
    }

    @Test
    public void testUpdateDigestWithLargeInputStream() throws IOException {
        // 2 KB of data
        byte[] largeData = new byte[2048];
        for (int i = 0; i < largeData.length; i++) {
            largeData[i] = (byte) (i % 256);
        }
        InputStream inputStream = new ByteArrayInputStream(largeData);
        MessageDigest resultDigest = DigestUtils.updateDigest(messageDigest, inputStream);
        byte[] expectedDigest = messageDigest.digest();
        byte[] actualDigest = resultDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest);
    }
}
