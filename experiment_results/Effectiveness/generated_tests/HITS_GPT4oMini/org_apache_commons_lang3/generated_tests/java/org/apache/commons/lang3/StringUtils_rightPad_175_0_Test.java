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

public class StringUtils_rightPad_175_0_Test {

    @Test
    public void testRightPad_NullString() {
        assertNull(StringUtils.rightPad(null, 10, ' '));
    }

    @Test
    public void testRightPad_EmptyString() {
        assertEquals("          ", StringUtils.rightPad("", 10, ' '));
    }

    @Test
    public void testRightPad_StringShorterThanSize() {
        assertEquals("Hello     ", StringUtils.rightPad("Hello", 10, ' '));
    }

    @Test
    public void testRightPad_StringEqualToSize() {
        assertEquals("Hello", StringUtils.rightPad("Hello", 5, ' '));
    }

    @Test
    public void testRightPad_StringLongerThanSize() {
        assertEquals("HelloWorld", StringUtils.rightPad("HelloWorld", 5, ' '));
    }

    @Test
    public void testRightPad_SingleCharacterPadding() {
        assertEquals("Hello*****", StringUtils.rightPad("Hello", 10, '*'));
    }

    @Test
    public void testRightPad_MultipleCharacterPadding() {
        assertEquals("Hello-World", StringUtils.rightPad("Hello", 10, "-"));
    }

    @Test
    public void testRightPad_PaddingExceedsLimit() {
        assertEquals("Hello" + "12345678901234567890", StringUtils.rightPad("Hello", 30, '1'));
    }

    @Test
    public void testRightPad_SpacePadding() {
        assertEquals("Hello     ", StringUtils.rightPad("Hello", 10, ' '));
    }

    @Test
    public void testRightPad_EmptyPaddingString() {
        assertEquals("Hello     ", StringUtils.rightPad("Hello", 10, ""));
    }

    @Test
    public void testRightPad_NegativeSize() {
        assertEquals("Hello", StringUtils.rightPad("Hello", -1, ' '));
    }

    @Test
    public void testRightPad_ZeroSize() {
        assertEquals("Hello", StringUtils.rightPad("Hello", 0, ' '));
    }
}
