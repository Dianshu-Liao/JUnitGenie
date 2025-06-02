// Test method
package org.apache.commons.lang3;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtils_indexOfAny_63_0_Test {

    @Test
    public void testIndexOfAny_NullString() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny(null, "a", "b"));
    }

    @Test
    public void testIndexOfAny_NullSearchStrs() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("test", (CharSequence[]) null));
    }

    @Test
    public void testIndexOfAny_EmptyString() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("", "a", "b"));
    }

    @Test
    public void testIndexOfAny_NoMatches() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("test", "x", "y"));
    }

    @Test
    public void testIndexOfAny_SingleMatch() {
        assertEquals(1, StringUtils.indexOfAny("test", "e", "t"));
    }

    @Test
    public void testIndexOfAny_MultipleMatches() {
        assertEquals(0, StringUtils.indexOfAny("test", "t", "e"));
    }

    @Test
    public void testIndexOfAny_NullInSearchStrs() {
        assertEquals(1, StringUtils.indexOfAny("test", null, "e", "t"));
    }

    @Test
    public void testIndexOfAny_AllNullSearchStrs() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("test", (CharSequence[]) null));
    }

    @Test
    public void testIndexOfAny_EmptySearchStrs() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("test", new CharSequence[] {}));
    }

    @Test
    public void testIndexOfAny_LeadingCharacterMatch() {
        assertEquals(0, StringUtils.indexOfAny("test", "t", "a"));
    }

    @Test
    public void testIndexOfAny_TrailingCharacterMatch() {
        assertEquals(3, StringUtils.indexOfAny("test", "a", "t"));
    }

    @Test
    public void testIndexOfAny_MultipleMatchesDifferentOrder() {
        assertEquals(0, StringUtils.indexOfAny("test", "t", "s", "e"));
    }

    @Test
    public void testIndexOfAny_OnlyNullsInSearchStrs() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.indexOfAny("test", new CharSequence[] { null, null }));
    }
}
