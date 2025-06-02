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

class StringUtils_rightPad_174_0_Test {

    @Test
    void testRightPad_NullString() {
        String result = StringUtils.rightPad(null, 5);
        // Testing padding with spaces
        assertEquals("     ", result);
    }

    @Test
    void testRightPad_EmptyString() {
        String result = StringUtils.rightPad("", 5);
        // Testing padding with spaces
        assertEquals("     ", result);
    }

    @Test
    void testRightPad_SmallerSize() {
        String result = StringUtils.rightPad("test", 3);
        // No padding needed
        assertEquals("test", result);
    }

    @Test
    void testRightPad_ExactSize() {
        String result = StringUtils.rightPad("test", 4);
        // No padding needed
        assertEquals("test", result);
    }

    @Test
    void testRightPad_LargerSize() {
        String result = StringUtils.rightPad("test", 10);
        // Testing padding with spaces
        assertEquals("test      ", result);
    }

    @Test
    void testRightPad_NegativeSize() {
        String result = StringUtils.rightPad("test", -1);
        // Should return original string
        assertEquals("test", result);
    }

    @Test
    void testRightPad_ZeroSize() {
        String result = StringUtils.rightPad("test", 0);
        // Should return original string
        assertEquals("test", result);
    }
}
