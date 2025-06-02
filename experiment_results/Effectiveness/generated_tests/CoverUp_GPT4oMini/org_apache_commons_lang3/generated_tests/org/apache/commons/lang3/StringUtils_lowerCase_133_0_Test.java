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

class StringUtils_lowerCase_133_0_Test {

    @Test
    void testLowerCaseWithNull() {
        // Test input is null
        assertNull(StringUtils.lowerCase(null));
    }

    @Test
    void testLowerCaseWithEmptyString() {
        // Test input is an empty string
        assertEquals(StringUtils.EMPTY, StringUtils.lowerCase(StringUtils.EMPTY));
    }

    @Test
    void testLowerCaseWithLowerCaseString() {
        // Test input is already in lower case
        String input = "lowercase";
        assertEquals(input, StringUtils.lowerCase(input));
    }

    @Test
    void testLowerCaseWithUpperCaseString() {
        // Test input is in upper case
        String input = "UPPERCASE";
        assertEquals("uppercase", StringUtils.lowerCase(input));
    }

    @Test
    void testLowerCaseWithMixedCaseString() {
        // Test input is a mixed case string
        String input = "MiXeD CaSe";
        assertEquals("mixed case", StringUtils.lowerCase(input));
    }

    @Test
    void testLowerCaseWithStringContainingNumbersAndSymbols() {
        // Test input containing numbers and symbols
        String input = "123ABC!@#";
        assertEquals("123abc!@#", StringUtils.lowerCase(input));
    }

    @Test
    void testLowerCaseWithWhitespace() {
        // Test input with leading and trailing whitespace
        String input = "  Whitespace  ";
        assertEquals("  whitespace  ", StringUtils.lowerCase(input));
    }
}
