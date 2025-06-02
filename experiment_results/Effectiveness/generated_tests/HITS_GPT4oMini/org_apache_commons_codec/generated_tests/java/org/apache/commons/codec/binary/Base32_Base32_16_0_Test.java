package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_16_0_Test {

    @Test
    public void testBase32InitializationWithValidParameters() {
        int lineLength = 64;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        byte padding = '=';
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex, padding);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32InitializationWithLineSeparatorNull() {
        int lineLength = 64;
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex, padding);
        });
        assertEquals("lineLength " + lineLength + " > 0, but lineSeparator is null", exception.getMessage());
    }

    @Test
    public void testBase32InitializationWithInvalidLineSeparator() {
        int lineLength = 5;
        // 'A' is in the Base32 alphabet
        byte[] lineSeparator = new byte[] { 'A' };
        boolean useHex = false;
        byte padding = '=';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex, padding);
        });
        assertTrue(exception.getMessage().contains("lineSeparator must not contain Base32 characters"));
    }

    @Test
    public void testBase32InitializationWithInvalidPadding() {
        int lineLength = 64;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        // 'A' is in the Base32 alphabet
        byte padding = 'A';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex, padding);
        });
        assertEquals("pad must not be in alphabet or whitespace", exception.getMessage());
    }

    @Test
    public void testBase32InitializationWithHexEncoding() {
        int lineLength = 64;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        byte padding = '=';
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex, padding);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32InitializationWithZeroLineLength() {
        int lineLength = 0;
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex, padding);
        assertNotNull(base32);
        assertNull(base32.getLineSeparator());
    }

    @Test
    public void testBase32InitializationWithNegativeLineLength() {
        int lineLength = -1;
        byte[] lineSeparator = null;
        boolean useHex = false;
        byte padding = '=';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex, padding);
        });
        assertEquals("lineLength must be >= 0", exception.getMessage());
    }
}
