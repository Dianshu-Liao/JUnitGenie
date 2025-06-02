package org.apache.commons.codec.digest;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;
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

class DigestUtils_updateDigest_102_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    void testUpdateDigestWithNonEmptyBuffer() {
        ByteBuffer buffer = ByteBuffer.wrap("Hello, World!".getBytes());
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, buffer);
        assertNotNull(updatedDigest);
        assertArrayEquals(messageDigest.digest(), updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithEmptyBuffer() {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[0]);
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, buffer);
        assertNotNull(updatedDigest);
        assertArrayEquals(messageDigest.digest(), updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithMultipleUpdates() {
        ByteBuffer buffer1 = ByteBuffer.wrap("Hello".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap(", World!".getBytes());
        DigestUtils.updateDigest(messageDigest, buffer1);
        DigestUtils.updateDigest(messageDigest, buffer2);
        byte[] digestResult = messageDigest.digest();
        assertNotNull(digestResult);
    }
}
