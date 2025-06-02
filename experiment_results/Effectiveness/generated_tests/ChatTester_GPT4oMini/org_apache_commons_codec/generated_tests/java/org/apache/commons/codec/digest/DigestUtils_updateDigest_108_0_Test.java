// Test method
package org.apache.commons.codec.digest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

class DigestUtils_updateDigest_108_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    void testUpdateDigest_withValidString() throws NoSuchAlgorithmException {
        String valueToDigest = "Hello, World!";
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, valueToDigest);
        assertNotNull(updatedDigest);
        byte[] expectedDigest = MessageDigest.getInstance("SHA-256").digest(valueToDigest.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    void testUpdateDigest_withEmptyString() throws NoSuchAlgorithmException {
        String valueToDigest = "";
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, valueToDigest);
        assertNotNull(updatedDigest);
        byte[] expectedDigest = MessageDigest.getInstance("SHA-256").digest(valueToDigest.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    void testUpdateDigest_withNullString() {
        String valueToDigest = null;
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, valueToDigest);
        assertNotNull(updatedDigest);
        // Since we're passing null, we check that the digest state is unchanged
        byte[] initialDigest = messageDigest.digest();
        assertArrayEquals(initialDigest, updatedDigest.digest());
    }
}
