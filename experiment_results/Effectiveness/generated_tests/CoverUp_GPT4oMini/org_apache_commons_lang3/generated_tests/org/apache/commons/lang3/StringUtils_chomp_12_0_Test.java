package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
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

public class StringUtils_chomp_12_0_Test {

    @Test
    public void testChomp_WithValidStringAndSeparator() throws Exception {
        String input = "Hello World!";
        String separator = "!";
        String expected = "Hello World";
        String result = invokeChomp(input, separator);
        assertEquals(expected, result);
    }

    @Test
    public void testChomp_WithStringWithoutSeparator() throws Exception {
        String input = "Hello World";
        String separator = "!";
        String expected = "Hello World";
        String result = invokeChomp(input, separator);
        assertEquals(expected, result);
    }

    @Test
    public void testChomp_WithEmptyString() throws Exception {
        String input = "";
        String separator = "!";
        String expected = "";
        String result = invokeChomp(input, separator);
        assertEquals(expected, result);
    }

    @Test
    public void testChomp_WithNullString() throws Exception {
        String input = null;
        String separator = "!";
        String expected = null;
        String result = invokeChomp(input, separator);
        assertEquals(expected, result);
    }

    @Test
    public void testChomp_WithNullSeparator() throws Exception {
        String input = "Hello World!";
        String separator = null;
        String expected = "Hello World!";
        String result = invokeChomp(input, separator);
        assertEquals(expected, result);
    }

    private String invokeChomp(String str, String separator) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("chomp", String.class, String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, str, separator);
    }
}
