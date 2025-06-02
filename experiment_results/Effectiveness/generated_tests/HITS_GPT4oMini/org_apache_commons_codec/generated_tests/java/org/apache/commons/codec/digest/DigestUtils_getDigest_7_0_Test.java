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

public class DigestUtils_getDigest_7_0_Test {

    @Test
    public void testGetMd5Digest() {
        MessageDigest md5Digest = DigestUtils.getMd5Digest();
        assertNotNull(md5Digest, "MD5 Digest should not be null");
    }

    @Test
    public void testGetSha1Digest() {
        MessageDigest sha1Digest = DigestUtils.getSha1Digest();
        assertNotNull(sha1Digest, "SHA-1 Digest should not be null");
    }

    @Test
    public void testGetSha256Digest() {
        MessageDigest sha256Digest = DigestUtils.getSha256Digest();
        assertNotNull(sha256Digest, "SHA-256 Digest should not be null");
    }

    @Test
    public void testGetDigestWithValidAlgorithm() {
        String algorithm = "SHA-256";
        MessageDigest digest = DigestUtils.getDigest(algorithm, null);
        assertNotNull(digest, "Digest should not be null for valid algorithm");
    }

    @Test
    public void testGetDigestWithInvalidAlgorithm() {
        String algorithm = "INVALID_ALGORITHM";
        MessageDigest defaultDigest = DigestUtils.getMd5Digest();
        MessageDigest digest = DigestUtils.getDigest(algorithm, defaultDigest);
        assertNotNull(digest, "Should return default digest when algorithm is invalid");
    }

    @Test
    public void testGetDigestWithNullAlgorithm() {
        MessageDigest defaultDigest = DigestUtils.getMd5Digest();
        MessageDigest digest = DigestUtils.getDigest(null, defaultDigest);
        assertNotNull(digest, "Should return default digest when algorithm is null");
    }

    @Test
    public void testGetDigestWithEmptyAlgorithm() {
        String algorithm = "";
        MessageDigest defaultDigest = DigestUtils.getMd5Digest();
        MessageDigest digest = DigestUtils.getDigest(algorithm, defaultDigest);
        assertNotNull(digest, "Should return default digest when algorithm is empty");
    }
}
