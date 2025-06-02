package org.apache.commons.codec.digest;

import java.security.MessageDigest;
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
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_isAvailable_22_0_Test {

    @Test
    public void testIsAvailableWithValidAlgorithm() {
        assertTrue(DigestUtils.isAvailable("MD5"));
        assertTrue(DigestUtils.isAvailable("SHA-1"));
        assertTrue(DigestUtils.isAvailable("SHA-256"));
        assertTrue(DigestUtils.isAvailable("SHA-512"));
    }

    @Test
    public void testIsAvailableWithInvalidAlgorithm() {
        assertFalse(DigestUtils.isAvailable("INVALID_ALGORITHM"));
    }

    @Test
    public void testIsAvailableWithNullAlgorithm() {
        assertFalse(DigestUtils.isAvailable(null));
    }

    @Test
    public void testIsAvailableWithEmptyAlgorithm() {
        assertFalse(DigestUtils.isAvailable(""));
    }

    // Reflection test for private methods
    @Test
    public void testGetDigestWithValidAlgorithm() throws Exception {
        // Accessing the private method getDigest using reflection
        java.lang.reflect.Method method = DigestUtils.class.getDeclaredMethod("getDigest", String.class, MessageDigest.class);
        method.setAccessible(true);
        // Calling the method with a valid algorithm
        MessageDigest result = (MessageDigest) method.invoke(null, "MD5", null);
        assertNotNull(result);
    }

    @Test
    public void testGetDigestWithInvalidAlgorithm() throws Exception {
        // Accessing the private method getDigest using reflection
        java.lang.reflect.Method method = DigestUtils.class.getDeclaredMethod("getDigest", String.class, MessageDigest.class);
        method.setAccessible(true);
        // Calling the method with an invalid algorithm
        MessageDigest result = (MessageDigest) method.invoke(null, "INVALID_ALGORITHM", null);
        assertNull(result);
    }
}
