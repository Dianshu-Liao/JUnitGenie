package org.apache.commons.codec.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.StringUtils;
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

public class DigestUtils_updateDigest_108_0_Test {

    private MessageDigest messageDigest;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    @Test
    public void testUpdateDigestWithNonEmptyString() {
        String input = "testString";
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        assertNotNull(updatedDigest);
        byte[] expectedDigest = messageDigest.digest(StringUtils.getBytesUtf8(input));
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    public void testUpdateDigestWithEmptyString() {
        String input = "";
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        assertNotNull(updatedDigest);
        byte[] expectedDigest = messageDigest.digest(StringUtils.getBytesUtf8(input));
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    public void testUpdateDigestWithNullString() {
        String input = null;
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, input);
        assertNotNull(updatedDigest);
        byte[] expectedDigest = messageDigest.digest(StringUtils.getBytesUtf8(""));
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }
}
