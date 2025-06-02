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

class StringUtils_containsAny_22_0_Test {

    @Test
    void testContainsAny_WithNullCharSequence() {
        assertFalse(StringUtils.containsAny(null, "a", "b"));
    }

    @Test
    void testContainsAny_WithEmptyCharSequence() {
        assertFalse(StringUtils.containsAny("", "a", "b"));
    }

    @Test
    void testContainsAny_WithSingleMatch() {
        assertTrue(StringUtils.containsAny("abc", "a", "b"));
    }

    @Test
    void testContainsAny_WithMultipleMatches() {
        assertTrue(StringUtils.containsAny("abc", "x", "b", "y"));
    }

    @Test
    void testContainsAny_WithNoMatches() {
        assertFalse(StringUtils.containsAny("abc", "x", "y"));
    }

    @Test
    void testContainsAny_WithMultipleSearchSequences() {
        assertTrue(StringUtils.containsAny("hello world", "z", "o", "w"));
    }

    @Test
    void testContainsAny_WithAllCharacters() {
        assertTrue(StringUtils.containsAny("hello", "h", "e", "l"));
    }

    @Test
    void testContainsAny_WithSearchCharSequencesNull() {
        assertThrows(NullPointerException.class, () -> {
            StringUtils.containsAny("abc", (CharSequence[]) null);
        });
    }
}
