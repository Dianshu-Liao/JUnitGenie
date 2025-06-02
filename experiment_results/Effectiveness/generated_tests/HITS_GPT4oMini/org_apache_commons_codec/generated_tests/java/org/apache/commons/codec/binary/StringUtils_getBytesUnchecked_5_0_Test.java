package org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.CharEncoding;

public class StringUtils_getBytesUnchecked_5_0_Test {

    @Test
    public void testGetBytesUnchecked_WithValidStringAndCharset() {
        String input = "Hello, World!";
        String charset = "UTF-8";
        try {
            byte[] expected = input.getBytes(charset);
            byte[] actual = StringUtils.getBytesUnchecked(input, charset);
            assertArrayEquals(expected, actual);
        } catch (UnsupportedEncodingException e) {
            fail("Unexpected UnsupportedEncodingException: " + e.getMessage());
        }
    }

    @Test
    public void testGetBytesUnchecked_WithNullString() {
        String input = null;
        String charset = "UTF-8";
        byte[] actual = StringUtils.getBytesUnchecked(input, charset);
        assertNull(actual);
    }

    @Test
    public void testGetBytesUnchecked_WithUnsupportedCharset() {
        String input = "Hello, World!";
        // This charset is intentionally invalid
        String charset = "unsupported-charset";
        assertThrows(IllegalStateException.class, () -> {
            StringUtils.getBytesUnchecked(input, charset);
        });
    }

    @Test
    public void testGetBytesUnchecked_WithEmptyString() {
        String input = "";
        String charset = "UTF-8";
        try {
            byte[] expected = input.getBytes(charset);
            byte[] actual = StringUtils.getBytesUnchecked(input, charset);
            assertArrayEquals(expected, actual);
        } catch (UnsupportedEncodingException e) {
            fail("Unexpected UnsupportedEncodingException: " + e.getMessage());
        }
    }

    @Test
    public void testGetBytesUnchecked_WithDifferentValidCharset() {
        String input = "Hello, World!";
        String charset = "ISO-8859-1";
        try {
            byte[] expected = input.getBytes(charset);
            byte[] actual = StringUtils.getBytesUnchecked(input, charset);
            assertArrayEquals(expected, actual);
        } catch (UnsupportedEncodingException e) {
            fail("Unexpected UnsupportedEncodingException: " + e.getMessage());
        }
    }
}
