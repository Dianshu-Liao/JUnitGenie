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

public class StringUtils_indexOfAny_62_0_Test {

    @Test
    public void testIndexOfAny_WithEmptyCharSequence_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("", 'a', 'b', 'c'));
    }

    @Test
    public void testIndexOfAny_WithNullCharSequence_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny(null, 'a', 'b', 'c'));
    }

    @Test
    public void testIndexOfAny_WithEmptySearchChars_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", new char[] {}));
    }

    @Test
    public void testIndexOfAny_WithNoMatches_ReturnsIndexNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", 'd', 'e', 'f'));
    }

    @Test
    public void testIndexOfAny_WithSingleMatch_ReturnsCorrectIndex() {
        assertEquals(1, StringUtils.indexOfAny("abc", 'b', 'd', 'e'));
    }

    @Test
    public void testIndexOfAny_WithMultipleMatches_ReturnsFirstMatchIndex() {
        assertEquals(0, StringUtils.indexOfAny("abcabc", 'a', 'b', 'c'));
    }

    @Test
    public void testIndexOfAny_WithHighSurrogateCharacter_ReturnsCorrectIndex() {
        // 😀 is a surrogate pair
        char[] searchChars = { '\uD83D', '\uDE00' };
        // 😀abc
        String testString = "\uD83D\uDE00abc";
        assertEquals(0, StringUtils.indexOfAny(testString, searchChars));
    }

    @Test
    public void testIndexOfAny_WithMixedCharacters_ReturnsCorrectIndex() {
        assertEquals(2, StringUtils.indexOfAny("hello world", 'w', 'o'));
    }
}
