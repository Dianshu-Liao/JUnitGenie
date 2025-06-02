package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base64_Base64_31_0_Test {

    @Test
    public void testBase64ConstructorWithLineLengthAndSeparator() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base64 base64 = new Base64(76, lineSeparator, false);
        assertNotNull(base64);
        assertArrayEquals(lineSeparator, base64.getLineSeparator());
    }

    @Test
    public void testBase64ConstructorWithUrlSafe() {
        Base64 base64 = new Base64(0, null, true);
        assertNotNull(base64);
    }

    @Test
    public void testBase64ConstructorWithInvalidEncodeTable() {
        // Invalid length
        byte[] invalidTable = new byte[63];
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, null, false, null);
        });
        assertEquals("encodeTable must have exactly 64 entries.", exception.getMessage());
    }

    @Test
    public void testBase64ConstructorWithInvalidLineSeparator() {
        byte[] invalidSeparator = new byte[] { 'A' };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, invalidSeparator, false);
        });
        assertTrue(exception.getMessage().contains("lineSeparator must not contain base64 characters"));
    }

    @Test
    public void testBase64ConstructorWithNullLineSeparator() {
        Base64 base64 = new Base64(76, null, false);
        assertNotNull(base64);
        assertNull(base64.getLineSeparator());
    }

    @Test
    public void testBase64ConstructorWithZeroLineLength() {
        Base64 base64 = new Base64(0, null, false);
        assertNotNull(base64);
        assertNull(base64.getLineSeparator());
    }

    @Test
    public void testBase64ConstructorWithNegativeLineLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(-1, null, false);
        });
        assertTrue(exception.getMessage().contains("lineLength must be positive"));
    }

    @Test
    public void testBase64ConstructorWithPositiveLineLength() {
        Base64 base64 = new Base64(10, null, true);
        assertNotNull(base64);
    }
}
