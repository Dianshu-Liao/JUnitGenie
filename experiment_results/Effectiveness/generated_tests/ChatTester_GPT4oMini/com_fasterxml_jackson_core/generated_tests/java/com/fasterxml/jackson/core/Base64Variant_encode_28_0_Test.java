package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
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
        // Initialize the Base64Variant object with necessary parameters
        base64Variant = new Base64Variant("TestVariant", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testEncodeWithQuotes() throws Exception {
        // "Hello"
        byte[] input = { 72, 101, 108, 108, 111 };
        // Expected Base64 output with quotes
        String expected = "\"SGVsbG8=\"";
        String result = invokeEncode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncodeWithoutQuotes() throws Exception {
        // "Hello"
        byte[] input = { 72, 101, 108, 108, 111 };
        // Expected Base64 output without quotes
        String expected = "SGVsbG8=";
        String result = invokeEncode(input, false);
        assertEquals(expected, result);
    }

    @Test
    public void testEncodeWithEmptyInput() throws Exception {
        byte[] input = {};
        // Expected output for empty input with quotes
        String expected = "\"\"";
        String result = invokeEncode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncodeWithSingleByte() throws Exception {
        // "H"
        byte[] input = { 72 };
        // Expected Base64 output with quotes
        String expected = "\"SQ==\"";
        String result = invokeEncode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncodeWithTwoBytes() throws Exception {
        // "He"
        byte[] input = { 72, 101 };
        // Expected Base64 output with quotes
        String expected = "\"SGU=\"";
        String result = invokeEncode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncodeWithThreeBytes() throws Exception {
        // "Hel"
        byte[] input = { 72, 101, 108 };
        // Expected Base64 output with quotes
        String expected = "\"SGVs\"";
        String result = invokeEncode(input, true);
        assertEquals(expected, result);
    }

    @Test
    public void testEncodeWithMultipleLines() throws Exception {
        // Fill with data to test multiple lines
        byte[] input = new byte[100];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) (i % 256);
        }
        // Expected Base64 output with quotes, calculated separately
        String // Expected Base64 output with quotes, calculated separately
        expected = "\"AAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\nAAECAwQFBgcICQ==\\n\"";
        String result = invokeEncode(input, true);
        assertEquals(expected, result);
    }

    private String invokeEncode(byte[] input, boolean addQuotes) throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("encode", byte[].class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(base64Variant, input, addQuotes);
    }
}
