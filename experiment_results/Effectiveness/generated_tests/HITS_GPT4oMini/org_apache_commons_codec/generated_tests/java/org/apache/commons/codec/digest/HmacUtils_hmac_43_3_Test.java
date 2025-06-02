package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
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
import java.security.InvalidKeyException;
import java.security.Key;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class HmacUtils_hmac_43_3_Test {

    private static final String ALGORITHM = "HmacSHA256";

    private static final byte[] KEY = "secret-key".getBytes();

    private HmacUtils hmacUtils;

    @BeforeEach
    public void setUp() {
        hmacUtils = new HmacUtils(ALGORITHM, KEY);
    }

    @Test
    public void testHmacWithValidInput() {
        ByteBuffer input = ByteBuffer.wrap("Hello, World!".getBytes());
        byte[] expectedHmac = computeExpectedHmac(input);
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmacWithEmptyInput() {
        ByteBuffer input = ByteBuffer.wrap("".getBytes());
        byte[] expectedHmac = computeExpectedHmac(input);
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmacWithNullKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HmacUtils(ALGORITHM, (byte[]) null);
        });
    }

    @Test
    public void testHmacWithInvalidAlgorithm() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HmacUtils("InvalidAlgorithm", KEY);
        });
    }

    private byte[] computeExpectedHmac(ByteBuffer input) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(KEY, ALGORITHM);
            mac.init(keySpec);
            mac.update(input);
            return mac.doFinal();
        } catch (Exception e) {
            throw new RuntimeException("Failed to compute expected HMAC", e);
        }
    }
}
