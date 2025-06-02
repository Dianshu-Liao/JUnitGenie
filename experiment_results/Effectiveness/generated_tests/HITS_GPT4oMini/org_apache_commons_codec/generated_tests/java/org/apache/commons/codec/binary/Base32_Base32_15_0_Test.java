package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_15_0_Test {

    @Test
    public void testBase32ConstructorWithValidParameters() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithNullLineSeparator() {
        int lineLength = 8;
        byte[] lineSeparator = null;
        boolean useHex = false;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex);
        });
        assertEquals("lineLength " + lineLength + " > 0, but lineSeparator is null", thrown.getMessage());
    }

    @Test
    public void testBase32ConstructorWithInvalidPadding() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        byte invalidPadding = 'A';
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex, invalidPadding);
        });
        assertEquals("pad must not be in alphabet or whitespace", thrown.getMessage());
    }

    @Test
    public void testBase32ConstructorWithLineSeparatorContainingBase32Characters() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { 'A' };
        boolean useHex = false;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex);
        });
        assertTrue(thrown.getMessage().contains("lineSeparator must not contain Base32 characters"));
    }

    @Test
    public void testBase32ConstructorWithHexEncoding() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithDifferentLineLengths() {
        int lineLength = 16;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex);
        assertNotNull(base32);
        assertArrayEquals(lineSeparator, base32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithZeroLineLength() {
        int lineLength = 0;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        Base32 base32 = new Base32(lineLength, lineSeparator, useHex);
        assertNotNull(base32);
        assertNull(base32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithNegativeLineLength() {
        int lineLength = -1;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = false;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator, useHex);
        });
        assertEquals("lineLength must be >= 0", thrown.getMessage());
    }
}
