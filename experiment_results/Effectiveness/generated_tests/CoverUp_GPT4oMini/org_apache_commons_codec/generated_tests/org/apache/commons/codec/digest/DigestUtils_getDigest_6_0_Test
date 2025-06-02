package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
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
        Assertions.assertNotNull(md5Digest);
        Assertions.assertEquals("MD5", md5Digest.getAlgorithm());
    }

    @Test
    public void testGetSha1Digest() {
        MessageDigest sha1Digest = DigestUtils.getSha1Digest();
        Assertions.assertNotNull(sha1Digest);
        Assertions.assertEquals("SHA-1", sha1Digest.getAlgorithm());
    }

    @Test
    public void testGetSha256Digest() {
        MessageDigest sha256Digest = DigestUtils.getSha256Digest();
        Assertions.assertNotNull(sha256Digest);
        Assertions.assertEquals("SHA-256", sha256Digest.getAlgorithm());
    }

    @Test
    public void testGetDigestWithValidAlgorithm() {
        String algorithm = "SHA-512";
        MessageDigest digest = DigestUtils.getDigest(algorithm);
        Assertions.assertNotNull(digest);
        Assertions.assertEquals("SHA-512", digest.getAlgorithm());
    }

    @Test
    public void testGetDigestWithInvalidAlgorithm() {
        String invalidAlgorithm = "INVALID_ALGORITHM";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DigestUtils.getDigest(invalidAlgorithm);
        });
    }
}
