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
    public void testNewString_WithValidInput() throws Exception {
        // Arrange
        byte[] inputBytes = "Hello".getBytes(StandardCharsets.UTF_8);
        Charset charset = StandardCharsets.UTF_8;
        // Act
        String result = invokeNewString(inputBytes, charset);
        // Assert
        assertEquals("Hello", result);
    }

    @Test
    public void testNewString_WithNullBytes() throws Exception {
        // Arrange
        byte[] inputBytes = null;
        Charset charset = StandardCharsets.UTF_8;
        // Act
        String result = invokeNewString(inputBytes, charset);
        // Assert
        assertNull(result);
    }

    @Test
    public void testNewString_WithDifferentCharset() throws Exception {
        // Arrange
        byte[] inputBytes = "Hello".getBytes(StandardCharsets.ISO_8859_1);
        Charset charset = StandardCharsets.ISO_8859_1;
        // Act
        String result = invokeNewString(inputBytes, charset);
        // Assert
        assertEquals("Hello", result);
    }

    @Test
    public void testNewString_WithEmptyByteArray() throws Exception {
        // Arrange
        // empty byte array
        byte[] inputBytes = new byte[0];
        Charset charset = StandardCharsets.UTF_8;
        // Act
        String result = invokeNewString(inputBytes, charset);
        // Assert
        // Expecting an empty string for empty byte array
        assertEquals("", result);
    }

    private String invokeNewString(byte[] bytes, Charset charset) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("newString", byte[].class, Charset.class);
        method.setAccessible(true);
        return (String) method.invoke(null, bytes, charset);
    }
}
