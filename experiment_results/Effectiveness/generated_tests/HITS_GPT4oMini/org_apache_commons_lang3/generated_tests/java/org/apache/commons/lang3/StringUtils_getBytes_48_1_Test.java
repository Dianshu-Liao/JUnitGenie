package org.apache.commons.lang3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

public class StringUtils_getBytes_48_1_Test {

    @Test
    public void testGetBytesWithValidStringAndCharset() {
        String input = "Hello";
        Charset charset = StandardCharsets.UTF_8;
        byte[] expected = input.getBytes(charset);
        byte[] actual = StringUtils.getBytes(input, charset);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetBytesWithNullString() {
        String input = null;
        Charset charset = StandardCharsets.UTF_8;
        // ArrayUtils.EMPTY_BYTE_ARRAY is assumed to be an empty byte array
        byte[] expected = new byte[0];
        byte[] actual = StringUtils.getBytes(input, charset);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetBytesWithNullCharset() {
        String input = "Hello";
        // Testing with null charset
        Charset charset = null;
        byte[] expected = input.getBytes(Charset.defaultCharset());
        byte[] actual = StringUtils.getBytes(input, charset);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetBytesWithUnsupportedCharset() {
        String input = "Hello";
        // This will not throw an exception since we handle it in the method
        Charset charset = Charset.forName("UnsupportedCharset");
        byte[] expected = input.getBytes(Charset.defaultCharset());
        byte[] actual = StringUtils.getBytes(input, charset);
        assertArrayEquals(expected, actual);
    }
}
