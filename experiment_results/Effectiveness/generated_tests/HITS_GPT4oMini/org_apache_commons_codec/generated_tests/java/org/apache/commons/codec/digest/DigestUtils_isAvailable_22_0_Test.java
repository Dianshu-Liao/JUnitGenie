package org.apache.commons.codec.digest;

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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_isAvailable_22_0_Test {

    @Test
    public void testIsAvailableWithValidAlgorithmMd5() {
        assertTrue(DigestUtils.isAvailable("MD5"), "MD5 should be available");
    }

    @Test
    public void testIsAvailableWithValidAlgorithmSha1() {
        assertTrue(DigestUtils.isAvailable("SHA-1"), "SHA-1 should be available");
    }

    @Test
    public void testIsAvailableWithValidAlgorithmSha256() {
        assertTrue(DigestUtils.isAvailable("SHA-256"), "SHA-256 should be available");
    }

    @Test
    public void testIsAvailableWithValidAlgorithmSha512() {
        assertTrue(DigestUtils.isAvailable("SHA-512"), "SHA-512 should be available");
    }

    @Test
    public void testIsAvailableWithInvalidAlgorithm() {
        assertFalse(DigestUtils.isAvailable("INVALID_ALGORITHM"), "INVALID_ALGORITHM should not be available");
    }

    @Test
    public void testIsAvailableWithNullAlgorithm() {
        assertFalse(DigestUtils.isAvailable(null), "Null algorithm should not be available");
    }

    @Test
    public void testIsAvailableWithEmptyString() {
        assertFalse(DigestUtils.isAvailable(""), "Empty string should not be available");
    }
}
