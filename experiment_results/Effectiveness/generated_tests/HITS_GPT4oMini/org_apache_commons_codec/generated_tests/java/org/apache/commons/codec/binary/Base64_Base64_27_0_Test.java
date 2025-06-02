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

class Base64_Base64_27_0_Test {

    @Test
    void testDefaultConstructor() {
        Base64 base64 = new Base64();
        assertNotNull(base64);
    }

    @Test
    void testUrlSafeConstructor() {
        Base64 base64UrlSafe = new Base64(true);
        assertNotNull(base64UrlSafe);
    }

    @Test
    void testLineLengthConstructor() {
        Base64 base64WithLineLength = new Base64(76);
        assertNotNull(base64WithLineLength);
    }

    @Test
    void testLineLengthAndSeparatorConstructor() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        Base64 base64WithLineSeparator = new Base64(76, lineSeparator);
        assertNotNull(base64WithLineSeparator);
    }

    @Test
    void testLineLengthSeparatorAndUrlSafeConstructor() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        Base64 base64WithLineLengthAndUrlSafe = new Base64(76, lineSeparator, true);
        assertNotNull(base64WithLineLengthAndUrlSafe);
    }

    @Test
    void testFullConstructor() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        Base64 base64Full = new Base64(76, lineSeparator, true);
        assertNotNull(base64Full);
    }

    @Test
    void testConstructorWithDecodingPolicy() {
        Base64 base64WithPolicy = new Base64(76, new byte[] { '\r', '\n' }, true);
        assertNotNull(base64WithPolicy);
    }

    @Test
    void testConstructorWithAllParameters() {
        byte[] lineSeparator = new byte[] { '\r', '\n' };
        // Use a valid CodecPolicy instance
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        Base64 base64AllParams = new Base64(76, lineSeparator, true, decodingPolicy);
        assertNotNull(base64AllParams);
    }
}
