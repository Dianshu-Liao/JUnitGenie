package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class HmacUtils_hmac_45_0_Test {

    private HmacUtils hmacUtils;

    private static final String HMAC_SHA256 = "HmacSHA256";

    private static final String SECRET_KEY = "mysecretkey";

    private static final byte[] KEY = SECRET_KEY.getBytes(StandardCharsets.UTF_8);

    @BeforeEach
    public void setUp() {
        hmacUtils = new HmacUtils(HMAC_SHA256, KEY);
    }

    @Test
    public void testHmacWithInputStream() throws Exception {
        String inputData = "Hello, World!";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        byte[] expectedHmac = calculateExpectedHmac(inputData);
        byte[] actualHmac = hmacUtils.hmac(inputStream);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    private byte[] calculateExpectedHmac(String data) throws Exception {
        Mac mac = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec keySpec = new SecretKeySpec(KEY, HMAC_SHA256);
        mac.init(keySpec);
        return mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }
}
