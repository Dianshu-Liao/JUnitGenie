package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
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

public class StringUtils_stripAll_203_0_Test {

    @Test
    public void testStripAll_NullArray() {
        String[] result = StringUtils.stripAll(null, "abc");
        assertArrayEquals(null, result);
    }

    @Test
    public void testStripAll_EmptyArray() {
        String[] result = StringUtils.stripAll(new String[] {}, "abc");
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    public void testStripAll_WithStripChars() {
        String[] input = { "abcHello", "worldabc", "abcTestabc" };
        String[] expected = { "Hello", "world", "Test" };
        String[] result = StringUtils.stripAll(input, "abc");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_NoStripChars() {
        String[] input = { "Hello", "world", "Test" };
        String[] expected = { "Hello", "world", "Test" };
        String[] result = StringUtils.stripAll(input, "");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_OnlyStripChars() {
        String[] input = { "aaa", "bbb", "ccc" };
        String[] expected = { "", "", "" };
        String[] result = StringUtils.stripAll(input, "abc");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_SingleElementArray() {
        String[] input = { "abcHello" };
        String[] expected = { "Hello" };
        String[] result = StringUtils.stripAll(input, "abc");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_WhitespaceStripChars() {
        String[] input = { "  Hello  ", "  World  " };
        String[] expected = { "Hello", "World" };
        String[] result = StringUtils.stripAll(input, " ");
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_SpecialCharacters() {
        String[] input = { "#Hello#", "@World@", "$Test$" };
        String[] expected = { "Hello", "World", "Test" };
        String[] result = StringUtils.stripAll(input, "#@$");
        assertArrayEquals(expected, result);
    }

    // Reflection test for private method 'strip'
    @Test
    public void testStripMethodReflection() throws Exception {
        Method stripMethod = StringUtils.class.getDeclaredMethod("strip", String.class, String.class);
        stripMethod.setAccessible(true);
        String result = (String) stripMethod.invoke(null, "abcHelloabc", "abc");
        assertEquals("Hello", result);
    }
}
