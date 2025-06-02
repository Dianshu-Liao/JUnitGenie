package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.CharEncoding;

public class StringUtils_newString_13_0_Test {

    @Test
    public void testNewString_NullBytes() {
        String result = StringUtils.newString(null, "UTF-8");
        assertNull(result, "Expected null when input byte array is null");
    }

    @Test
    public void testNewString_ValidInput() {
        // Represents the string "Hello"
        byte[] bytes = { 72, 101, 108, 108, 111 };
        String charsetName = "UTF-8";
        String result = StringUtils.newString(bytes, charsetName);
        assertEquals("Hello", result, "Expected 'Hello' for valid byte array and charset");
    }

    @Test
    public void testNewString_UnsupportedEncoding() {
        // Represents the string "Hello"
        byte[] bytes = { 72, 101, 108, 108, 111 };
        String charsetName = "UnsupportedCharset";
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            StringUtils.newString(bytes, charsetName);
        });
        assertNotNull(exception, "Expected IllegalStateException for unsupported charset");
    }
}
