package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.StringUtils;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

class StringUtils_getBytesUnchecked_5_0_Test {

    @Test
    void testGetBytesUnchecked_NullString() {
        byte[] result = StringUtils.getBytesUnchecked(null, "UTF-8");
        assertNull(result);
    }

    @Test
    void testGetBytesUnchecked_ValidEncoding() {
        String input = "Hello, World!";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytesUnchecked(input, charset);
        assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    void testGetBytesUnchecked_InvalidEncoding() {
        String input = "Hello, World!";
        String charset = "INVALID_CHARSET";
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            StringUtils.getBytesUnchecked(input, charset);
        });
        String expectedMessage = charset + ": java.io.UnsupportedEncodingException: " + charset;
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void testGetBytesUnchecked_EmptyString() {
        String input = "";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytesUnchecked(input, charset);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testGetBytesUnchecked_ValidEncodingWithDifferentCharset() {
        // "Hello" in Japanese
        String input = "こんにちは";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytesUnchecked(input, charset);
        assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    void testGetBytesUnchecked_CharsetWithDifferentEncoding() {
        String input = "Hello, World!";
        String charset = "ISO-8859-1";
        byte[] result = StringUtils.getBytesUnchecked(input, charset);
        assertArrayEquals(input.getBytes(StandardCharsets.ISO_8859_1), result);
    }
}
