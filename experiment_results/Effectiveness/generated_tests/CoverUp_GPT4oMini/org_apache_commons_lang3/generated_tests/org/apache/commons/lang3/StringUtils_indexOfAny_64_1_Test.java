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

public class StringUtils_indexOfAny_64_1_Test {

    @Test
    public void testIndexOfAny_WithEmptyCharSequence_ReturnsIndexNotFound() throws Exception {
        String cs = "";
        String searchChars = "a";
        int result = invokeIndexOfAny(cs, searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithEmptySearchChars_ReturnsIndexNotFound() throws Exception {
        String cs = "abc";
        String searchChars = "";
        int result = invokeIndexOfAny(cs, searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithNoMatchingChars_ReturnsIndexNotFound() throws Exception {
        String cs = "abc";
        String searchChars = "xyz";
        int result = invokeIndexOfAny(cs, searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithMatchingChars_ReturnsFirstIndex() throws Exception {
        String cs = "abc";
        String searchChars = "b";
        int result = invokeIndexOfAny(cs, searchChars);
        assertEquals(1, result);
    }

    @Test
    public void testIndexOfAny_WithMultipleMatchingChars_ReturnsFirstIndex() throws Exception {
        String cs = "abc";
        String searchChars = "cb";
        int result = invokeIndexOfAny(cs, searchChars);
        assertEquals(1, result);
    }

    private int invokeIndexOfAny(String cs, String searchChars) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("indexOfAny", CharSequence.class, String.class);
        method.setAccessible(true);
        return (int) method.invoke(null, cs, searchChars);
    }
}
