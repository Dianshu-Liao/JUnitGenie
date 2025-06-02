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

public class StringUtils_containsAny_21_0_Test {

    @Test
    public void testContainsAny_NullSearchChars() {
        // Fixed the ambiguous reference by specifying the method with varargs
        assertFalse(StringUtils.containsAny("test", (CharSequence) null));
    }

    @Test
    public void testContainsAny_EmptyString() {
        // Test case where cs is an empty string and searchChars is not null
        assertFalse(StringUtils.containsAny("", "a"));
    }

    @Test
    public void testContainsAny_NoMatch() {
        // Test case where cs does not contain any characters from searchChars
        assertFalse(StringUtils.containsAny("test", "xyz"));
    }

    @Test
    public void testContainsAny_SingleMatch() {
        // Test case where cs contains one character from searchChars
        assertTrue(StringUtils.containsAny("test", "e"));
    }

    @Test
    public void testContainsAny_MultipleMatches() {
        // Test case where cs contains multiple characters from searchChars
        assertTrue(StringUtils.containsAny("test", "est"));
    }

    @Test
    public void testContainsAny_ExactMatch() {
        // Test case where cs is exactly equal to searchChars
        assertTrue(StringUtils.containsAny("test", "test"));
    }

    @Test
    public void testContainsAny_EmptySearchChars() {
        // Test case where searchChars is an empty string
        assertFalse(StringUtils.containsAny("test", ""));
    }

    @Test
    public void testContainsAny_NullCs() {
        // Test case where cs is null
        assertFalse(StringUtils.containsAny(null, "a"));
    }

    @Test
    public void testContainsAny_WithSpecialCharacters() {
        // Test case where cs contains special characters and searchChars includes them
        assertTrue(StringUtils.containsAny("test@123", "@"));
        assertFalse(StringUtils.containsAny("test123", "!"));
    }

    @Test
    public void testContainsAny_WithWhitespace() {
        // Test case where cs contains whitespace and searchChars includes whitespace
        assertTrue(StringUtils.containsAny("test test", " "));
        assertFalse(StringUtils.containsAny("testtest", " "));
    }
}
