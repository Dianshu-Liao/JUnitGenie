package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

class Base64Variant_encode_29_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    void setUp() {
        base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    void testEncode_withQuotes() {
        // "Hello"
        byte[] input = { 72, 101, 108, 108, 111 };
        String expected = "\"SGVsbG8=\"";
        String result = base64Variant.encode(input, true, "\n");
        assertEquals(expected, result);
    }

    @Test
    void testEncode_withoutQuotes() {
        // "Hello"
        byte[] input = { 72, 101, 108, 108, 111 };
        String expected = "SGVsbG8=";
        String result = base64Variant.encode(input, false, "\n");
        assertEquals(expected, result);
    }

    @Test
    void testEncode_withLineFeed() {
        // Input larger than max line length
        byte[] input = new byte[100];
        for (int i = 0; i < 100; i++) {
            input[i] = (byte) i;
        }
        String result = base64Variant.encode(input, false, "\n");
        assertTrue(result.contains("\n"));
    }

    @Test
    void testEncode_withPartialInput() {
        // "He"
        byte[] input = { 72, 101 };
        String expected = "SGk=";
        String result = base64Variant.encode(input, false, "\n");
        assertEquals(expected, result);
    }

    @Test
    void testEncode_emptyInput() {
        byte[] input = {};
        // Expecting quotes around empty
        String expected = "\"\"";
        String result = base64Variant.encode(input, true, "\n");
        assertEquals(expected, result);
    }

    @Test
    void testEncode_oneByteInput() {
        // "H"
        byte[] input = { 72 };
        String expected = "SGk=";
        String result = base64Variant.encode(input, false, "\n");
        assertEquals(expected, result);
    }

    @Test
    void testEncode_twoByteInput() {
        // "He"
        byte[] input = { 72, 101 };
        String expected = "SGk=";
        String result = base64Variant.encode(input, false, "\n");
        assertEquals(expected, result);
    }

    @Test
    void testEncode_withMultipleLines() {
        // Input larger than max line length
        byte[] input = new byte[80];
        for (int i = 0; i < 80; i++) {
            input[i] = (byte) (i + 1);
        }
        String result = base64Variant.encode(input, false, "\n");
        assertTrue(result.contains("\n"));
        // Check number of lines
        assertEquals(4, result.split("\n").length);
    }
}
