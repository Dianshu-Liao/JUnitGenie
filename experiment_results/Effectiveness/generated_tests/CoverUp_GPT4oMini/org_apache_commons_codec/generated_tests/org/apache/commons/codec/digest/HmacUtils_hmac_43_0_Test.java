package org.apache.commons.codec.digest;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.HmacUtils;
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

public class HmacUtils_hmac_43_0_Test {

    private HmacUtils hmacUtils;

    private byte[] key;

    private ByteBuffer valueToDigest;

    @BeforeEach
    public void setUp() {
        key = "secret".getBytes();
        hmacUtils = new HmacUtils("HmacSHA256", key);
        valueToDigest = ByteBuffer.wrap("message".getBytes());
    }

    @Test
    public void testHmac() {
        byte[] expectedHmac = getExpectedHmac("HmacSHA256", key, "message");
        byte[] actualHmac = hmacUtils.hmac(valueToDigest);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmacWithNullKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HmacUtils("HmacSHA256", (byte[]) null);
        });
    }

    @Test
    public void testHmacWithEmptyByteBuffer() {
        ByteBuffer emptyBuffer = ByteBuffer.wrap(new byte[0]);
        byte[] expectedHmac = getExpectedHmac("HmacSHA256", key, "");
        byte[] actualHmac = hmacUtils.hmac(emptyBuffer);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    private byte[] getExpectedHmac(String algorithm, byte[] key, String message) {
        try {
            Mac mac = Mac.getInstance(algorithm);
            SecretKeySpec keySpec = new SecretKeySpec(key, algorithm);
            mac.init(keySpec);
            return mac.doFinal(message.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
