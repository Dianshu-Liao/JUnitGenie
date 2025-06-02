package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
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
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

// Assuming HmacAlgorithms is an enum with a method getName() returning algorithm names
enum HmacAlgorithms {

    HMAC_SHA256("HmacSHA256"), HMAC_SHA1("HmacSHA1"), HMAC_MD5("HmacMD5"), INVALID_ALGORITHM("InvalidAlgorithm");

    private final String name;

    HmacAlgorithms(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class HmacUtils_isAvailable_37_0_Test {

    @Test
    void testIsAvailableWithValidAlgorithm() {
        assertTrue(HmacUtils.isAvailable(HmacAlgorithms.HMAC_SHA256));
        assertTrue(HmacUtils.isAvailable(HmacAlgorithms.HMAC_SHA1));
        assertTrue(HmacUtils.isAvailable(HmacAlgorithms.HMAC_MD5));
    }

    @Test
    void testIsAvailableWithInvalidAlgorithm() {
        assertFalse(HmacUtils.isAvailable(HmacAlgorithms.INVALID_ALGORITHM));
    }
}
