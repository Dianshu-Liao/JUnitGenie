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

public class StringUtils_normalizeSpace_137_0_Test {

    @Test
    public void testNormalizeSpaceWithNull() {
        String result = StringUtils.normalizeSpace(null);
        assertNull(result);
    }

    @Test
    public void testNormalizeSpaceWithEmptyString() {
        String result = StringUtils.normalizeSpace(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testNormalizeSpaceWithSpacesOnly() {
        String result = StringUtils.normalizeSpace("     ");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testNormalizeSpaceWithLeadingAndTrailingSpaces() {
        String result = StringUtils.normalizeSpace("   Hello World!   ");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testNormalizeSpaceWithMultipleSpacesBetweenWords() {
        String result = StringUtils.normalizeSpace("Hello   World!");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testNormalizeSpaceWithNonBreakingSpaces() {
        String result = StringUtils.normalizeSpace("Hello\u00A0World!");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testNormalizeSpaceWithMixedWhitespace() {
        String result = StringUtils.normalizeSpace("   Hello \n World!   ");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testNormalizeSpaceWithOnlyWhitespaceCharacters() {
        String result = StringUtils.normalizeSpace("\t\n\r  ");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testNormalizeSpaceWithSingleCharacter() {
        String result = StringUtils.normalizeSpace("A");
        assertEquals("A", result);
    }

    @Test
    public void testNormalizeSpaceWithSpecialCharacters() {
        String result = StringUtils.normalizeSpace("!@#$%^&*()");
        assertEquals("!@#$%^&*()", result);
    }

    @Test
    public void testNormalizeSpaceWithLeadingAndTrailingNewlines() {
        String result = StringUtils.normalizeSpace("\n   Hello World! \n");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testNormalizeSpaceWithTabs() {
        String result = StringUtils.normalizeSpace("Hello\tWorld!");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testNormalizeSpaceWithMixedSpacesAndTabs() {
        String result = StringUtils.normalizeSpace("Hello   \t   World!");
        assertEquals("Hello World!", result);
    }
}
