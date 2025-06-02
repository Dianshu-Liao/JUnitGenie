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

public class StringUtils_substringAfter_210_0_Test {

    @Test
    public void testSubstringAfter_EmptyString() {
        String result = StringUtils.substringAfter("", 'a');
        assertEquals("", result, "Expected empty string when input is empty.");
    }

    @Test
    public void testSubstringAfter_NoSeparatorFound() {
        String result = StringUtils.substringAfter("hello", 'x');
        assertEquals(StringUtils.EMPTY, result, "Expected empty string when separator not found.");
    }

    @Test
    public void testSubstringAfter_SeparatorAtStart() {
        String result = StringUtils.substringAfter("ahello", 'a');
        assertEquals("hello", result, "Expected substring after separator at start.");
    }

    @Test
    public void testSubstringAfter_SeparatorAtEnd() {
        String result = StringUtils.substringAfter("hello,", ',');
        assertEquals("", result, "Expected empty string when separator is at the end.");
    }

    @Test
    public void testSubstringAfter_SeparatorInMiddle() {
        String result = StringUtils.substringAfter("hello,world", ',');
        assertEquals("world", result, "Expected substring after separator in the middle.");
    }

    @Test
    public void testSubstringAfter_SeparatorRepeated() {
        String result = StringUtils.substringAfter("hello,world,again", ',');
        assertEquals("world,again", result, "Expected substring after first separator repeated.");
    }

    @Test
    public void testSubstringAfter_NullInput() {
        String result = StringUtils.substringAfter(null, 'a');
        assertTrue(result == null, "Expected null when input is null.");
    }
}
