package org.apache.commons.lang3;

import org.junit.jupiter.api.function.Executable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class StringUtils_getBytes_49_0_Test {

    @Test
    void testGetBytes_NullString_ReturnsEmptyByteArray() throws UnsupportedEncodingException {
        // Arrange
        String inputString = null;
        String charset = "UTF-8";
        // Act
        byte[] result = StringUtils.getBytes(inputString, charset);
        // Assert
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testGetBytes_ValidString_ValidCharset_ReturnsByteArray() throws UnsupportedEncodingException {
        // Arrange
        String inputString = "Hello";
        String charset = "UTF-8";
        // Act
        byte[] result = StringUtils.getBytes(inputString, charset);
        // Assert
        assertArrayEquals("Hello".getBytes(Charset.forName(charset)), result);
    }

    @Test
    void testGetBytes_ValidString_InvalidCharset_ThrowsUnsupportedEncodingException() {
        // Arrange
        String inputString = "Hello";
        String charset = "INVALID_CHARSET";
        // Act
        Executable executable = () -> StringUtils.getBytes(inputString, charset);
        // Assert
        assertThrows(UnsupportedEncodingException.class, executable);
    }

    @Test
    void testGetBytes_EmptyString_ReturnsEmptyByteArray() throws UnsupportedEncodingException {
        // Arrange
        String inputString = "";
        String charset = "UTF-8";
        // Act
        byte[] result = StringUtils.getBytes(inputString, charset);
        // Assert
        assertArrayEquals(new byte[0], result);
    }
}
