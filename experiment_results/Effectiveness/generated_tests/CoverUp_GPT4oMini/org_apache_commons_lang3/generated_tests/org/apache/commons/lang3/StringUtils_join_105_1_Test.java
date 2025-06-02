package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_join_105_1_Test {

    @Test
    public void testJoin_withNonEmptyIterable() throws Exception {
        StringUtils stringUtils = new StringUtils();
        List<String> input = Arrays.asList("Hello", "World");
        String separator = ", ";
        String result = invokeJoinMethod(stringUtils, input, separator);
        assertEquals("Hello, World", result);
    }

    @Test
    public void testJoin_withEmptyIterable() throws Exception {
        StringUtils stringUtils = new StringUtils();
        List<String> input = Collections.emptyList();
        String separator = ", ";
        String result = invokeJoinMethod(stringUtils, input, separator);
        assertEquals("", result);
    }

    @Test
    public void testJoin_withNullIterable() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String separator = ", ";
        String result = invokeJoinMethod(stringUtils, null, separator);
        assertNull(result);
    }

    @Test
    public void testJoin_withSingleElement() throws Exception {
        StringUtils stringUtils = new StringUtils();
        List<String> input = Collections.singletonList("Hello");
        String separator = ", ";
        String result = invokeJoinMethod(stringUtils, input, separator);
        assertEquals("Hello", result);
    }

    @Test
    public void testJoin_withMultipleSeparators() throws Exception {
        StringUtils stringUtils = new StringUtils();
        List<String> input = Arrays.asList("A", "B", "C");
        String separator = " - ";
        String result = invokeJoinMethod(stringUtils, input, separator);
        assertEquals("A - B - C", result);
    }

    private String invokeJoinMethod(StringUtils stringUtils, Iterable<?> iterable, String separator) throws Exception {
        Method joinMethod = StringUtils.class.getDeclaredMethod("join", Iterable.class, String.class);
        joinMethod.setAccessible(true);
        return (String) joinMethod.invoke(null, iterable, separator);
    }
}
