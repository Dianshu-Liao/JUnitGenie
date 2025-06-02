package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class HmacUtils_hmac_46_0_Test {

    private static final String HMAC_SHA256 = "HmacSHA256";

    private static final byte[] KEY = "secret-key".getBytes(StandardCharsets.UTF_8);

    private HmacUtils hmacUtils;

    @BeforeEach
    public void setUp() {
        hmacUtils = new HmacUtils(HMAC_SHA256, KEY);
    }

    @Test
    public void testHmac_ValidInput() {
        String input = "Hello, World!";
        byte[] expectedHmac = new byte[] { -35, -56, 49, -90, -96, 113, 96, -30, -38, 88, 55, -51, -29, -121, -57, 66, -78, -43, 108, -84, -34, 108, 106, -53, 56, -101, 0, -1, -28, 108, -84, -21 };
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmac_EmptyString() {
        String input = "";
        byte[] expectedHmac = new byte[] { -113, -90, -37, -110, -57, -118, 5, -92, -121, -66, -92, -113, -99, 9, -52, 48, -30, -37, 54, -96, -98, -37, -121, -106, -20, -69, 51, -23, 106, 94, 92, 54 };
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmac_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            hmacUtils.hmac((String) null);
        });
    }

    @Test
    public void testHmac_SpecialCharacters() {
        String input = "!@#$%^&*()_+";
        byte[] expectedHmac = new byte[] { -116, 54, -100, -123, -19, 41, 94, 113, -121, 51, 16, -31, 67, 85, 119, -36, -77, -104, -101, -61, 48, -116, -101, -64, 83, 58, 122, -39, 118, 84, -91, -108 };
        byte[] actualHmac = hmacUtils.hmac(input);
        assertArrayEquals(expectedHmac, actualHmac);
    }
}
