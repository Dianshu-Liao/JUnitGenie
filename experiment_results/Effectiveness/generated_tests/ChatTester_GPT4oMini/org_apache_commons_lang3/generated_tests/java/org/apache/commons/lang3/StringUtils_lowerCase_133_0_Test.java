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

public class StringUtils_lowerCase_133_0_Test {

    @Test
    public void testLowerCase_NullInput() {
        // Test case for null input
        String result = StringUtils.lowerCase(null);
        assertNull(result, "Expected null for null input");
    }

    @Test
    public void testLowerCase_EmptyString() {
        // Test case for empty string
        String result = StringUtils.lowerCase(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, result, "Expected empty string for empty input");
    }

    @Test
    public void testLowerCase_AlreadyLowerCase() {
        // Test case for already lower case string
        String input = "hello";
        String result = StringUtils.lowerCase(input);
        assertEquals(input, result, "Expected the same string for already lower case input");
    }

    @Test
    public void testLowerCase_MixedCase() {
        // Test case for mixed case string
        String input = "HeLLo WoRLd";
        String expected = "hello world";
        String result = StringUtils.lowerCase(input);
        assertEquals(expected, result, "Expected lower case conversion for mixed case input");
    }

    @Test
    public void testLowerCase_UpperCase() {
        // Test case for upper case string
        String input = "HELLO";
        String expected = "hello";
        String result = StringUtils.lowerCase(input);
        assertEquals(expected, result, "Expected lower case conversion for upper case input");
    }
}
