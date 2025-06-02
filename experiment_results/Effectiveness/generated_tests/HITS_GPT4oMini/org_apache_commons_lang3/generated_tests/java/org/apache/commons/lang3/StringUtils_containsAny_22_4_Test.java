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

public class StringUtils_containsAny_22_4_Test {

    @Test
    public void testContainsAny_WithNullInput() {
        assertFalse(StringUtils.containsAny(null, "a", "b"));
    }

    @Test
    public void testContainsAny_WithEmptySearchCharSequences() {
        assertFalse(StringUtils.containsAny("test", new CharSequence[] {}));
    }

    @Test
    public void testContainsAny_WithNoMatches() {
        assertFalse(StringUtils.containsAny("test", "x", "y", "z"));
    }

    @Test
    public void testContainsAny_WithSingleMatch() {
        assertTrue(StringUtils.containsAny("test", "t", "x", "y"));
    }

    @Test
    public void testContainsAny_WithMultipleMatches() {
        assertTrue(StringUtils.containsAny("test", "x", "t", "y"));
    }

    @Test
    public void testContainsAny_WithSpecialCharacters() {
        assertTrue(StringUtils.containsAny("!@#$%^&*()", "@", "#"));
    }

    @Test
    public void testContainsAny_WithCaseSensitivity() {
        assertTrue(StringUtils.containsAny("Test", "T"));
        assertFalse(StringUtils.containsAny("Test", "t"));
    }

    @Test
    public void testContainsAny_WithNullSearchCharSequences() {
        assertFalse(StringUtils.containsAny("test", new CharSequence[] { null }));
    }

    @Test
    public void testContainsAny_WithMultipleNullSearchCharSequences() {
        assertTrue(StringUtils.containsAny("test", new CharSequence[] { null, "t" }));
    }

    @Test
    public void testContainsAny_WithAllNullInput() {
        assertFalse(StringUtils.containsAny(null, new CharSequence[] { null }));
    }

    @Test
    public void testContainsAny_WithEmptyInput() {
        assertFalse(StringUtils.containsAny("", "a", "b"));
    }

    @Test
    public void testContainsAny_WithEmptySearchCharSequencesAndEmptyInput() {
        assertFalse(StringUtils.containsAny("", new CharSequence[] {}));
    }
}
