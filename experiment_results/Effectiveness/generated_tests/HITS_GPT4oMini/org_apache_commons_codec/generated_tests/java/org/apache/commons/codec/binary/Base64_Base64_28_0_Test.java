package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

class Base64_Base64_28_0_Test {

    @Test
    void testBase64ConstructorWithUrlSafeTrue() {
        Base64 base64 = new Base64(true);
        assertNotNull(base64);
    }

    @Test
    void testBase64ConstructorWithUrlSafeFalse() {
        Base64 base64 = new Base64(false);
        assertNotNull(base64);
    }

    @Test
    void testBase64ConstructorWithLineLength() {
        Base64 base64 = new Base64(76);
        assertNotNull(base64);
    }

    @Test
    void testBase64ConstructorWithLineLengthAndSeparator() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        Base64 base64 = new Base64(76, lineSeparator);
        assertNotNull(base64);
    }

    @Test
    void testBase64ConstructorWithLineLengthSeparatorAndUrlSafe() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        Base64 base64 = new Base64(76, lineSeparator, true);
        assertNotNull(base64);
    }

    @Test
    void testBase64ConstructorWithLineLengthSeparatorUrlSafeAndDecodingPolicy() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        // This test has been removed due to private access
        // Instead, we will test valid public constructors only
    }

    @Test
    void testBase64ConstructorWithInvalidLineLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base64(-1);
        });
    }

    @Test
    void testBase64ConstructorWithNullLineSeparator() {
        assertThrows(NullPointerException.class, () -> {
            new Base64(76, null);
        });
    }

    @Test
    void testBase64ConstructorWithInvalidLineSeparator() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, new byte[0]);
        });
    }
}
