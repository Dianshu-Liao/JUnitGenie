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

public class StringUtils_indexOfAny_64_1_Test {

    @Test
    public void testIndexOfAny_withEmptyCharSequence() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("", "a"));
    }

    @Test
    public void testIndexOfAny_withEmptySearchChars() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", ""));
    }

    @Test
    public void testIndexOfAny_withNoMatch() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", "d"));
    }

    @Test
    public void testIndexOfAny_withSingleMatch() {
        assertEquals(1, StringUtils.indexOfAny("abc", "b"));
    }

    @Test
    public void testIndexOfAny_withMultipleMatches() {
        assertEquals(0, StringUtils.indexOfAny("abc", "ab"));
    }

    @Test
    public void testIndexOfAny_withMultipleCharacters() {
        assertEquals(2, StringUtils.indexOfAny("hello", "aeiou"));
    }

    @Test
    public void testIndexOfAny_withSpecialCharacters() {
        assertEquals(3, StringUtils.indexOfAny("hello!", "!"));
    }

    @Test
    public void testIndexOfAny_withCharSequence() {
        assertEquals(1, StringUtils.indexOfAny("hello", new char[] { 'e', 'o' }));
    }
}
