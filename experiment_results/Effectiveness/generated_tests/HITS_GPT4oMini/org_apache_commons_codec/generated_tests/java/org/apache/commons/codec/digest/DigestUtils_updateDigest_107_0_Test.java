package org.apache.commons.codec.digest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_updateDigest_107_0_Test {

    @Test
    public void testUpdateDigest() throws IOException, NoSuchAlgorithmException {
        // Prepare a temporary file with known content
        File tempFile = File.createTempFile("testFile", ".txt");
        tempFile.deleteOnExit();
        String content = "Hello, World!";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(tempFile, "rw")) {
            randomAccessFile.writeBytes(content);
        }
        // Create a MessageDigest instance for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // Call the method under test
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(tempFile, "r")) {
            DigestUtils.updateDigest(digest, randomAccessFile);
        }
        // Verify the result
        // MD5 of "Hello, World!"
        byte[] expectedDigest = new byte[] { -52, -41, -10, -38, 105, -59, 112, -103, 119, 85, -6, 44, -85, -8, -38, -14 };
        assertArrayEquals(expectedDigest, digest.digest());
    }
}
