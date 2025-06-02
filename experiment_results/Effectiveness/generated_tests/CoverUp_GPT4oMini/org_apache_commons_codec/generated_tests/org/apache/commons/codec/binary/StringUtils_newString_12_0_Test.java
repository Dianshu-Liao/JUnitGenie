package org.apache.commons.codec.binary;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.commons.codec.CharEncoding;

public class StringUtils_newString_12_0_Test {

    @Test
    public void testNewString_withValidBytesAndCharset() {
        byte[] bytes = "Hello".getBytes(StandardCharsets.UTF_8);
        Charset charset = StandardCharsets.UTF_8;
        String result = invokeNewString(bytes, charset);
        assertEquals("Hello", result);
    }

    @Test
    public void testNewString_withNullBytes() {
        byte[] bytes = null;
        Charset charset = StandardCharsets.UTF_8;
        String result = invokeNewString(bytes, charset);
        assertNull(result);
    }

    @Test
    public void testNewString_withEmptyBytes() {
        byte[] bytes = new byte[0];
        Charset charset = StandardCharsets.UTF_8;
        String result = invokeNewString(bytes, charset);
        assertEquals("", result);
    }

    @Test
    public void testNewString_withDifferentCharset() {
        byte[] bytes = "Hello".getBytes(StandardCharsets.ISO_8859_1);
        Charset charset = StandardCharsets.ISO_8859_1;
        String result = invokeNewString(bytes, charset);
        assertEquals("Hello", result);
    }

    private String invokeNewString(byte[] bytes, Charset charset) {
        try {
            Method method = StringUtils.class.getDeclaredMethod("newString", byte[].class, Charset.class);
            method.setAccessible(true);
            return (String) method.invoke(null, bytes, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
