package org.apache.commons.codec.digest;

import java.io.ByteArrayInputStream;
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
import java.io.File;
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

public class DigestUtils_updateDigest_105_0_Test {

    @Test
    public void testUpdateDigestWithEmptyInputStream() throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        MessageDigest result = DigestUtils.updateDigest(digest, inputStream);
        // Verify that the digest is still the same as the initial state (empty)
        byte[] expected = new byte[32];
        assertArrayEquals(expected, result.digest());
    }

    @Test
    public void testUpdateDigestWithNonEmptyInputStream() throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String input = "Hello, World!";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        MessageDigest result = DigestUtils.updateDigest(digest, inputStream);
        // Calculate the expected hash manually
        byte[] expected = MessageDigest.getInstance("SHA-256").digest(input.getBytes());
        assertArrayEquals(expected, result.digest());
    }

    @Test
    public void testUpdateDigestWithLargeInputStream() throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // 2 KB of data
        byte[] input = new byte[2048];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) (i % 256);
        }
        InputStream inputStream = new ByteArrayInputStream(input);
        MessageDigest result = DigestUtils.updateDigest(digest, inputStream);
        // Calculate the expected hash manually
        byte[] expected = MessageDigest.getInstance("SHA-256").digest(input);
        assertArrayEquals(expected, result.digest());
    }

    @Test
    public void testUpdateDigestWithNullInputStream() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Expecting an IOException when updateDigest is called with null InputStream
        Exception exception = null;
        try {
            DigestUtils.updateDigest(digest, (InputStream) null);
        } catch (IOException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
}
