package org.apache.commons.lang3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
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

public class StringUtils_getBytes_49_0_Test {

    @Test
    public void testGetBytes_WithValidCharset() throws UnsupportedEncodingException {
        String input = "Hello, World!";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytes(input, charset);
        assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    public void testGetBytes_WithNullString() throws UnsupportedEncodingException {
        String input = null;
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytes(input, charset);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testGetBytes_WithDefaultCharset() throws UnsupportedEncodingException {
        String input = "Hello, World!";
        // should use default charset
        String charset = null;
        byte[] result = StringUtils.getBytes(input, charset);
        assertArrayEquals(input.getBytes(Charsets.toCharsetName(null)), result);
    }

    @Test
    public void testGetBytes_WithUnsupportedCharset() {
        String input = "Hello, World!";
        String charset = "INVALID_CHARSET";
        assertThrows(UnsupportedEncodingException.class, () -> {
            StringUtils.getBytes(input, charset);
        });
    }

    @Test
    public void testGetBytes_WithEmptyString() throws UnsupportedEncodingException {
        String input = "";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytes(input, charset);
        assertArrayEquals(new byte[0], result);
    }
}
