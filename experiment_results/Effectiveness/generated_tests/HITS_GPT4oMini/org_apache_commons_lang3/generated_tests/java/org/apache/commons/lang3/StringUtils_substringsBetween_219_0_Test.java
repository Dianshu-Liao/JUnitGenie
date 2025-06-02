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

public class StringUtils_substringsBetween_219_0_Test {

    @Test
    public void testSubstringsBetween_NullInput() {
        String[] result = StringUtils.substringsBetween(null, "<", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_EmptyOpenString() {
        String[] result = StringUtils.substringsBetween("Hello <world>", "", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_EmptyCloseString() {
        String[] result = StringUtils.substringsBetween("Hello <world>", "<", "");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_EmptyInputString() {
        String[] result = StringUtils.substringsBetween("", "<", ">");
        assertArrayEquals(new String[0], result);
    }

    @Test
    public void testSubstringsBetween_NoMatches() {
        String[] result = StringUtils.substringsBetween("Hello world", "<", ">");
        assertNull(result);
    }

    @Test
    public void testSubstringsBetween_SingleMatch() {
        String[] result = StringUtils.substringsBetween("Hello <world>", "<", ">");
        assertArrayEquals(new String[] { "world" }, result);
    }

    @Test
    public void testSubstringsBetween_MultipleMatches() {
        String[] result = StringUtils.substringsBetween("Hello <world> and <everyone>", "<", ">");
        assertArrayEquals(new String[] { "world", "everyone" }, result);
    }

    @Test
    public void testSubstringsBetween_NestedTags() {
        String[] result = StringUtils.substringsBetween("Hello <outer<inner>>", "<outer<", ">>");
        assertArrayEquals(new String[] { "inner" }, result);
    }

    @Test
    public void testSubstringsBetween_OverlappingTags() {
        String[] result = StringUtils.substringsBetween("Hello <tag><tag>", "<tag>", "<tag>");
        assertArrayEquals(new String[] { "", "" }, result);
    }

    @Test
    public void testSubstringsBetween_AdjacentTags() {
        String[] result = StringUtils.substringsBetween("Hello <tag1><tag2>", "<tag1>", "<tag2>");
        assertArrayEquals(new String[] { "" }, result);
    }
}
