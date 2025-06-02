package org.apache.commons.codec.digest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DigestUtils_updateDigest_104_0_Test {

    private DigestUtils digestUtils;

    private MessageDigest messageDigest;

    private FileChannel fileChannel;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
        digestUtils = new DigestUtils(messageDigest);
        fileChannel = mock(FileChannel.class);
    }

    @Test
    public void testUpdateDigestWithEmptyFileChannel() throws IOException {
        // Arrange
        when(fileChannel.read(any(ByteBuffer.class))).thenReturn(0);
        // Fixed Buggy Line: Handle the IOException
        try {
            invokePrivateUpdateDigest(digestUtils, messageDigest, fileChannel);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        // Assert
        byte[] expectedDigest = messageDigest.digest();
        // SHA-256 produces a 32-byte hash of empty input
        assertArrayEquals(new byte[32], expectedDigest);
    }

    @Test
    public void testUpdateDigestWithData() throws IOException, NoSuchAlgorithmException {
        // Arrange
        ByteBuffer buffer = ByteBuffer.allocate(DigestUtils.BUFFER_SIZE);
        buffer.put("Hello, World!".getBytes());
        buffer.flip();
        // Simulate end of stream
        when(fileChannel.read(any(ByteBuffer.class))).thenReturn(buffer.remaining()).thenReturn(0);
        // Fixed Buggy Line: Handle the IOException
        try {
            invokePrivateUpdateDigest(digestUtils, messageDigest, fileChannel);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        // Assert
        byte[] expectedDigest = messageDigest.digest();
        byte[] actualDigest = MessageDigest.getInstance("SHA-256").digest("Hello, World!".getBytes());
        assertArrayEquals(actualDigest, expectedDigest);
    }

    private void invokePrivateUpdateDigest(DigestUtils digestUtils, MessageDigest digest, FileChannel data) throws Exception {
        java.lang.reflect.Method method = DigestUtils.class.getDeclaredMethod("updateDigest", MessageDigest.class, FileChannel.class);
        method.setAccessible(true);
        method.invoke(digestUtils, digest, data);
    }
}
