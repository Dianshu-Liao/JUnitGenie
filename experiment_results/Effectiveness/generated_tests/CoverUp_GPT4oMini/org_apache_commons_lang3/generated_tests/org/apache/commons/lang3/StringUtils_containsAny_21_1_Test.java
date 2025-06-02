package org.apache.commons.lang3;

import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtils_containsAny_21_1_Test {

    @Test
    public void testContainsAny_WithNullSearchChars() {
        assertFalse(StringUtils.containsAny("abc", (CharSequence) null));
    }

    @Test
    public void testContainsAny_WithEmptyStringAndSearchChars() {
        assertFalse(StringUtils.containsAny("", "a"));
    }

    @Test
    public void testContainsAny_WithEmptySearchChars() {
        assertFalse(StringUtils.containsAny("abc", ""));
    }

    @Test
    public void testContainsAny_WithNoMatches() {
        assertFalse(StringUtils.containsAny("abc", "xyz"));
    }

    @Test
    public void testContainsAny_WithSingleMatch() {
        assertTrue(StringUtils.containsAny("abc", "a"));
        assertTrue(StringUtils.containsAny("abc", "b"));
        assertTrue(StringUtils.containsAny("abc", "c"));
    }

    @Test
    public void testContainsAny_WithMultipleMatches() {
        assertTrue(StringUtils.containsAny("abc", "ab"));
        assertTrue(StringUtils.containsAny("abc", "bc"));
        assertTrue(StringUtils.containsAny("abc", "ac"));
        assertTrue(StringUtils.containsAny("abc", "abc"));
    }

    @Test
    public void testContainsAny_WithSpecialCharacters() {
        assertTrue(StringUtils.containsAny("abc!@#", "@"));
        assertFalse(StringUtils.containsAny("abc!@#", "$"));
    }

    @Test
    public void testContainsAny_WithWhitespace() {
        assertTrue(StringUtils.containsAny("abc def", " "));
        assertFalse(StringUtils.containsAny("abc", " "));
    }

    @Test
    public void testContainsAny_WithNullInput() {
        assertFalse(StringUtils.containsAny(null, "a"));
    }

    @Test
    public void testContainsAny_WithNullInputAndNullSearchChars() {
        assertFalse(StringUtils.containsAny(null, (CharSequence) null));
    }

    @Test
    public void testContainsAny_WithMixedCharacters() {
        assertTrue(StringUtils.containsAny("Hello, World!", "W"));
        assertTrue(StringUtils.containsAny("Hello, World!", "o"));
        assertFalse(StringUtils.containsAny("Hello, World!", "x"));
    }

    @Test
    public void testContainsAny_WithUnicodeCharacters() {
        assertTrue(StringUtils.containsAny("你好", "你"));
        assertFalse(StringUtils.containsAny("你好", "好好"));
    }

    @Test
    public void testContainsAny_WithHighSurrogates() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("containsAny", CharSequence.class, CharSequence.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(null, "\uD83D\uDE00", "\uD83D\uDE00"));
        assertFalse((Boolean) method.invoke(null, "\uD83D\uDE00", "\uD83D\uDE01"));
    }
}
