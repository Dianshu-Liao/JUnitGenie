package org.apache.commons.lang3;

import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;
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

public class StringUtils_join_115_0_Test {

    @Test
    public void testJoin_WithValidInput() throws Exception {
        Object[] input = { "Hello", "World", "from", "StringUtils" };
        String delimiter = " ";
        int startIndex = 0;
        int endIndex = 4;
        String result = invokeJoinMethod(input, delimiter, startIndex, endIndex);
        assertEquals("Hello World from StringUtils", result);
    }

    @Test
    public void testJoin_WithEmptyArray() throws Exception {
        Object[] input = {};
        String delimiter = " ";
        int startIndex = 0;
        int endIndex = 0;
        String result = invokeJoinMethod(input, delimiter, startIndex, endIndex);
        assertEquals("", result);
    }

    @Test
    public void testJoin_WithNullArray() throws Exception {
        Object[] input = null;
        String delimiter = " ";
        int startIndex = 0;
        int endIndex = 4;
        String result = invokeJoinMethod(input, delimiter, startIndex, endIndex);
        assertNull(result);
    }

    @Test
    public void testJoin_WithNegativeStartIndex() throws Exception {
        Object[] input = { "Hello", "World" };
        String delimiter = " ";
        int startIndex = -1;
        int endIndex = 2;
        String result = invokeJoinMethod(input, delimiter, startIndex, endIndex);
        assertEquals("Hello World", result);
    }

    @Test
    public void testJoin_WithEndIndexGreaterThanArrayLength() throws Exception {
        Object[] input = { "Hello", "World" };
        String delimiter = " ";
        int startIndex = 0;
        int endIndex = 5;
        String result = invokeJoinMethod(input, delimiter, startIndex, endIndex);
        assertEquals("Hello World", result);
    }

    @Test
    public void testJoin_WithStartIndexEqualToEndIndex() throws Exception {
        Object[] input = { "Hello", "World" };
        String delimiter = " ";
        int startIndex = 1;
        int endIndex = 1;
        String result = invokeJoinMethod(input, delimiter, startIndex, endIndex);
        assertEquals("", result);
    }

    private String invokeJoinMethod(Object[] array, String delimiter, int startIndex, int endIndex) throws Exception {
        Method joinMethod = StringUtils.class.getDeclaredMethod("join", Object[].class, String.class, int.class, int.class);
        joinMethod.setAccessible(true);
        return (String) joinMethod.invoke(null, (Object) array, delimiter, startIndex, endIndex);
    }
}
