package org.apache.commons.codec.digest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_104_0_Test {

    private File tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = File.createTempFile("testFile", ".tmp");
        tempFile.deleteOnExit();
    }

    @Test
    public void testUpdateDigestWithEmptyFile() throws IOException, NoSuchAlgorithmException {
        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            // No data is written, so the file is empty
        }
        try (FileInputStream inputStream = new FileInputStream(tempFile)) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            MessageDigest result = DigestUtils.updateDigest(messageDigest, inputStream);
            byte[] expectedDigest = new byte[32];
            assertArrayEquals(expectedDigest, result.digest());
        }
    }

    @Test
    public void testUpdateDigestWithNonEmptyFile() throws IOException, NoSuchAlgorithmException {
        String content = "Hello, World!";
        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
        try (FileInputStream inputStream = new FileInputStream(tempFile)) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            MessageDigest result = DigestUtils.updateDigest(messageDigest, inputStream);
            byte[] expectedDigest = MessageDigest.getInstance("SHA-256").digest(content.getBytes(StandardCharsets.UTF_8));
            assertArrayEquals(expectedDigest, result.digest());
        }
    }
}
