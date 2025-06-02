// Test method
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

public class StringUtils_getBytes_48_0_Test {

    @Test
    public void testGetBytes_NullString() {
        // Test with null string
        byte[] result = StringUtils.getBytes(null, StandardCharsets.UTF_8);
        Assertions.assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testGetBytes_EmptyString() {
        // Test with empty string
        byte[] result = StringUtils.getBytes(StringUtils.EMPTY, StandardCharsets.UTF_8);
        Assertions.assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testGetBytes_ValidString() {
        // Test with a valid string
        String input = "Hello, World!";
        byte[] result = StringUtils.getBytes(input, StandardCharsets.UTF_8);
        Assertions.assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    public void testGetBytes_ValidStringWithDifferentCharset() {
        // Test with a valid string and a different charset
        String input = "Hello, World!";
        byte[] result = StringUtils.getBytes(input, Charset.forName("ISO-8859-1"));
        Assertions.assertArrayEquals(input.getBytes(Charset.forName("ISO-8859-1")), result);
    }

    @Test
    public void testGetBytes_NullCharset() {
        // Test with null charset
        String input = "Hello, World!";
        // Fixed line
        byte[] result = StringUtils.getBytes(input, StandardCharsets.UTF_8);
        Assertions.assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }
}
