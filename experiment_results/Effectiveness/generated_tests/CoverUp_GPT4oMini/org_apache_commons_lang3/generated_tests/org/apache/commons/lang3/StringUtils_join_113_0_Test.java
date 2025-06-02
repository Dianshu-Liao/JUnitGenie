package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
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

public class StringUtils_join_113_0_Test {

    @Test
    public void testJoin_WithValidInputs() throws Exception {
        Object[] array = { "apple", "banana", "cherry" };
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 3;
        String result = invokeJoinMethod(array, delimiter, startIndex, endIndex);
        assertEquals("apple,banana,cherry", result);
    }

    @Test
    public void testJoin_WithEmptyArray() throws Exception {
        Object[] array = {};
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 0;
        String result = invokeJoinMethod(array, delimiter, startIndex, endIndex);
        assertEquals("", result);
    }

    @Test
    public void testJoin_WithNullArray() throws Exception {
        Object[] array = null;
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 3;
        String result = invokeJoinMethod(array, delimiter, startIndex, endIndex);
        assertEquals(null, result);
    }

    @Test
    public void testJoin_WithPartialRange() throws Exception {
        Object[] array = { "apple", "banana", "cherry", "date" };
        char delimiter = '-';
        int startIndex = 1;
        int endIndex = 3;
        String result = invokeJoinMethod(array, delimiter, startIndex, endIndex);
        assertEquals("banana-cherry", result);
    }

    @Test
    public void testJoin_WithNegativeStartIndex() throws Exception {
        Object[] array = { "apple", "banana", "cherry" };
        char delimiter = ',';
        int startIndex = -1;
        int endIndex = 3;
        String result = invokeJoinMethod(array, delimiter, startIndex, endIndex);
        assertEquals("apple,banana,cherry", result);
    }

    @Test
    public void testJoin_WithStartIndexGreaterThanEndIndex() throws Exception {
        Object[] array = { "apple", "banana", "cherry" };
        char delimiter = ',';
        int startIndex = 2;
        int endIndex = 1;
        String result = invokeJoinMethod(array, delimiter, startIndex, endIndex);
        assertEquals("", result);
    }

    private String invokeJoinMethod(Object[] array, char delimiter, int startIndex, int endIndex) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("join", Object[].class, char.class, int.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(null, array, delimiter, startIndex, endIndex);
    }
}
