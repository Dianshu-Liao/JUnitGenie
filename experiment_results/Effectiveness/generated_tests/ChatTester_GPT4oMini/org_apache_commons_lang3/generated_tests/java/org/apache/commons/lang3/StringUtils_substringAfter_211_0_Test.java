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

class StringUtils_substringAfter_211_0_Test {

    @Test
    void testSubstringAfter_EmptyString() {
        String result = StringUtils.substringAfter("", "separator");
        assertEquals("", result);
    }

    @Test
    void testSubstringAfter_NullSeparator() {
        String result = StringUtils.substringAfter("testString", null);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    void testSubstringAfter_SeparatorNotFound() {
        String result = StringUtils.substringAfter("testString", "notFound");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    void testSubstringAfter_SeparatorAtStart() {
        String result = StringUtils.substringAfter("separatorTestString", "separator");
        assertEquals("TestString", result);
    }

    @Test
    void testSubstringAfter_SeparatorAtEnd() {
        String result = StringUtils.substringAfter("testStringSeparator", "separator");
        assertEquals("", result);
    }

    @Test
    void testSubstringAfter_MultipleSeparators() {
        String result = StringUtils.substringAfter("firstSeparatorSecondSeparator", "Separator");
        assertEquals("SecondSeparator", result);
    }

    @Test
    void testSubstringAfter_SeparatorIsEmpty() {
        String result = StringUtils.substringAfter("testString", "");
        assertEquals("testString", result);
    }
}
