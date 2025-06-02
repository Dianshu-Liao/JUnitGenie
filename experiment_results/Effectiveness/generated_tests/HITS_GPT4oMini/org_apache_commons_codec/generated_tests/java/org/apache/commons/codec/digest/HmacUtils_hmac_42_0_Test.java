package org.apache.commons.codec.digest;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class HmacUtils_hmac_42_0_Test {

    private static final String ALGORITHM = "HmacSHA256";

    private static final byte[] KEY = "secret-key".getBytes();

    private HmacUtils hmacUtils;

    @BeforeEach
    public void setUp() {
        hmacUtils = new HmacUtils(ALGORITHM, KEY);
    }

    @Test
    public void testHmac_ValidInput() {
        byte[] input = "Hello, World!".getBytes();
        byte[] expectedHmac = calculateExpectedHmac(input);
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmac_EmptyInput() {
        byte[] input = new byte[0];
        byte[] expectedHmac = calculateExpectedHmac(input);
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmac_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            hmacUtils.hmac((byte[]) null);
        });
    }

    @Test
    public void testHmac_InvalidKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HmacUtils(ALGORITHM, (byte[]) null);
        });
    }

    private byte[] calculateExpectedHmac(byte[] input) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(KEY, ALGORITHM);
            mac.init(keySpec);
            return mac.doFinal(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate expected HMAC", e);
        }
    }
}
