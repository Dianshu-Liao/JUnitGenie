package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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
    public void testIndexOfAny_WithEmptyCharSequence_ShouldReturnIndexNotFound() {
        int result = StringUtils.indexOfAny("", 'a', 'b', 'c');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithNullCharSequence_ShouldReturnIndexNotFound() {
        int result = StringUtils.indexOfAny(null, 'a', 'b', 'c');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithEmptySearchChars_ShouldReturnIndexNotFound() {
        int result = StringUtils.indexOfAny("abc", new char[] {});
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithNoMatch_ShouldReturnIndexNotFound() {
        int result = StringUtils.indexOfAny("abc", 'd', 'e', 'f');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithFirstCharacterMatch_ShouldReturnIndexZero() {
        int result = StringUtils.indexOfAny("abc", 'a', 'b', 'c');
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfAny_WithMiddleCharacterMatch_ShouldReturnCorrectIndex() {
        int result = StringUtils.indexOfAny("abc", 'b', 'c', 'a');
        assertEquals(1, result);
    }

    @Test
    public void testIndexOfAny_WithLastCharacterMatch_ShouldReturnLastIndex() {
        int result = StringUtils.indexOfAny("abc", 'c', 'b', 'a');
        assertEquals(2, result);
    }

    @Test
    public void testIndexOfAny_WithSupplementaryCharacterMatch_ShouldReturnCorrectIndex() {
        int result = StringUtils.indexOfAny("abc\uD83D\uDE00", 'a', '\uD83D', 'c');
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfAny_WithMultipleMatches_ShouldReturnFirstMatchIndex() {
        int result = StringUtils.indexOfAny("aabbcc", 'b', 'c');
        assertEquals(2, result);
    }
}
