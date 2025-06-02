package org.apache.commons.codec.digest;

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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class HmacUtils_isAvailable_38_0_Test {

    @Test
    public void testIsAvailable_ValidAlgorithm() {
        assertTrue(HmacUtils.isAvailable("HmacSHA256"));
    }

    @Test
    public void testIsAvailable_InvalidAlgorithm() {
        assertFalse(HmacUtils.isAvailable("InvalidAlgorithm"));
    }

    @Test
    public void testIsAvailable_AnotherValidAlgorithm() {
        assertTrue(HmacUtils.isAvailable("HmacSHA1"));
    }

    @Test
    public void testIsAvailable_NullInput() {
        assertFalse(HmacUtils.isAvailable((String) null));
    }

    @Test
    public void testIsAvailable_EmptyString() {
        assertFalse(HmacUtils.isAvailable(""));
    }
}
