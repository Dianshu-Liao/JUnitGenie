package org.apache.commons.codec.digest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.StringUtils;
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
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class HmacUtils_hmac_44_0_Test {

    private static final String HMAC_SHA256 = "HmacSHA256";

    private static final byte[] KEY = "secret".getBytes();

    private static final String TEST_FILE_NAME = "testFile.txt";

    private File testFile;

    @BeforeEach
    public void setUp() throws IOException {
        testFile = new File(TEST_FILE_NAME);
        // Create a test file with some content
        Files.write(testFile.toPath(), "Hello, World!".getBytes(), StandardOpenOption.CREATE);
    }

    @AfterEach
    public void tearDown() {
        // Clean up test file
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testHmac_ValidFile() throws Exception {
        HmacUtils hmacUtils = new HmacUtils(HMAC_SHA256, KEY);
        byte[] expectedHmac = calculateExpectedHmac("Hello, World!", KEY);
        byte[] actualHmac = hmacUtils.hmac(testFile);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmac_EmptyFile() throws Exception {
        File emptyFile = new File("emptyFile.txt");
        emptyFile.createNewFile();
        HmacUtils hmacUtils = new HmacUtils(HMAC_SHA256, KEY);
        byte[] expectedHmac = calculateExpectedHmac("", KEY);
        byte[] actualHmac = hmacUtils.hmac(emptyFile);
        assertArrayEquals(expectedHmac, actualHmac);
        emptyFile.delete();
    }

    @Test
    public void testHmac_NonExistentFile() {
        HmacUtils hmacUtils = new HmacUtils(HMAC_SHA256, KEY);
        assertThrows(IOException.class, () -> {
            hmacUtils.hmac(new File("nonExistentFile.txt"));
        });
    }

    private byte[] calculateExpectedHmac(String data, byte[] key) throws Exception {
        Mac mac = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, HMAC_SHA256);
        mac.init(secretKeySpec);
        return mac.doFinal(data.getBytes());
    }
}
