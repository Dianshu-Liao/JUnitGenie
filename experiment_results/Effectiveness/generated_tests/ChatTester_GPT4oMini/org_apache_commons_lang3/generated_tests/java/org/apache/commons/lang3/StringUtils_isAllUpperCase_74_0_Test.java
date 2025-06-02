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

public class StringUtils_isAllUpperCase_74_0_Test {

    @Test
    public void testIsAllUpperCase_WithUpperCaseString_ReturnsTrue() {
        assertTrue(StringUtils.isAllUpperCase("HELLO"));
    }

    @Test
    public void testIsAllUpperCase_WithMixedCaseString_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("Hello"));
    }

    @Test
    public void testIsAllUpperCase_WithLowerCaseString_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("hello"));
    }

    @Test
    public void testIsAllUpperCase_WithEmptyString_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase(StringUtils.EMPTY));
    }

    @Test
    public void testIsAllUpperCase_WithNull_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase(null));
    }

    @Test
    public void testIsAllUpperCase_WithNumericString_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("12345"));
    }

    @Test
    public void testIsAllUpperCase_WithSpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("!@#$%"));
    }

    @Test
    public void testIsAllUpperCase_WithUpperCaseAndSpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("HELLO!"));
    }

    @Test
    public void testIsAllUpperCase_WithSingleCharacterUpperCase_ReturnsTrue() {
        assertTrue(StringUtils.isAllUpperCase("A"));
    }

    @Test
    public void testIsAllUpperCase_WithSingleCharacterLowerCase_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("a"));
    }

    @Test
    public void testIsAllUpperCase_WithSingleCharacterNumeric_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("1"));
    }

    @Test
    public void testIsAllUpperCase_WithUppercaseWhitespace_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("  "));
    }

    @Test
    public void testIsAllUpperCase_WithUppercaseAndWhitespace_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase(" HELLO "));
    }
}
