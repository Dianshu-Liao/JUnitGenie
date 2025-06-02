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

class DigestUtils_getDigest_7_0_Test {

    private MessageDigest defaultMessageDigest;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        // Create a default MessageDigest instance for testing
        defaultMessageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    void testGetDigest_ValidAlgorithm_ReturnsMessageDigest() throws NoSuchAlgorithmException {
        // Given a valid algorithm
        String algorithm = "SHA-1";
        // When calling getDigest with a valid algorithm
        MessageDigest result = DigestUtils.getDigest(algorithm, defaultMessageDigest);
        // Then it should return a MessageDigest instance for the specified algorithm
        assertNotNull(result);
        assertEquals("SHA-1", result.getAlgorithm());
    }

    @Test
    void testGetDigest_InvalidAlgorithm_ReturnsDefaultMessageDigest() {
        // Given an invalid algorithm
        String algorithm = "INVALID_ALGORITHM";
        // When calling getDigest with an invalid algorithm
        MessageDigest result = DigestUtils.getDigest(algorithm, defaultMessageDigest);
        // Then it should return the default MessageDigest instance
        assertNotNull(result);
        assertEquals("SHA-256", result.getAlgorithm());
    }

    @Test
    void testGetDigest_NullAlgorithm_ReturnsDefaultMessageDigest() {
        // Given a null algorithm
        String algorithm = null;
        // When calling getDigest with a null algorithm
        MessageDigest result = DigestUtils.getDigest(algorithm, defaultMessageDigest);
        // Then it should return the default MessageDigest instance
        assertNotNull(result);
        assertEquals("SHA-256", result.getAlgorithm());
    }
}
