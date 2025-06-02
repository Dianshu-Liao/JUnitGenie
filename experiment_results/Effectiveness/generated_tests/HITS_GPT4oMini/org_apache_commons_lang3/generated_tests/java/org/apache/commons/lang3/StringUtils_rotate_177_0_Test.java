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
        assertNull(StringUtils.rotate(null, 2));
    }

    @Test
    public void testRotate_EmptyString() {
        assertEquals("", StringUtils.rotate("", 2));
    }

    @Test
    public void testRotate_ZeroShift() {
        assertEquals("abc", StringUtils.rotate("abc", 0));
    }

    @Test
    public void testRotate_EqualShiftLength() {
        assertEquals("abc", StringUtils.rotate("abc", 3));
    }

    @Test
    public void testRotate_ShiftGreaterThanLength() {
        assertEquals("cba", StringUtils.rotate("abc", 5));
    }

    @Test
    public void testRotate_NegativeShift() {
        assertEquals("bca", StringUtils.rotate("abc", -1));
    }

    @Test
    public void testRotate_NegativeShiftGreaterThanLength() {
        assertEquals("cab", StringUtils.rotate("abc", -4));
    }

    @Test
    public void testRotate_ShiftWithinBounds() {
        assertEquals("cba", StringUtils.rotate("abc", 2));
        assertEquals("abc", StringUtils.rotate("abc", 3));
        assertEquals("cab", StringUtils.rotate("abc", 1));
    }

    @Test
    public void testRotate_LargeShift() {
        assertEquals("defabc", StringUtils.rotate("abcdef", 3));
        assertEquals("abcdef", StringUtils.rotate("abcdef", 6));
        assertEquals("abcdef", StringUtils.rotate("abcdef", 12));
    }

    @Test
    public void testRotate_SingleCharacter() {
        assertEquals("a", StringUtils.rotate("a", 1));
        assertEquals("a", StringUtils.rotate("a", 10));
    }
}
