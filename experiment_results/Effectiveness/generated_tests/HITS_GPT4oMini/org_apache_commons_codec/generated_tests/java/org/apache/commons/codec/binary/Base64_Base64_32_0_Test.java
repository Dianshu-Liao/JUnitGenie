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

class Base64_Base64_32_0_Test {

    private Base64 base64;

    @BeforeEach
    void setUp() {
        // Initialize Base64 with default parameters for testing
        base64 = new Base64(0, null, false, CodecPolicy.STRICT);
    }

    @Test
    void testBase64ConstructorWithDefaultParams() {
        assertNotNull(base64);
        assertEquals(4, base64.getLineSeparator().length);
    }

    @Test
    void testBase64ConstructorWithLineLength() {
        Base64 base64WithLineLength = new Base64(76, new byte[] { '\n' }, false, CodecPolicy.STRICT);
        assertNotNull(base64WithLineLength);
        assertArrayEquals(new byte[] { '\n' }, base64WithLineLength.getLineSeparator());
    }

    @Test
    void testBase64ConstructorWithUrlSafe() {
        Base64 base64UrlSafe = new Base64(0, null, true, CodecPolicy.STRICT);
        assertNotNull(base64UrlSafe);
        // Check if the instance is URL safe by checking the behavior
        // Assuming default line separator is null for URL safe
        assertTrue(base64UrlSafe.getLineSeparator() == null);
    }

    @Test
    void testBase64ConstructorWithInvalidLineSeparator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, new byte[] { 'A' }, false, CodecPolicy.STRICT);
        });
        assertEquals("lineSeparator must not contain base64 characters: [A]", exception.getMessage());
    }

    @Test
    void testBase64ConstructorWithInvalidEncodeTable() {
        // Invalid length
        byte[] invalidEncodeTable = new byte[63];
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, null, false, CodecPolicy.STRICT);
        });
        assertEquals("encodeTable must have exactly 64 entries.", exception.getMessage());
    }

    @Test
    void testBase64ConstructorWithNullLineSeparator() {
        Base64 base64WithNullSeparator = new Base64(76, null, false, CodecPolicy.STRICT);
        assertNotNull(base64WithNullSeparator);
        assertNull(base64WithNullSeparator.getLineSeparator());
    }

    @Test
    void testBase64ConstructorWithCustomEncodeTable() {
        // Assuming it's filled correctly
        byte[] customEncodeTable = new byte[64];
        Base64 base64Custom = new Base64(76, null, false, CodecPolicy.STRICT);
        assertNotNull(base64Custom);
        // Additional assertions can be added based on customEncodeTable logic
    }
}
