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

public class StringUtils_center_8_0_Test {

    @Test
    public void testCenter_NullString() {
        String result = StringUtils.center(null, 10);
        assertEquals(null, result, "Expected null when input string is null");
    }

    @Test
    public void testCenter_ZeroSize() {
        String result = StringUtils.center("test", 0);
        assertEquals("test", result, "Expected same string when size is zero");
    }

    @Test
    public void testCenter_NegativeSize() {
        String result = StringUtils.center("test", -5);
        assertEquals("test", result, "Expected same string when size is negative");
    }

    @Test
    public void testCenter_SmallerSize() {
        String result = StringUtils.center("test", 3);
        assertEquals("test", result, "Expected same string when size is smaller than string length");
    }

    @Test
    public void testCenter_ExactSize() {
        String result = StringUtils.center("test", 4);
        assertEquals("test", result, "Expected same string when size is equal to string length");
    }

    @Test
    public void testCenter_PositiveSize() {
        String result = StringUtils.center("test", 10);
        assertEquals("   test    ", result, "Expected string to be centered with spaces");
    }

    @Test
    public void testCenter_OddSize() {
        String result = StringUtils.center("test", 9);
        assertEquals("   test   ", result, "Expected string to be centered with spaces for odd size");
    }

    @Test
    public void testCenter_EmptyString() {
        String result = StringUtils.center("", 10);
        assertEquals("          ", result, "Expected empty string to be centered with spaces");
    }

    @Test
    public void testCenter_SingleCharacter() {
        String result = StringUtils.center("A", 3);
        assertEquals(" A ", result, "Expected single character to be centered with spaces");
    }
}
