package org.apache.commons.lang3;

import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_getBytes_48_0_Test {

    @Test
    public void testGetBytes_NullString_ReturnsEmptyByteArray() {
        // Arrange
        String input = null;
        Charset charset = Charset.defaultCharset();
        // Act
        byte[] result = StringUtils.getBytes(input, charset);
        // Assert
        assertArrayEquals(new byte[0], result, "Expected an empty byte array when input string is null");
    }

    @Test
    public void testGetBytes_EmptyString_ReturnsEmptyByteArray() {
        // Arrange
        String input = StringUtils.EMPTY;
        Charset charset = Charset.defaultCharset();
        // Act
        byte[] result = StringUtils.getBytes(input, charset);
        // Assert
        assertArrayEquals(new byte[0], result, "Expected an empty byte array when input string is empty");
    }

    @Test
    public void testGetBytes_ValidString_ReturnsByteArray() {
        // Arrange
        String input = "Hello";
        Charset charset = Charset.forName("UTF-8");
        // Act
        byte[] result = StringUtils.getBytes(input, charset);
        // Assert
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, result, "Expected byte array for valid input string");
    }

    @Test
    public void testGetBytes_NullCharset_ReturnsByteArrayUsingDefaultCharset() {
        // Arrange
        String input = "Hello";
        // This should invoke the default charset
        Charset charset = null;
        // Act
        byte[] result = StringUtils.getBytes(input, charset);
        // Assert
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, result, "Expected byte array for valid input string with null charset");
    }

    @Test
    public void testGetBytes_UnsupportedCharset_ReturnsByteArrayUsingDefaultCharset() {
        // Arrange
        String input = "Hello";
        // This will fallback to default charset
        Charset charset = Charset.forName("UnsupportedCharset");
        // Act
        byte[] result = StringUtils.getBytes(input, charset);
        // Assert
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, result, "Expected byte array for valid input string with unsupported charset");
    }
}
