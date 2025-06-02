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

public class StringUtils_rotate_177_0_Test {

    @Test
    public void testRotate_NullString() {
        String result = StringUtils.rotate(null, 2);
        assertNull(result, "Rotating a null string should return null.");
    }

    @Test
    public void testRotate_EmptyString() {
        String result = StringUtils.rotate("", 3);
        assertEquals("", result, "Rotating an empty string should return an empty string.");
    }

    @Test
    public void testRotate_ZeroShift() {
        String result = StringUtils.rotate("abc", 0);
        assertEquals("abc", result, "Rotating with a shift of 0 should return the original string.");
    }

    @Test
    public void testRotate_ShiftEqualToLength() {
        String result = StringUtils.rotate("abc", 3);
        assertEquals("abc", result, "Rotating with a shift equal to the string length should return the original string.");
    }

    @Test
    public void testRotate_PositiveShift() {
        String result = StringUtils.rotate("abc", 1);
        assertEquals("cab", result, "Rotating 'abc' with a shift of 1 should return 'cab'.");
    }

    @Test
    public void testRotate_NegativeShift() {
        String result = StringUtils.rotate("abc", -1);
        assertEquals("bca", result, "Rotating 'abc' with a shift of -1 should return 'bca'.");
    }

    @Test
    public void testRotate_ShiftGreaterThanLength() {
        String result = StringUtils.rotate("abc", 4);
        assertEquals("cab", result, "Rotating 'abc' with a shift of 4 should return 'cab'.");
    }

    @Test
    public void testRotate_ShiftLessThanNegativeLength() {
        String result = StringUtils.rotate("abc", -4);
        assertEquals("bca", result, "Rotating 'abc' with a shift of -4 should return 'bca'.");
    }

    @Test
    public void testRotate_LongString() {
        String result = StringUtils.rotate("abcdefg", 2);
        assertEquals("fgabcde", result, "Rotating 'abcdefg' with a shift of 2 should return 'fgabcde'.");
    }

    @Test
    public void testRotate_NegativeShiftWithLongString() {
        String result = StringUtils.rotate("abcdefg", -2);
        assertEquals("cdefgab", result, "Rotating 'abcdefg' with a shift of -2 should return 'cdefgab'.");
    }

    @Test
    public void testRotate_ExactMultipleShift() {
        String result = StringUtils.rotate("abcd", 8);
        assertEquals("abcd", result, "Rotating 'abcd' with a shift of 8 (multiple of length) should return 'abcd'.");
    }

    @Test
    public void testRotate_NegativeShiftExactMultiple() {
        String result = StringUtils.rotate("abcd", -8);
        assertEquals("abcd", result, "Rotating 'abcd' with a shift of -8 (multiple of length) should return 'abcd'.");
    }
}
