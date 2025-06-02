package org.apache.commons.codec.digest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.io.BufferedInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

class DigestUtils_updateDigest_106_4_Test {

    private MessageDigest messageDigest;

    private Path tempFilePath;

    @BeforeEach
    void setUp() throws Exception {
        messageDigest = MessageDigest.getInstance("SHA-256");
        tempFilePath = Files.createTempFile("testfile", ".txt");
        Files.write(tempFilePath, "test data".getBytes());
    }

    @Test
    void testUpdateDigestWithValidInput() throws IOException {
        OpenOption[] options = new OpenOption[0];
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, tempFilePath, options);
        byte[] expectedDigest = messageDigest.digest();
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithEmptyFile() throws IOException {
        Path emptyFilePath = Files.createTempFile("emptyfile", ".txt");
        OpenOption[] options = new OpenOption[0];
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, emptyFilePath, options);
        assertNotNull(updatedDigest);
        // SHA-256 produces a 32-byte output
        assertArrayEquals(new byte[32], updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithIOException() {
        Path invalidPath = mock(Path.class);
        OpenOption[] options = new OpenOption[0];
        assertThrows(IOException.class, () -> {
            DigestUtils.updateDigest(messageDigest, invalidPath, options);
        });
    }

    @Test
    void testUpdateDigestWithMultipleOpenOptions() throws IOException {
        OpenOption[] options = { StandardOpenOption.READ, StandardOpenOption.WRITE };
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, tempFilePath, options);
        byte[] expectedDigest = messageDigest.digest();
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @Test
    void testUpdateDigestWithNullOptions() throws IOException {
        MessageDigest updatedDigest = DigestUtils.updateDigest(messageDigest, tempFilePath, (OpenOption[]) null);
        byte[] expectedDigest = messageDigest.digest();
        assertArrayEquals(expectedDigest, updatedDigest.digest());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFilePath);
    }
}
