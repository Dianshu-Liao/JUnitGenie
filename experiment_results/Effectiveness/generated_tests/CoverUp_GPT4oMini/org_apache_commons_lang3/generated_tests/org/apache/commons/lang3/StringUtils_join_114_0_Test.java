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

public class StringUtils_join_114_0_Test {

    @Test
    public void testJoinWithNonEmptyArrayAndDelimiter() throws Exception {
        String[] input = { "Hello", "World" };
        String delimiter = ", ";
        String expected = "Hello, World";
        String result = invokeJoinMethod(input, delimiter);
        assertEquals(expected, result);
    }

    @Test
    public void testJoinWithEmptyArray() throws Exception {
        String[] input = {};
        String delimiter = ", ";
        String expected = "";
        String result = invokeJoinMethod(input, delimiter);
        assertEquals(expected, result);
    }

    @Test
    public void testJoinWithNullArray() throws Exception {
        String[] input = null;
        String delimiter = ", ";
        String result = invokeJoinMethod(input, delimiter);
        assertNull(result);
    }

    @Test
    public void testJoinWithNullDelimiter() throws Exception {
        String[] input = { "Hello", "World" };
        String delimiter = null;
        // Assuming ObjectUtils.toString(null) returns an empty string
        String expected = "HelloWorld";
        String result = invokeJoinMethod(input, delimiter);
        assertEquals(expected, result);
    }

    @Test
    public void testJoinWithSingleElementArray() throws Exception {
        String[] input = { "Hello" };
        String delimiter = ", ";
        String expected = "Hello";
        String result = invokeJoinMethod(input, delimiter);
        assertEquals(expected, result);
    }

    private String invokeJoinMethod(Object[] array, String delimiter) throws Exception {
        Method joinMethod = StringUtils.class.getDeclaredMethod("join", Object[].class, String.class);
        joinMethod.setAccessible(true);
        return (String) joinMethod.invoke(null, new Object[] { array, delimiter });
    }
}
