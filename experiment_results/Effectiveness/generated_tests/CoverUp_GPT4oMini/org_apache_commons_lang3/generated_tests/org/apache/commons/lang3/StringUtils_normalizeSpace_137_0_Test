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

class StringUtils_normalizeSpace_137_0_Test {

    @Test
    void testNormalizeSpace_WithNullInput() {
        assertNull(StringUtils.normalizeSpace(null));
    }

    @Test
    void testNormalizeSpace_WithEmptyString() {
        assertEquals(StringUtils.EMPTY, StringUtils.normalizeSpace(""));
    }

    @Test
    void testNormalizeSpace_WithSpacesOnly() {
        assertEquals(StringUtils.EMPTY, StringUtils.normalizeSpace("   "));
    }

    @Test
    void testNormalizeSpace_WithLeadingAndTrailingSpaces() {
        assertEquals("abc", StringUtils.normalizeSpace("   abc   "));
    }

    @Test
    void testNormalizeSpace_WithMultipleSpacesBetweenWords() {
        assertEquals("abc def", StringUtils.normalizeSpace("abc    def"));
    }

    @Test
    void testNormalizeSpace_WithNonBreakingSpaces() {
        assertEquals("abc def", StringUtils.normalizeSpace("abc\u00A0\u00A0def"));
    }

    @Test
    void testNormalizeSpace_WithMixedWhitespaceCharacters() {
        assertEquals("abc def", StringUtils.normalizeSpace("abc\n\t  def"));
    }

    @Test
    void testNormalizeSpace_WithNoWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("abc"));
    }

    @Test
    void testNormalizeSpace_WithTrailingWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("abc "));
    }

    @Test
    void testNormalizeSpace_WithLeadingWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace(" abc"));
    }
}
