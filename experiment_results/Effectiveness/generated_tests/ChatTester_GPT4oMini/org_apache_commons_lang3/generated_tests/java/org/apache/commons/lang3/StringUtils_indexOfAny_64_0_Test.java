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

public class StringUtils_indexOfAny_64_0_Test {

    @Test
    public void testIndexOfAny_WithEmptyCharSequence_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("", "abc"));
    }

    @Test
    public void testIndexOfAny_WithEmptySearchChars_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", ""));
    }

    @Test
    public void testIndexOfAny_WithNoMatch_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", "xyz"));
    }

    @Test
    public void testIndexOfAny_WithMatchAtStart_ReturnsCorrectIndex() {
        assertEquals(0, StringUtils.indexOfAny("abc", "a"));
    }

    @Test
    public void testIndexOfAny_WithMatchInMiddle_ReturnsCorrectIndex() {
        assertEquals(1, StringUtils.indexOfAny("abc", "b"));
    }

    @Test
    public void testIndexOfAny_WithMatchAtEnd_ReturnsCorrectIndex() {
        assertEquals(2, StringUtils.indexOfAny("abc", "c"));
    }

    @Test
    public void testIndexOfAny_WithMultipleMatches_ReturnsFirstMatch() {
        assertEquals(1, StringUtils.indexOfAny("abcabc", "bc"));
    }

    @Test
    public void testIndexOfAny_WithSpecialCharacters_ReturnsCorrectIndex() {
        assertEquals(0, StringUtils.indexOfAny("!@#abc", "@#"));
    }

    @Test
    public void testIndexOfAny_WithNullCharSequence_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny(null, "abc"));
    }

    @Test
    public void testIndexOfAny_WithNullSearchChars_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", (CharSequence) null));
    }
}
