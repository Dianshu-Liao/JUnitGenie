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

public class StringUtils_leftPad_130_0_Test {

    @Test
    public void testLeftPad_NullString() {
        assertNull(StringUtils.leftPad(null, 5, ' '));
    }

    @Test
    public void testLeftPad_EmptyString() {
        assertEquals("     ", StringUtils.leftPad("", 5, ' '));
    }

    @Test
    public void testLeftPad_SmallerThanRequiredSize() {
        assertEquals("abc", StringUtils.leftPad("abc", 3, ' '));
    }

    @Test
    public void testLeftPad_ExactSize() {
        assertEquals("abc", StringUtils.leftPad("abc", 3, ' '));
    }

    @Test
    public void testLeftPad_LargerThanRequiredSize() {
        assertEquals("  abc", StringUtils.leftPad("abc", 5, ' '));
    }

    @Test
    public void testLeftPad_WithPadChar() {
        assertEquals("xxabc", StringUtils.leftPad("abc", 5, 'x'));
    }

    @Test
    public void testLeftPad_WithMultiplePadChars() {
        assertEquals("xxabc", StringUtils.leftPad("abc", 5, "xx"));
    }

    @Test
    public void testLeftPad_WithPadCharExceedingLimit() {
        assertEquals("abc", StringUtils.leftPad("abc", 10, ' '));
    }

    @Test
    public void testLeftPad_WithPadString() {
        assertEquals("abcdeabc", StringUtils.leftPad("abc", 10, "abcde"));
    }

    @Test
    public void testLeftPad_WithPadStringExactSize() {
        assertEquals("abcde", StringUtils.leftPad("abcde", 5, "abcde"));
    }

    @Test
    public void testLeftPad_WithPadStringShorterThanRequiredSize() {
        assertEquals("ababc", StringUtils.leftPad("abc", 5, "ab"));
    }

    @Test
    public void testLeftPad_WithPadStringLongerThanRequiredSize() {
        assertEquals("abc", StringUtils.leftPad("abc", 3, "abcdef"));
    }

    @Test
    public void testLeftPad_WithLargePadding() {
        String result = StringUtils.leftPad("test", 8195, 'x');
        assertEquals("xxxxtest", result.substring(8191));
    }
}
