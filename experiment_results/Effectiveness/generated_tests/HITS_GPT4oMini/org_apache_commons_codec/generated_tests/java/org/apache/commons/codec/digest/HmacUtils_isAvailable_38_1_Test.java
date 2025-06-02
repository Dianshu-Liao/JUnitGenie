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

public class HmacUtils_isAvailable_38_1_Test {

    @Test
    public void testIsAvailable_WithValidAlgorithm() {
        // Test with a valid algorithm name
        assertTrue(HmacUtils.isAvailable((String) "HmacSHA256"), "HmacSHA256 should be available");
        assertTrue(HmacUtils.isAvailable((String) "HmacSHA1"), "HmacSHA1 should be available");
        assertTrue(HmacUtils.isAvailable((String) "HmacMD5"), "HmacMD5 should be available");
    }

    @Test
    public void testIsAvailable_WithInvalidAlgorithm() {
        // Test with an invalid algorithm name
        assertFalse(HmacUtils.isAvailable((String) "InvalidAlgorithm"), "InvalidAlgorithm should not be available");
    }

    @Test
    public void testIsAvailable_WithEmptyString() {
        // Test with an empty string
        assertFalse(HmacUtils.isAvailable((String) ""), "Empty string should not be a valid algorithm");
    }

    @Test
    public void testIsAvailable_WithNull() {
        // Test with null input
        assertFalse(HmacUtils.isAvailable((String) null), "Null should not be a valid algorithm");
    }
}
