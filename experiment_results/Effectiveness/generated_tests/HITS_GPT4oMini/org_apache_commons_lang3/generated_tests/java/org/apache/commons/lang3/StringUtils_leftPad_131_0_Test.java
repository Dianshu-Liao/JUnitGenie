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

public class StringUtils_leftPad_131_0_Test {

    @Test
    public void testLeftPad_NullString() {
        String result = StringUtils.leftPad(null, 5, '*');
        assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testLeftPad_EmptyPadString() {
        String result = StringUtils.leftPad("test", 10, "");
        assertEquals("     test", result, "Expected padding with spaces when pad string is empty");
    }

    @Test
    public void testLeftPad_SingleCharacterPad() {
        String result = StringUtils.leftPad("test", 10, "*");
        assertEquals("*****test", result, "Expected padding with '*' character");
    }

    @Test
    public void testLeftPad_PadLongerThanNeeded() {
        String result = StringUtils.leftPad("test", 10, "123456");
        assertEquals("12345test", result, "Expected padding with substring of pad string");
    }

    @Test
    public void testLeftPad_PadExactlyMatches() {
        String result = StringUtils.leftPad("test", 4, "1234");
        assertEquals("test", result, "Expected original string when pad length matches string length");
    }

    @Test
    public void testLeftPad_PadShorterThanNeeded() {
        String result = StringUtils.leftPad("test", 10, "ab");
        assertEquals("abababtest", result, "Expected padding with repeated pad string");
    }

    @Test
    public void testLeftPad_SufficientLength() {
        String result = StringUtils.leftPad("test", 8, "xyz");
        assertEquals("xyzxyzt", result, "Expected padding with repeated characters from the pad string");
    }

    @Test
    public void testLeftPad_ZeroLength() {
        String result = StringUtils.leftPad("test", 0, "*");
        assertEquals("test", result, "Expected original string when size is zero");
    }

    @Test
    public void testLeftPad_NegativeLength() {
        String result = StringUtils.leftPad("test", -5, "*");
        assertEquals("test", result, "Expected original string when size is negative");
    }

    @Test
    public void testLeftPad_LargePad() {
        String result = StringUtils.leftPad("test", 10, "1234567890");
        assertEquals("123456test", result, "Expected padding with substring of large pad string");
    }
}
