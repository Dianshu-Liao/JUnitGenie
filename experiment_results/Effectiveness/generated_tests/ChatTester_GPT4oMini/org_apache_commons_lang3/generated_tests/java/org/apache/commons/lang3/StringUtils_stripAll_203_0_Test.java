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

public class StringUtils_stripAll_203_0_Test {

    @Test
    public void testStripAll_WithEmptyArray() {
        String[] input = new String[0];
        String[] result = StringUtils.stripAll(input, "a");
        assertArrayEquals(input, result);
    }

    @Test
    public void testStripAll_WithNoStripping() {
        String[] input = { "hello", "world" };
        String[] result = StringUtils.stripAll(input, "x");
        assertArrayEquals(input, result);
    }

    @Test
    public void testStripAll_WithStripping() {
        String[] input = { "hello", "world" };
        String[] result = StringUtils.stripAll(input, "lo");
        String[] expected = { "he", "wr" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_WithNullStripChars() {
        String[] input = { "hello", "world" };
        String[] result = StringUtils.stripAll(input, null);
        assertArrayEquals(input, result);
    }

    @Test
    public void testStripAll_WithEmptyStripChars() {
        String[] input = { "hello", "world" };
        String[] result = StringUtils.stripAll(input, "");
        assertArrayEquals(input, result);
    }

    @Test
    public void testStripAll_WithSpaces() {
        String[] input = { "  hello  ", "  world  " };
        String[] result = StringUtils.stripAll(input, " ");
        String[] expected = { "hello", "world" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_WithSpecialCharacters() {
        String[] input = { "h@e#l$l%o", "w^o&r*l*d!" };
        String[] result = StringUtils.stripAll(input, "@#$%^&*()!");
        String[] expected = { "hello", "world" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_WithMixedCharacters() {
        String[] input = { "a1b2c3", "d4e5f6" };
        String[] result = StringUtils.stripAll(input, "123456");
        String[] expected = { "abc", "def" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testStripAll_WithAllCharactersToStrip() {
        String[] input = { "abc", "def" };
        String[] result = StringUtils.stripAll(input, "abcdef");
        String[] expected = { "", "" };
        assertArrayEquals(expected, result);
    }
}
