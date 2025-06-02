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

public class StringUtils_rightPad_176_0_Test {

    @Test
    public void testRightPad_NullString() {
        String result = StringUtils.rightPad(null, 10, " ");
        assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testRightPad_EmptyPadString() {
        String result = StringUtils.rightPad("test", 10, "");
        assertEquals("test     ", result, "Expected right padding with spaces when padStr is empty");
    }

    @Test
    public void testRightPad_SingleCharacterPad() {
        String result = StringUtils.rightPad("test", 10, "x");
        assertEquals("testxxxxxx", result, "Expected right padding with single character");
    }

    @Test
    public void testRightPad_ExactSize() {
        String result = StringUtils.rightPad("test", 4, " ");
        assertEquals("test", result, "Expected original string when size is equal to string length");
    }

    @Test
    public void testRightPad_PadLongerThanNeeded() {
        String result = StringUtils.rightPad("test", 10, "abcdefghij");
        assertEquals("testabcdefg", result, "Expected right padding with substring of padStr when it's longer than needed");
    }

    @Test
    public void testRightPad_PadExactlyNeeded() {
        String result = StringUtils.rightPad("test", 10, "abc");
        assertEquals("testabcabc", result, "Expected right padding with repeated padStr to fill exactly needed space");
    }

    @Test
    public void testRightPad_PaddingWithSpaces() {
        String result = StringUtils.rightPad("test", 10, " ");
        assertEquals("test     ", result, "Expected right padding with spaces");
    }

    @Test
    public void testRightPad_PaddingWithMultipleCharacters() {
        String result = StringUtils.rightPad("test", 12, "xyz");
        assertEquals("testxyzxyzxy", result, "Expected right padding with repeated characters from padStr");
    }

    @Test
    public void testRightPad_SmallPadLimit() {
        String result = StringUtils.rightPad("test", 20, "x");
        assertEquals("testxxxxxxxxxxxxxxxx", result, "Expected right padding with repeated 'x' until size");
    }

    @Test
    public void testRightPad_SmallPadLimitWithNull() {
        String result = StringUtils.rightPad("test", 20, null);
        assertEquals("test                    ", result, "Expected right padding with spaces when padStr is null");
    }
}
