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

public class StringUtils_substringsBetween_219_0_Test {

    @Test
    public void testSubstringsBetween_NullString() {
        String[] result = StringUtils.substringsBetween(null, "<", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_EmptyOpen() {
        String[] result = StringUtils.substringsBetween("test", "", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_EmptyClose() {
        String[] result = StringUtils.substringsBetween("test", "<", "");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_EmptyString() {
        String[] result = StringUtils.substringsBetween("", "<", ">");
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test
    public void testSubstringsBetween_NoMatches() {
        String[] result = StringUtils.substringsBetween("test", "<", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_SingleMatch() {
        String[] result = StringUtils.substringsBetween("This is a <test> string", "<", ">");
        assertArrayEquals(new String[] { "test" }, result);
    }

    @Test
    public void testSubstringsBetween_MultipleMatches() {
        String[] result = StringUtils.substringsBetween("This <is> a <test> string", "<", ">");
        assertArrayEquals(new String[] { "is", "test" }, result);
    }

    @Test
    public void testSubstringsBetween_Overlapping() {
        String[] result = StringUtils.substringsBetween("This <is <a> test>", "<", ">");
        assertArrayEquals(new String[] { "is <a" }, result);
    }

    @Test
    public void testSubstringsBetween_OpenNotFound() {
        String[] result = StringUtils.substringsBetween("This is a test string", "<", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_CloseNotFound() {
        String[] result = StringUtils.substringsBetween("This <is a test string", "<", ">");
        assertNull(result);
    }
}
