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
        String result = StringUtils.leftPad(null, 10, ' ');
        assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testLeftPad_EmptyString() {
        String result = StringUtils.leftPad("", 10, ' ');
        assertEquals("          ", result, "Expected padding with spaces for empty string");
    }

    @Test
    public void testLeftPad_SmallerSize() {
        String result = StringUtils.leftPad("test", 2, ' ');
        assertEquals("test", result, "Expected original string when size is smaller than string length");
    }

    @Test
    public void testLeftPad_ExactSize() {
        String result = StringUtils.leftPad("test", 4, ' ');
        assertEquals("test", result, "Expected original string when size is equal to string length");
    }

    @Test
    public void testLeftPad_WithSpaces() {
        String result = StringUtils.leftPad("test", 10, ' ');
        assertEquals("      test", result, "Expected left padding of spaces");
    }

    @Test
    public void testLeftPad_WithCharacter() {
        String result = StringUtils.leftPad("test", 10, '*');
        assertEquals("******test", result, "Expected left padding with '*' character");
    }

    @Test
    public void testLeftPad_WithMultipleChars() {
        String result = StringUtils.leftPad("test", 10, "ab");
        assertEquals("abababtest", result, "Expected left padding with multiple characters");
    }

    @Test
    public void testLeftPad_WithLongPadString() {
        String result = StringUtils.leftPad("test", 15, "ab");
        assertEquals("abababababtest", result, "Expected left padding with repeating characters from pad string");
    }

    @Test
    public void testLeftPad_WithPadLimit() {
        String result = StringUtils.leftPad("test", 8200, '*');
        assertEquals(StringUtils.leftPad("test", 8200, '*'), result, "Expected handling of padding limit");
    }

    @Test
    public void testLeftPad_WithNegativeSize() {
        String result = StringUtils.leftPad("test", -1, ' ');
        assertEquals("test", result, "Expected original string when size is negative");
    }
}
