package org.apache.commons.lang3;

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

public class StringUtils_substringAfterLast_213_0_Test {

    @Test
    public void testSubstringAfterLast_withValidInput() {
        String result = StringUtils.substringAfterLast("abc:def:ghi", ":");
        assertEquals("ghi", result);
    }

    @Test
    public void testSubstringAfterLast_withNoSeparator() {
        String result = StringUtils.substringAfterLast("abcdefghi", ":");
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withEmptyString() {
        String result = StringUtils.substringAfterLast("", ":");
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withEmptySeparator() {
        String result = StringUtils.substringAfterLast("abc:def:ghi", "");
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withSeparatorAtEnd() {
        String result = StringUtils.substringAfterLast("abc:def:", ":");
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withMultipleSeparators() {
        String result = StringUtils.substringAfterLast("abc:def:ghi:jkl", ":");
        assertEquals("jkl", result);
    }

    @Test
    public void testSubstringAfterLast_withNullString() {
        String result = StringUtils.substringAfterLast(null, ":");
        assertEquals(null, result);
    }

    @Test
    public void testSubstringAfterLast_withNullSeparator() {
        String result = StringUtils.substringAfterLast("abc:def:ghi", null);
        assertEquals("", result);
    }
}
