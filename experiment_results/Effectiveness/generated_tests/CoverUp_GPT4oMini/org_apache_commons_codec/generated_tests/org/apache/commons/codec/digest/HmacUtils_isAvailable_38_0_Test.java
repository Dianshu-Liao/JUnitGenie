package org.apache.commons.codec.digest;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HmacUtils_isAvailable_38_0_Test {

    @Test
    public void testIsAvailableWithValidAlgorithm() {
        // Test with a valid algorithm
        assertTrue(invokeIsAvailable("HmacSHA256"));
    }

    @Test
    public void testIsAvailableWithInvalidAlgorithm() {
        // Test with an invalid algorithm
        assertFalse(invokeIsAvailable("InvalidAlgorithm"));
    }

    @Test
    public void testIsAvailableWithNullAlgorithm() {
        // Test with a null algorithm
        assertFalse(invokeIsAvailable(null));
    }

    @Test
    public void testIsAvailableWithEmptyString() {
        // Test with an empty string
        assertFalse(invokeIsAvailable(""));
    }

    private boolean invokeIsAvailable(String algorithm) {
        try {
            return (boolean) HmacUtils.class.getDeclaredMethod("isAvailable", String.class).invoke(null, algorithm);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            // This line will never be reached due to fail()
            return false;
        }
    }
}
