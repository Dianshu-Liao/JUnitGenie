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

public class StringUtils_stripStart_205_0_Test {

    @Test
    public void testStripStart_WithLeadingSpaces() {
        assertEquals("test", StringUtils.stripStart("   test", null));
    }

    @Test
    public void testStripStart_WithLeadingCharacters() {
        assertEquals("test", StringUtils.stripStart("xxxtest", "x"));
    }

    @Test
    public void testStripStart_WithNoLeadingCharacters() {
        assertEquals("test", StringUtils.stripStart("test", "x"));
    }

    @Test
    public void testStripStart_WithNullString() {
        assertEquals(null, StringUtils.stripStart(null, "x"));
    }

    @Test
    public void testStripStart_WithEmptyString() {
        assertEquals("", StringUtils.stripStart("", "x"));
    }

    @Test
    public void testStripStart_WithEmptyStripChars() {
        assertEquals("   test", StringUtils.stripStart("   test", ""));
    }

    @Test
    public void testStripStart_WithLeadingWhitespaceAndCharacters() {
        assertEquals("test", StringUtils.stripStart("   xxxtest", "x "));
    }

    @Test
    public void testStripStart_WithOnlyStripChars() {
        assertEquals("", StringUtils.stripStart("xxx", "x"));
    }

    @Test
    public void testStripStart_WithNonLeadingChars() {
        assertEquals("test", StringUtils.stripStart("testxxx", "x"));
    }

    @Test
    public void testStripStart_WithAllStripChars() {
        assertEquals("", StringUtils.stripStart("xxx", "x"));
    }

    @Test
    public void testStripStart_WithSpecialCharacters() {
        assertEquals("test", StringUtils.stripStart("!!!test", "!"));
    }

    @Test
    public void testStripStart_WithMixedCharacters() {
        assertEquals("test", StringUtils.stripStart("xxxtest", "x!"));
    }
}
