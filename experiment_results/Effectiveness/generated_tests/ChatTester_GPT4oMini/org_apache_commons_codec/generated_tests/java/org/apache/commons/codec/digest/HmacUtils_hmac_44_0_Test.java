package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HmacUtils_hmac_44_0_Test {

    private HmacUtils hmacUtils;

    private Mac mac;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize the Mac instance with a dummy key for testing
        mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec("testkey".getBytes(), "HmacSHA256");
        mac.init(keySpec);
        // Corrected the initialization of HmacUtils
        hmacUtils = new HmacUtils("HmacSHA256", "testkey".getBytes());
    }

    @Test
    public void testHmac_ValidFile() throws IOException {
        // Create a temporary file with known content
        Path tempFile = Files.createTempFile("hmacTest", ".txt");
        Files.write(tempFile, "Test content".getBytes());
        // Calculate expected HMAC
        byte[] expectedHmac = mac.doFinal(Files.readAllBytes(tempFile));
        // Call the focal method
        byte[] actualHmac = hmacUtils.hmac(tempFile.toFile());
        // Verify the result
        assertArrayEquals(expectedHmac, actualHmac);
        // Clean up
        Files.delete(tempFile);
    }

    @Test
    public void testHmac_FileNotFound() {
        // Test with a non-existent file
        File nonExistentFile = new File("nonExistentFile.txt");
        assertThrows(IOException.class, () -> {
            hmacUtils.hmac(nonExistentFile);
        });
    }

    @Test
    public void testHmac_EmptyFile() throws IOException {
        // Create an empty temporary file
        Path emptyFile = Files.createTempFile("emptyHmacTest", ".txt");
        // Calculate expected HMAC for empty content
        byte[] expectedHmac = mac.doFinal(Files.readAllBytes(emptyFile));
        // Call the focal method
        byte[] actualHmac = hmacUtils.hmac(emptyFile.toFile());
        // Verify the result
        assertArrayEquals(expectedHmac, actualHmac);
        // Clean up
        Files.delete(emptyFile);
    }
}
