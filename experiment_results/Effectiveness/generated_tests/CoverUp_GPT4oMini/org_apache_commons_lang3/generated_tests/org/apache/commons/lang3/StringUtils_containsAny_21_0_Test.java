package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
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

class StringUtils_containsAny_21_0_Test {

    @Test
    void testContainsAny_WithNullSearchChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("test", (CharSequence) null));
    }

    @Test
    void testContainsAny_WithEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("", "a"));
        assertFalse(StringUtils.containsAny(null, "a"));
    }

    @Test
    void testContainsAny_WithNoMatchingChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("test", "xyz"));
    }

    @Test
    void testContainsAny_WithMatchingChars_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("test", "e"));
        assertTrue(StringUtils.containsAny("test", "st"));
        assertTrue(StringUtils.containsAny("test", "t"));
    }

    @Test
    void testContainsAny_WithMultipleMatchingChars_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello", "aeiou"));
    }

    @Test
    void testContainsAny_WithHighSurrogateCharacter_ReturnsTrue() {
        // Grinning Face
        String highSurrogate = "\uD83D\uDE00";
        assertTrue(StringUtils.containsAny(highSurrogate, "\uD83D\uDE00"));
    }

    @Test
    void testContainsAny_WithEmptySearchChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("test", ""));
    }

    @Test
    void testContainsAny_WithSpaces_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello world", " "));
    }

    @Test
    void testContainsAny_WithSpecialCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello@world", "@"));
    }

    @Test
    void testContainsAny_WithNullInput_ReturnsFalse() {
        assertFalse(StringUtils.containsAny(null, "a"));
    }

    @Test
    void testContainsAny_WithMixedCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("123abc", "abc"));
    }
}
