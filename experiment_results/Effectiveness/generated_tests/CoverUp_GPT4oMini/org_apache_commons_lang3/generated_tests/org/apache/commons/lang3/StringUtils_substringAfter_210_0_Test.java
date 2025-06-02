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

public class StringUtils_substringAfter_210_0_Test {

    @Test
    public void testSubstringAfter_WithEmptyString() {
        String result = StringUtils.substringAfter("", 'a');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfter_WithSeparatorNotFound() {
        String result = StringUtils.substringAfter("hello", 'x');
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testSubstringAfter_WithSeparatorAtStart() {
        String result = StringUtils.substringAfter("hello", 'h');
        assertEquals("ello", result);
    }

    @Test
    public void testSubstringAfter_WithSeparatorAtEnd() {
        String result = StringUtils.substringAfter("hello", 'o');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfter_WithMultipleOccurrences() {
        String result = StringUtils.substringAfter("hello world", 'o');
        assertEquals(" world", result);
    }

    @Test
    public void testSubstringAfter_WithNullString() {
        String result = StringUtils.substringAfter(null, 'a');
        assertNull(result);
    }

    @Test
    public void testSubstringAfter_WithDifferentSeparator() {
        String result = StringUtils.substringAfter("abc:def:ghi", ':');
        assertEquals("def:ghi", result);
    }
}
