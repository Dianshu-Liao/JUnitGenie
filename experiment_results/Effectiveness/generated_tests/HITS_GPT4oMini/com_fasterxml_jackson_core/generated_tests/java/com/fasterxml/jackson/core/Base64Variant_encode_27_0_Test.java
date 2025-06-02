package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_encode_27_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        // Initialize Base64Variant with a standard Base64 alphabet
        String base64Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        base64Variant = new Base64Variant("TestVariant", base64Alphabet, true, '=', 76);
    }

    @Test
    public void testEncode_EmptyArray() {
        byte[] input = {};
        // Expecting empty string with quotes
        String expected = "\"\"";
        String result = base64Variant.encode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_SingleByte() {
        // ASCII for 'A'
        byte[] input = { 'A' };
        // Base64 encoded value for 'A' with padding
        String expected = "\"QQ==\"";
        String result = base64Variant.encode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_TwoBytes() {
        // ASCII for 'AB'
        byte[] input = { 'A', 'B' };
        // Base64 encoded value for 'AB' with padding
        String expected = "\"QUI=\"";
        String result = base64Variant.encode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_ThreeBytes() {
        // ASCII for 'ABC'
        byte[] input = { 'A', 'B', 'C' };
        // Base64 encoded value for 'ABC' without padding
        String expected = "\"QUJD\"";
        String result = base64Variant.encode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_FourBytes() {
        // ASCII for 'ABCD'
        byte[] input = { 'A', 'B', 'C', 'D' };
        // Base64 encoded value for 'ABCD' with padding
        String expected = "\"QUJDRA==\"";
        String result = base64Variant.encode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_MultipleBytes() {
        // ASCII for "Hello World"
        byte[] input = "Hello World".getBytes();
        // Base64 encoded value for "Hello World"
        String expected = "\"SGVsbG8gV29ybGQ=\"";
        String result = base64Variant.encode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_WithLineBreaks() {
        // 100 bytes of data
        byte[] input = new byte[100];
        for (int i = 0; i < 100; i++) {
            input[i] = (byte) (i % 256);
        }
        String result = base64Variant.encode(input, true);
        // We will not check the exact output here, but ensure it is not null or empty
        assertEquals(false, result.isEmpty());
    }
}
