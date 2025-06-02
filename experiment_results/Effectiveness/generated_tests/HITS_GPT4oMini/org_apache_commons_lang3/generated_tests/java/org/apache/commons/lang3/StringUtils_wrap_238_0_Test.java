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

public class StringUtils_wrap_238_0_Test {

    @Test
    public void testWrap_WithValidInput_ShouldWrapString() {
        String result = StringUtils.wrap("test", "*");
        assertEquals("*test*", result, "The string should be wrapped with the specified characters.");
    }

    @Test
    public void testWrap_WithEmptyString_ShouldReturnEmptyString() {
        String result = StringUtils.wrap("", "*");
        assertEquals("", result, "An empty string should return an empty string.");
    }

    @Test
    public void testWrap_WithEmptyWrap_ShouldReturnOriginalString() {
        String result = StringUtils.wrap("test", "");
        assertEquals("test", result, "Wrapping with an empty string should return the original string.");
    }

    @Test
    public void testWrap_WithNullString_ShouldReturnNull() {
        String result = StringUtils.wrap(null, "*");
        assertEquals(null, result, "Wrapping a null string should return null.");
    }

    @Test
    public void testWrap_WithNullWrap_ShouldReturnOriginalString() {
        String result = StringUtils.wrap("test", null);
        assertEquals("test", result, "Wrapping with a null string should return the original string.");
    }

    @Test
    public void testWrap_WithBothEmpty_ShouldReturnEmptyString() {
        String result = StringUtils.wrap("", "");
        assertEquals("", result, "Both empty strings should return an empty string.");
    }

    @Test
    public void testWrap_WithSpaces_ShouldWrapCorrectly() {
        String result = StringUtils.wrap(" ", "*");
        assertEquals("* *", result, "A space should be wrapped correctly.");
    }

    @Test
    public void testWrap_WithSpecialCharacters_ShouldWrapCorrectly() {
        String result = StringUtils.wrap("!@#", "$");
        assertEquals("$!@#$", result, "Special characters should be wrapped correctly.");
    }
}
