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
        // Assuming padding with spaces for null input
        assertEquals("          ", result);
    }

    @Test
    public void testCenter_EmptyString() {
        String result = StringUtils.center("", 10);
        // 10 spaces for empty string
        assertEquals("          ", result);
    }

    @Test
    public void testCenter_SingleCharacter() {
        String result = StringUtils.center("A", 5);
        // Centering 'A' in a width of 5
        assertEquals("  A  ", result);
    }

    @Test
    public void testCenter_MultipleCharacters() {
        String result = StringUtils.center("Hello", 11);
        // Centering 'Hello' in a width of 11
        assertEquals("    Hello    ", result);
    }

    @Test
    public void testCenter_ExactFit() {
        String result = StringUtils.center("Hello", 5);
        // No padding needed
        assertEquals("Hello", result);
    }

    @Test
    public void testCenter_WidthLessThanString() {
        String result = StringUtils.center("Hello", 3);
        // Return original string if width is less
        assertEquals("Hello", result);
    }

    @Test
    public void testCenter_NegativeWidth() {
        String result = StringUtils.center("Hello", -5);
        // Return original string if width is negative
        assertEquals("Hello", result);
    }

    @Test
    public void testCenter_WidthZero() {
        String result = StringUtils.center("Hello", 0);
        // Return original string if width is zero
        assertEquals("Hello", result);
    }

    @Test
    public void testCenter_LargeWidth() {
        String result = StringUtils.center("Test", 20);
        // Centering 'Test' in a width of 20
        assertEquals("        Test        ", result);
    }
}
