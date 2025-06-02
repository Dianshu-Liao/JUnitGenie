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
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigest_ValidInput() {
        byte[] valueToDigest = "test".getBytes();
        // Update the digest with the byte array
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, valueToDigest);
        // Verify that the digest has been updated correctly
        byte[] expectedDigest = updatedDigest.digest();
        // Reset the message digest for a new calculation
        messageDigest.reset();
        messageDigest.update(valueToDigest);
        byte[] actualDigest = messageDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest);
    }

    @Test
    public void testUpdateDigest_EmptyInput() {
        byte[] valueToDigest = new byte[0];
        // Update the digest with the empty byte array
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, valueToDigest);
        // Verify that the digest has been updated correctly
        byte[] expectedDigest = updatedDigest.digest();
        // Reset the message digest for a new calculation
        messageDigest.reset();
        messageDigest.update(valueToDigest);
        byte[] actualDigest = messageDigest.digest();
        assertArrayEquals(expectedDigest, actualDigest);
    }

    @Test
    public void testUpdateDigest_NullInput() {
        byte[] valueToDigest = null;
        // Expecting an IllegalArgumentException when passing null
        try {
            DigestUtils.updateDigest(messageDigest, valueToDigest);
        } catch (IllegalArgumentException e) {
            // Expected exception
            return;
        }
        // If we reach this point, the exception was not thrown
        throw new AssertionError("Expected IllegalArgumentException was not thrown.");
    }
}
