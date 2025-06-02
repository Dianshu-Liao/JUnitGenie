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

public class StringUtils_containsAny_21_1_Test {

    @Test
    public void testContainsAny_WithNullSearchChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("test", (char[]) null));
    }

    @Test
    public void testContainsAny_WithEmptyString_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("", 'a'));
    }

    @Test
    public void testContainsAny_WithEmptySearchChars_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("test", new char[] {}));
    }

    @Test
    public void testContainsAny_WithNoMatches_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("test", 'x', 'y', 'z'));
    }

    @Test
    public void testContainsAny_WithSingleMatch_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("test", 'e'));
    }

    @Test
    public void testContainsAny_WithMultipleMatches_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("test", 'e', 't'));
    }

    @Test
    public void testContainsAny_WithSpecialCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("test@123", '@'));
    }

    @Test
    public void testContainsAny_WithMixedCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("Hello World!", 'o', 'W'));
    }

    @Test
    public void testContainsAny_WithWhitespace_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("Hello World!", ' '));
    }

//    @Test
//    public void testContainsAny_WithUnicodeCharacters_ReturnsTrue() {
//        assertTrue(StringUtils.containsAny("Café", 'é'));
//    }

    @Test
    public void testContainsAny_WithLongStringAndSearchChars_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("This is a long test string.", 'g', 't'));
    }

    @Test
    public void testContainsAny_WithLongStringAndNoMatches_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("This is a long test string.", 'z', 'x'));
    }
}
