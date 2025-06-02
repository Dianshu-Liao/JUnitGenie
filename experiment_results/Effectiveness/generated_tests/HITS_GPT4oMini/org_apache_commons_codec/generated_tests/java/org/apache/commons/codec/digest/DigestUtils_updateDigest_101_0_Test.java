package org.apache.commons.codec.digest;

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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_101_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        // Initialize the MessageDigest for testing with SHA-256 algorithm
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigest_withValidInput() {
        byte[] input = "Hello, World!".getBytes();
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        // Verify that the returned MessageDigest is not null
        assertNotNull(updatedDigest);
        // Verify that the message digest has been updated
        byte[] expectedDigest = updatedDigest.digest();
        byte[] actualDigest;
        try {
            actualDigest = DigestUtils.updateDigest(MessageDigest.getInstance("SHA-256"), input).digest();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("SHA-256 algorithm not found", e);
        }
        assertArrayEquals(expectedDigest, actualDigest);
    }

    @Test
    public void testUpdateDigest_withEmptyInput() {
        byte[] input = new byte[0];
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        // Verify that the returned MessageDigest is not null
        assertNotNull(updatedDigest);
        // Verify that the message digest has been updated with empty input
        byte[] expectedDigest = updatedDigest.digest();
        byte[] actualDigest;
        try {
            actualDigest = DigestUtils.updateDigest(MessageDigest.getInstance("SHA-256"), input).digest();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("SHA-256 algorithm not found", e);
        }
        assertArrayEquals(expectedDigest, actualDigest);
    }
}
