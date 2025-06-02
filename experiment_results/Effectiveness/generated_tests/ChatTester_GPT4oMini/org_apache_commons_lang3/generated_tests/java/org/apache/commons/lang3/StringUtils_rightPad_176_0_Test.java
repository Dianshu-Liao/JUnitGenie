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
        String result = StringUtils.rightPad(null, 10, "*");
        assertNull(result);
    }

    @Test
    public void testRightPad_EmptyPadString() {
        String result = StringUtils.rightPad("test", 10, "");
        assertEquals("test     ", result);
    }

    @Test
    public void testRightPad_OriginalStringReturned() {
        String result = StringUtils.rightPad("test", 2, "*");
        assertEquals("test", result);
    }

    @Test
    public void testRightPad_SingleCharPadding() {
        String result = StringUtils.rightPad("test", 10, "*");
        assertEquals("test******", result);
    }

    @Test
    public void testRightPad_PaddingShorterThanRequired() {
        String result = StringUtils.rightPad("test", 10, "ab");
        assertEquals("testababab", result);
    }

    @Test
    public void testRightPad_PaddingExactlyRequired() {
        String result = StringUtils.rightPad("test", 8, "ab");
        assertEquals("testab", result);
    }

    @Test
    public void testRightPad_PaddingLongerThanRequired() {
        String result = StringUtils.rightPad("test", 10, "abc");
        assertEquals("testabca", result);
    }

    @Test
    public void testRightPad_LargePadLimit() {
        String result = StringUtils.rightPad("test", 20, "abcde");
        assertEquals("testabcdeabcdeabcde", result);
    }

    @Test
    public void testRightPad_ExactPaddingWithOneChar() {
        String result = StringUtils.rightPad("test", 6, " ");
        assertEquals("test  ", result);
    }
}
