package org.apache.commons.lang3;

import java.io.UnsupportedEncodingException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
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

public class StringUtils_getBytes_49_1_Test {

    @Test
    public void testGetBytes_NullString() throws UnsupportedEncodingException {
        byte[] result = StringUtils.getBytes(null, "UTF-8");
        assertArrayEquals(new byte[0], result, "Expected empty byte array for null string input.");
    }

    @Test
    public void testGetBytes_ValidStringAndCharset() throws UnsupportedEncodingException {
        String input = "Hello, World!";
        String charset = "UTF-8";
        byte[] expected = input.getBytes(charset);
        byte[] result = StringUtils.getBytes(input, charset);
        assertArrayEquals(expected, result, "Expected byte array does not match for valid string and charset.");
    }

    @Test
    public void testGetBytes_UnsupportedCharset() {
        String input = "Hello, World!";
        String charset = "INVALID_CHARSET";
        assertThrows(UnsupportedEncodingException.class, () -> {
            StringUtils.getBytes(input, (String) charset);
        }, "Expected UnsupportedEncodingException for invalid charset.");
    }

    @Test
    public void testGetBytes_EmptyString() throws UnsupportedEncodingException {
        String input = "";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytes(input, charset);
        assertArrayEquals(new byte[0], result, "Expected empty byte array for empty string input.");
    }

    @Test
    public void testGetBytes_DefaultCharset() throws UnsupportedEncodingException {
        String input = "Default Charset Test";
        byte[] expected = input.getBytes(Charsets.toCharsetName(null));
        byte[] result = StringUtils.getBytes(input, (String) null);
        assertArrayEquals(expected, result, "Expected byte array does not match for default charset.");
    }
}
