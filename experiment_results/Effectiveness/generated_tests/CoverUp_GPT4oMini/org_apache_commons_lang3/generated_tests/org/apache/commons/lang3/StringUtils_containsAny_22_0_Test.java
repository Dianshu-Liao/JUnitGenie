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
    public void testContainsAny_withNullInput() {
        assertFalse(StringUtils.containsAny(null, "a", "b"));
        assertFalse(StringUtils.containsAny("test", (CharSequence[]) null));
    }

    @Test
    public void testContainsAny_withEmptySearchChars() {
        assertFalse(StringUtils.containsAny("test", new CharSequence[] {}));
    }

    @Test
    public void testContainsAny_withNoMatches() {
        assertFalse(StringUtils.containsAny("test", "a", "b", "c"));
    }

    @Test
    public void testContainsAny_withSingleMatch() {
        assertTrue(StringUtils.containsAny("test", "t", "a", "b"));
        assertTrue(StringUtils.containsAny("test", "e", "a", "b"));
    }

    @Test
    public void testContainsAny_withMultipleMatches() {
        assertTrue(StringUtils.containsAny("test", "t", "e", "s"));
        assertTrue(StringUtils.containsAny("test", "t", "e", "a", "s"));
    }

    @Test
    public void testContainsAny_withSpecialCharacters() {
        assertTrue(StringUtils.containsAny("test!", "!", "@", "#"));
        assertFalse(StringUtils.containsAny("test", "!", "@", "#"));
    }

    @Test
    public void testContainsAny_withWhitespace() {
        assertTrue(StringUtils.containsAny("test test", " ", "a"));
        assertFalse(StringUtils.containsAny("test", " ", "a"));
    }
}
