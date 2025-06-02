package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.StringUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

class StringUtils_newString_13_0_Test {

    @Test
    void testNewString_NullBytes() {
        // Test with null byte array
        String result = StringUtils.newString(null, "UTF-8");
        assertNull(result, "Expected null result for null byte array");
    }

    @Test
    void testNewString_ValidInput() {
        // Test with valid byte array and charset
        byte[] bytes = "Hello".getBytes(StandardCharsets.UTF_8);
        String result = StringUtils.newString(bytes, "UTF-8");
        assertEquals("Hello", result, "Expected string should match the input");
    }

    @Test
    void testNewString_InvalidCharset() {
        // Test with invalid charset
        byte[] bytes = "Hello".getBytes(StandardCharsets.UTF_8);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            StringUtils.newString(bytes, "INVALID_CHARSET");
        });
        assertTrue(exception.getMessage().contains("INVALID_CHARSET"), "Expected exception message to contain charset name");
    }

    @Test
    void testNewString_EmptyByteArray() {
        // Test with empty byte array
        byte[] bytes = new byte[0];
        String result = StringUtils.newString(bytes, "UTF-8");
        assertEquals("", result, "Expected empty string for empty byte array");
    }

    @Test
    void testNewString_UnsupportedEncodingException() {
        // Test with an unsupported encoding
        byte[] bytes = "Hello".getBytes(StandardCharsets.UTF_8);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            StringUtils.newString(bytes, "unsupported-encoding");
        });
        assertTrue(exception.getMessage().contains("unsupported-encoding"), "Expected exception message to contain charset name");
    }
}
