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
    public void testIsAvailableWithValidAlgorithm() {
        // Test with a valid algorithm name
        String validAlgorithm = "HmacSHA256";
        assertTrue(HmacUtils.isAvailable((String) validAlgorithm), "Expected HmacUtils.isAvailable to return true for valid algorithm: " + validAlgorithm);
    }

    @Test
    public void testIsAvailableWithInvalidAlgorithm() {
        // Test with an invalid algorithm name
        String invalidAlgorithm = "InvalidAlgorithm";
        assertFalse(HmacUtils.isAvailable((String) invalidAlgorithm), "Expected HmacUtils.isAvailable to return false for invalid algorithm: " + invalidAlgorithm);
    }

    @Test
    public void testIsAvailableWithNullAlgorithm() {
        // Test with null algorithm name
        assertFalse(HmacUtils.isAvailable((String) null), "Expected HmacUtils.isAvailable to return false for null algorithm");
    }

    @Test
    public void testIsAvailableWithEmptyString() {
        // Test with an empty string as algorithm name
        assertFalse(HmacUtils.isAvailable((String) ""), "Expected HmacUtils.isAvailable to return false for empty algorithm name");
    }
}
