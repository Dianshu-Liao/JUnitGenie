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

public class StringUtils_substringAfterLast_212_0_Test {

    @Test
    public void testSubstringAfterLast_ValidSeparator() {
        String input = "abc:def:ghi";
        int separator = ':';
        String expected = "ghi";
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringAfterLast_NoSeparator() {
        String input = "abcdefg";
        int separator = ':';
        String expected = "";
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringAfterLast_SeparatorAtEnd() {
        String input = "abc:def:";
        int separator = ':';
        String expected = "";
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringAfterLast_EmptyString() {
        String input = "";
        int separator = ':';
        String expected = "";
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringAfterLast_NullString() {
        String input = null;
        int separator = ':';
        String expected = null;
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringAfterLast_MultipleSeparators() {
        String input = "one:two:three:four";
        int separator = ':';
        String expected = "four";
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringAfterLast_SeparatorNotFound() {
        String input = "abcdefg";
        int separator = 'x';
        String expected = "";
        String actual = StringUtils.substringAfterLast(input, separator);
        assertEquals(expected, actual);
    }
}
