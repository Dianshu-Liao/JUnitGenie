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

class StringUtils_indexOfAny_63_0_Test {

    @Test
    void testIndexOfAny_NullStr() {
        int result = StringUtils.indexOfAny(null, "a", "b");
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    void testIndexOfAny_NullSearchStrs() {
        int result = StringUtils.indexOfAny("abc", (CharSequence) null);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    void testIndexOfAny_EmptyString() {
        int result = StringUtils.indexOfAny("", "a", "b");
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    void testIndexOfAny_NoMatches() {
        int result = StringUtils.indexOfAny("abc", "d", "e");
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    void testIndexOfAny_MultipleMatches() {
        int result = StringUtils.indexOfAny("abcde", "d", "b", "c");
        // 'b' is at index 1
        assertEquals(1, result);
    }

    @Test
    void testIndexOfAny_FirstMatch() {
        int result = StringUtils.indexOfAny("abcde", "a", "b", "c");
        // 'a' is at index 0
        assertEquals(0, result);
    }

    @Test
    void testIndexOfAny_IgnoreNullsInSearchStrs() {
        int result = StringUtils.indexOfAny("abcde", null, "b", null);
        // 'b' is at index 1
        assertEquals(1, result);
    }

    @Test
    void testIndexOfAny_SearchStrsAllNulls() {
        int result = StringUtils.indexOfAny("abc", (CharSequence) null, (CharSequence) null);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    void testIndexOfAny_MultipleSearchStrsSameIndex() {
        int result = StringUtils.indexOfAny("abcde", "b", "c", "a");
        // 'a' is at index 0
        assertEquals(0, result);
    }

    @Test
    void testIndexOfAny_SingleCharacterMatch() {
        int result = StringUtils.indexOfAny("abcde", "d");
        // 'd' is at index 3
        assertEquals(3, result);
    }
}
