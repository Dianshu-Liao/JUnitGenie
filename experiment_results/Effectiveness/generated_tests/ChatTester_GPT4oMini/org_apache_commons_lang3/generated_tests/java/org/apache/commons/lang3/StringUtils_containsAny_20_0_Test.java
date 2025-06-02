package org.apache.commons.lang3;

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

class StringUtils_containsAny_20_0_Test {

    @Test
    void testContainsAny_WithNullCharSequence_ReturnsFalse() {
        assertFalse(StringUtils.containsAny(null, 'a', 'b', 'c'));
    }

    @Test
    void testContainsAny_WithEmptyCharSequence_ReturnsFalse() {
        assertFalse(StringUtils.containsAny(StringUtils.EMPTY, 'a', 'b', 'c'));
    }

    @Test
    void testContainsAny_WithEmptySearchChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("abc", new char[] {}));
    }

    @Test
    void testContainsAny_WithNoMatchingChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("abc", 'd', 'e', 'f'));
    }

    @Test
    void testContainsAny_WithMatchingChar_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("abc", 'a', 'd', 'e'));
    }

    @Test
    void testContainsAny_WithMultipleMatchingChars_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("xyz", 'x', 'y', 'z'));
    }

    @Test
    void testContainsAny_WithHighSurrogateCharacter_ReturnsTrue() {
        // Assuming surrogate pairs are handled correctly
        // Smiley face emoji
        assertTrue(StringUtils.containsAny("\uD83D\uDE00", '\uD83D', '\uDE00'));
    }

    @Test
    void testContainsAny_WithHighSurrogateAndNextChar_ReturnsTrue() {
        // Smiley face followed by 'A'
        String str = "\uD83D\uDE00" + "A";
        assertTrue(StringUtils.containsAny(str, '\uD83D', 'A'));
    }

    @Test
    void testContainsAny_WithHighSurrogateAndNoNextChar_ReturnsFalse() {
        // Smiley face only
        String str = "\uD83D\uDE00";
        assertFalse(StringUtils.containsAny(str, '\uD83D'));
    }

    @Test
    void testContainsAny_WithSpecialCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("!@#$%^&*()", '@', '#', '$'));
    }

    @Test
    void testContainsAny_WithMixedCaseCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("Hello World", 'H', 'W'));
    }

    @Test
    void testContainsAny_WithNonMatchingSpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("abc123", '!', '@', '#'));
    }
}
