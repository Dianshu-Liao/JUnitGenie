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

public class Base64_Base64_30_0_Test {

    private Base64 base64;

    @BeforeEach
    public void setUp() {
        // Initialize Base64 with default parameters
        base64 = new Base64();
    }

    @Test
    public void testBase64ConstructorWithLineLength() {
        int lineLength = 76;
        byte[] lineSeparator = "\n".getBytes();
        Base64 base64WithLine = new Base64(lineLength, lineSeparator);
        assertNotNull(base64WithLine);
        assertArrayEquals(lineSeparator, base64WithLine.getLineSeparator());
    }

    @Test
    public void testBase64ConstructorWithLineLengthAndUrlSafe() {
        int lineLength = 76;
        byte[] lineSeparator = "\n".getBytes();
        Base64 base64UrlSafe = new Base64(lineLength, lineSeparator, true);
        assertNotNull(base64UrlSafe);
        assertArrayEquals(lineSeparator, base64UrlSafe.getLineSeparator());
    }

    @Test
    public void testBase64ConstructorWithInvalidLineSeparator() {
        int lineLength = 76;
        // Invalid as 'A' is a base64 character
        byte[] lineSeparator = { 'A' };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(lineLength, lineSeparator);
        });
        assertTrue(exception.getMessage().contains("lineSeparator must not contain base64 characters"));
    }

    @Test
    public void testBase64ConstructorWithInvalidEncodeTable() {
        // Invalid length
        byte[] invalidEncodeTable = new byte[63];
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, "\n".getBytes(), false, null);
        });
        assertTrue(exception.getMessage().contains("encodeTable must have exactly 64 entries"));
    }

    @Test
    public void testBase64ConstructorWithNullLineSeparator() {
        Base64 base64WithNullSeparator = new Base64(76, null);
        assertNotNull(base64WithNullSeparator);
        assertNull(base64WithNullSeparator.getLineSeparator());
    }

    @Test
    public void testBase64ConstructorWithZeroLineLength() {
        Base64 base64WithZeroLineLength = new Base64(0, null);
        assertNotNull(base64WithZeroLineLength);
        assertNull(base64WithZeroLineLength.getLineSeparator());
    }
}
