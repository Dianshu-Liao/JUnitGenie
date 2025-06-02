package org.apache.commons.lang3;

import java.lang.reflect.Method;
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
        assertNull(StringUtils.rotate(null, 5));
    }

    @Test
    public void testRotate_ZeroShift() {
        String str = "hello";
        assertEquals(str, StringUtils.rotate(str, 0));
    }

    @Test
    public void testRotate_EmptyString() {
        String str = "";
        assertEquals(str, StringUtils.rotate(str, 3));
    }

    @Test
    public void testRotate_ShiftEqualsLength() {
        String str = "hello";
        assertEquals(str, StringUtils.rotate(str, 5));
    }

    @Test
    public void testRotate_PositiveShift() {
        assertEquals("lohel", StringUtils.rotate("hello", 2));
        assertEquals("ohell", StringUtils.rotate("hello", 4));
    }

    @Test
    public void testRotate_NegativeShift() {
        assertEquals("llohe", StringUtils.rotate("hello", -2));
        assertEquals("hello", StringUtils.rotate("hello", -5));
    }

    @Test
    public void testRotate_ShiftGreaterThanLength() {
        assertEquals("lohel", StringUtils.rotate("hello", 7));
        assertEquals("ohell", StringUtils.rotate("hello", 9));
    }

    @Test
    public void testRotate_ShiftLessThanNegativeLength() {
        assertEquals("llohe", StringUtils.rotate("hello", -7));
        assertEquals("hello", StringUtils.rotate("hello", -10));
    }

    @Test
    public void testRotate_SingleCharacter() {
        String str = "a";
        assertEquals(str, StringUtils.rotate(str, 1));
        assertEquals(str, StringUtils.rotate(str, -1));
    }
}
