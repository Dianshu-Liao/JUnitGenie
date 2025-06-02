package org.apache.commons.codec.digest;

import org.apache.commons.codec.binary.StringUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
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
import org.apache.commons.codec.binary.Hex;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HmacUtils_hmac_42_3_Test {

    private HmacUtils hmacUtils;

    @BeforeEach
    public void setUp() {
        // Initialize with a known algorithm and key
        String algorithm = "HmacSHA256";
        byte[] key = "testKey".getBytes();
        hmacUtils = new HmacUtils(algorithm, key);
    }

    @Test
    public void testHmac_ValidInput() {
        byte[] input = "testInput".getBytes();
        byte[] expectedHmac = calculateExpectedHmac(input);
        byte[] actualHmac = invokeHmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmac_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeHmac(null);
        });
    }

    @Test
    public void testHmac_EmptyInput() {
        byte[] input = new byte[0];
        byte[] expectedHmac = calculateExpectedHmac(input);
        byte[] actualHmac = invokeHmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    private byte[] calculateExpectedHmac(byte[] input) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec keySpec = new SecretKeySpec("testKey".getBytes(), "HmacSHA256");
            mac.init(keySpec);
            return mac.doFinal(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testHmac_AlgorithmNotSupported() {
        String invalidAlgorithm = "InvalidAlgorithm";
        byte[] key = "testKey".getBytes();
        assertThrows(IllegalArgumentException.class, () -> {
            new HmacUtils(invalidAlgorithm, key);
        });
    }

    private byte[] invokeHmac(byte[] input) {
        try {
            Method method = HmacUtils.class.getDeclaredMethod("hmac", byte[].class);
            method.setAccessible(true);
            return (byte[]) method.invoke(hmacUtils, (Object) input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
