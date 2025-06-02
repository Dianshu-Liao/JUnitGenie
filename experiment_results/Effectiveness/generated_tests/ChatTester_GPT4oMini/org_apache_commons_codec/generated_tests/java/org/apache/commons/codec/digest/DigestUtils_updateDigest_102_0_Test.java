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

class DigestUtils_updateDigest_102_0_Test {

    private MessageDigest messageDigest;

    private DigestUtils digestUtils;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
        digestUtils = new DigestUtils(messageDigest);
    }

    @Test
    void testUpdateDigest_withValidByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap("test".getBytes());
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, byteBuffer);
        assertNotNull(updatedDigest);
        assertArrayEquals(messageDigest.digest(), updatedDigest.digest());
    }

    @Test
    void testUpdateDigest_withEmptyByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[0]);
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, byteBuffer);
        assertNotNull(updatedDigest);
        assertArrayEquals(messageDigest.digest(), updatedDigest.digest());
    }

    @Test
    void testUpdateDigest_withNullByteBuffer() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the ambiguity by using the correct method signature
            DigestUtils.updateDigest(messageDigest, (ByteBuffer) null);
        });
    }
}
