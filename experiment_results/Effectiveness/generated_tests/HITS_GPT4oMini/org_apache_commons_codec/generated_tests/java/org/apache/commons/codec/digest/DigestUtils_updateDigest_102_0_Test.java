package org.apache.commons.codec.digest;

import java.nio.ByteBuffer;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_102_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigestWithNonEmptyByteBuffer() {
        ByteBuffer buffer = ByteBuffer.wrap("Test Data".getBytes());
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, buffer);
        byte[] expectedDigest = messageDigest.digest();
        byte[] actualDigest = updatedDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest, "The digests should match after updating.");
    }

    @Test
    public void testUpdateDigestWithEmptyByteBuffer() {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[0]);
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, buffer);
        byte[] expectedDigest = messageDigest.digest();
        byte[] actualDigest = updatedDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest, "The digests should match after updating with an empty buffer.");
    }

    @Test
    public void testUpdateDigestWithNullByteBuffer() {
        ByteBuffer buffer = null;
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, buffer);
        assertNotNull(updatedDigest, "The updated digest should not be null even when the buffer is null.");
    }

    @Test
    public void testUpdateDigestWithMultipleUpdates() {
        ByteBuffer buffer1 = ByteBuffer.wrap("First Update".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("Second Update".getBytes());
        DigestUtils.updateDigest(messageDigest, buffer1);
        DigestUtils.updateDigest(messageDigest, buffer2);
        byte[] expectedDigest = messageDigest.digest();
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, buffer1);
        updatedDigest = DigestUtils.updateDigest(updatedDigest, buffer2);
        byte[] actualDigest = updatedDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest, "The digests should match after multiple updates.");
    }
}
