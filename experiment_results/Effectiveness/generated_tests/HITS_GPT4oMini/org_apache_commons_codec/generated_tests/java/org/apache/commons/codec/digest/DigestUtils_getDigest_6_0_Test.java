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

public class DigestUtils_getDigest_6_0_Test {

    @Test
    public void testGetMd5Digest() {
        MessageDigest md5Digest = DigestUtils.getMd5Digest();
        assertNotNull(md5Digest, "MD5 digest should not be null");
        assertEquals("MD5", md5Digest.getAlgorithm(), "Algorithm should be MD5");
    }

    @Test
    public void testGetSha1Digest() {
        MessageDigest sha1Digest = DigestUtils.getSha1Digest();
        assertNotNull(sha1Digest, "SHA-1 digest should not be null");
        assertEquals("SHA-1", sha1Digest.getAlgorithm(), "Algorithm should be SHA-1");
    }

    @Test
    public void testGetSha256Digest() {
        MessageDigest sha256Digest = DigestUtils.getSha256Digest();
        assertNotNull(sha256Digest, "SHA-256 digest should not be null");
        assertEquals("SHA-256", sha256Digest.getAlgorithm(), "Algorithm should be SHA-256");
    }

    @Test
    public void testGetSha512Digest() {
        MessageDigest sha512Digest = DigestUtils.getSha512Digest();
        assertNotNull(sha512Digest, "SHA-512 digest should not be null");
        assertEquals("SHA-512", sha512Digest.getAlgorithm(), "Algorithm should be SHA-512");
    }

    @Test
    public void testGetSha384Digest() {
        MessageDigest sha384Digest = DigestUtils.getSha384Digest();
        assertNotNull(sha384Digest, "SHA-384 digest should not be null");
        assertEquals("SHA-384", sha384Digest.getAlgorithm(), "Algorithm should be SHA-384");
    }

    @Test
    public void testGetInvalidDigest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DigestUtils.getDigest("INVALID_ALGORITHM");
        });
        String expectedMessage = "java.security.NoSuchAlgorithmException";
        String actualMessage = exception.getCause().toString();
        assertTrue(actualMessage.contains(expectedMessage), "Should throw IllegalArgumentException for invalid algorithm");
    }
}
