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
    public void testIndexOfAny_NullCharSequence() {
        char[] searchChars = { 'a', 'b', 'c' };
        int result = StringUtils.indexOfAny(null, searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_EmptyCharSequence() {
        char[] searchChars = { 'a', 'b', 'c' };
        int result = StringUtils.indexOfAny(StringUtils.EMPTY, searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_EmptySearchChars() {
        int result = StringUtils.indexOfAny("abc", new char[] {});
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_NoMatch() {
        char[] searchChars = { 'x', 'y', 'z' };
        int result = StringUtils.indexOfAny("abc", searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_FirstCharacterMatch() {
        char[] searchChars = { 'a', 'b', 'c' };
        int result = StringUtils.indexOfAny("abc", searchChars);
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfAny_LastCharacterMatch() {
        char[] searchChars = { 'c', 'd', 'e' };
        int result = StringUtils.indexOfAny("abc", searchChars);
        assertEquals(2, result);
    }

    @Test
    public void testIndexOfAny_MultipleMatches() {
        char[] searchChars = { 'a', 'b' };
        int result = StringUtils.indexOfAny("abcabc", searchChars);
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfAny_SupplementaryCharacterMatch() {
        // 😀
        char[] searchChars = { '\uD83D', '\uDE00' };
        int result = StringUtils.indexOfAny("\uD83D\uDE00", searchChars);
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfAny_SupplementaryCharacterNoMatch() {
        // 😁
        char[] searchChars = { '\uD83D', '\uDE01' };
        int result = StringUtils.indexOfAny("\uD83D\uDE00", searchChars);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_MixedCharacters() {
        char[] searchChars = { '1', '2', '3' };
        int result = StringUtils.indexOfAny("abc123", searchChars);
        assertEquals(3, result);
    }
}
