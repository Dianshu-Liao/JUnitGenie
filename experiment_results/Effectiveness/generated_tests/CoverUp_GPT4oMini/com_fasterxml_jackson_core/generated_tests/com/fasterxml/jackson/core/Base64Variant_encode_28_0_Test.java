package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_encode_28_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        // Initialize the Base64Variant with sample parameters
        base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testEncodeEmptyArray() {
        byte[] input = {};
        // Expecting quotes around empty string
        String expected = "\"\"";
        String actual = base64Variant.encode(input, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeSingleByte() {
        // ASCII for 'A'
        byte[] input = { 'A' };
        // Base64 encoding of 'A' with padding
        String expected = "\"QQ==\"";
        String actual = base64Variant.encode(input, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeTwoBytes() {
        // ASCII for 'AB'
        byte[] input = { 'A', 'B' };
        // Base64 encoding of 'AB' with padding
        String expected = "\"QUI=\"";
        String actual = base64Variant.encode(input, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeThreeBytes() {
        // ASCII for 'ABC'
        byte[] input = { 'A', 'B', 'C' };
        // Base64 encoding of 'ABC' without padding
        String expected = "\"QUJD\"";
        String actual = base64Variant.encode(input, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeMultipleBytesWithLineBreak() {
        // Test with a longer input
        byte[] input = "Hello, World!".getBytes();
        // Base64 encoding of "Hello, World!"
        String expected = "\"SGVsbG8sIFdvcmxkIQ==\"";
        String actual = base64Variant.encode(input, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithNoQuotes() {
        byte[] input = { 'A', 'B', 'C' };
        // Base64 encoding of 'ABC' without padding
        String expected = "QUJD";
        String actual = base64Variant.encode(input, false);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithLineBreaks() {
        // Fill with sample data
        byte[] input = new byte[100];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) (i % 256);
        }
        String actual = base64Variant.encode(input, true);
        // Validate that it does not exceed line length
        String[] lines = actual.split("\\\\n");
        for (String line : lines) {
            assertEquals(76, line.length());
        }
    }
}
