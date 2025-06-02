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

public class StringUtils_containsAny_22_0_Test {

    @Test
    public void testContainsAny_WithNullCharSequence_ReturnsFalse() {
        assertFalse(StringUtils.containsAny(null, "a", "b"));
    }

    @Test
    public void testContainsAny_WithEmptyCharSequence_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("", "a", "b"));
    }

    @Test
    public void testContainsAny_WithNoMatches_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("hello", "a", "b"));
    }

    @Test
    public void testContainsAny_WithSingleMatch_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello", "e", "b"));
    }

    @Test
    public void testContainsAny_WithMultipleMatches_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello", "e", "o"));
    }

    @Test
    public void testContainsAny_WithAllMatches_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello", "h", "e", "l", "o"));
    }

    @Test
    public void testContainsAny_WithSpecialCharacters_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello@world", "@", "#"));
    }

    @Test
    public void testContainsAny_WithMultipleSearchCharSequences_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("abcdefg", "x", "y", "c"));
    }

    @Test
    public void testContainsAny_WithWhitespace_ReturnsTrue() {
        assertTrue(StringUtils.containsAny("hello world", " ", "o"));
    }

    @Test
    public void testContainsAny_WithNullSearchCharSequences_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("hello", (CharSequence[]) null));
    }

    @Test
    public void testContainsAny_WithEmptySearchCharSequences_ReturnsFalse() {
        assertFalse(StringUtils.containsAny("hello", new CharSequence[] {}));
    }
}
