package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class Base32_Base32_17_0_Test {

    private Base32 base32;

    @BeforeEach
    public void setUp() {
        // Initialize the Base32 object with default parameters
        base32 = new Base32();
    }

    @Test
    public void testBase32ConstructorWithLineLength() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32WithLineLength = new Base32(lineLength, lineSeparator);
        assertNotNull(base32WithLineLength);
        assertArrayEquals(lineSeparator, base32WithLineLength.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithLineLengthAndHex() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        Base32 base32WithHex = new Base32(lineLength, lineSeparator, useHex);
        assertNotNull(base32WithHex);
    }

    @Test
    public void testBase32ConstructorWithLineLengthHexAndPadding() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        byte padding = '=';
        Base32 base32WithPadding = new Base32(lineLength, lineSeparator, useHex, padding);
        assertNotNull(base32WithPadding);
    }

    @Test
    public void testBase32ConstructorWithLineLengthHexPaddingAndPolicy() {
        int lineLength = 8;
        byte[] lineSeparator = new byte[] { '\n' };
        boolean useHex = true;
        byte padding = '=';
        // Changed from IGNORE to STRICT
        CodecPolicy decodingPolicy = CodecPolicy.STRICT;
        Base32 base32WithPolicy = new Base32(lineLength, lineSeparator, useHex, padding, decodingPolicy);
        assertNotNull(base32WithPolicy);
    }

    @Test
    public void testConstructorThrowsExceptionOnInvalidLineSeparator() {
        int lineLength = 1;
        // Invalid because 'A' is in the Base32 alphabet
        byte[] lineSeparator = new byte[] { 'A' };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator);
        });
        assertTrue(exception.getMessage().contains("lineSeparator must not contain Base32 characters"));
    }

    @Test
    public void testConstructorThrowsExceptionOnInvalidPadding() {
        // Invalid because 'A' is in the Base32 alphabet
        byte padding = 'A';
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base32(padding);
        });
        assertTrue(exception.getMessage().contains("pad must not be in alphabet or whitespace"));
    }

    @Test
    public void testBase32EncodingAndDecoding() {
        String original = "Hello World";
        byte[] encoded = base32.encode(original.getBytes());
        byte[] decoded = base32.decode(encoded);
        assertArrayEquals(original.getBytes(), decoded);
    }

    @Test
    public void testBase32EncodingWithLineSeparator() {
        String original = "HelloWorld";
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32WithLineSeparator = new Base32(8, lineSeparator);
        byte[] encoded = base32WithLineSeparator.encode(original.getBytes());
        assertNotNull(encoded);
        assertTrue(encoded.length > 0);
    }
}
