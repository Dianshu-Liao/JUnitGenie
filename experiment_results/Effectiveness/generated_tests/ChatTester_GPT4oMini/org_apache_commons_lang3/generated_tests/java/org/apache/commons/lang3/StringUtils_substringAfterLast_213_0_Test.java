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

public class StringUtils_substringAfterLast_213_0_Test {

    @Test
    public void testSubstringAfterLast_WithNullString_ReturnsNull() {
        String result = StringUtils.substringAfterLast(null, "separator");
        assertNull(result);
    }

    @Test
    public void testSubstringAfterLast_WithEmptyString_ReturnsEmptyString() {
        String result = StringUtils.substringAfterLast("", "separator");
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_WithEmptySeparator_ReturnsEmptyString() {
        String result = StringUtils.substringAfterLast("test", "");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testSubstringAfterLast_WithSeparatorNotFound_ReturnsEmptyString() {
        String result = StringUtils.substringAfterLast("test", "notfound");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testSubstringAfterLast_WithSeparatorAtEnd_ReturnsEmptyString() {
        String result = StringUtils.substringAfterLast("test.separator", ".");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testSubstringAfterLast_WithValidSeparator_ReturnsSubstringAfterLast() {
        String result = StringUtils.substringAfterLast("test.separator.value", ".");
        assertEquals("value", result);
    }

    @Test
    public void testSubstringAfterLast_WithMultipleSeparators_ReturnsSubstringAfterLast() {
        String result = StringUtils.substringAfterLast("one.two.three", ".");
        assertEquals("three", result);
    }

    @Test
    public void testSubstringAfterLast_WithSeparatorAtStart_ReturnsSubstringAfterLast() {
        String result = StringUtils.substringAfterLast(".start", ".");
        assertEquals("start", result);
    }

    @Test
    public void testSubstringAfterLast_WithSeparatorAtBeginningAndEnd_ReturnsEmptyString() {
        String result = StringUtils.substringAfterLast(".", ".");
        assertEquals(StringUtils.EMPTY, result);
    }
}
