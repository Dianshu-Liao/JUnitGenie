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

public class StringUtils_stripAll_202_1_Test {

    @Test
    public void testStripAll_WithNullArray() {
        String[] result = StringUtils.stripAll(null);
        assertArrayEquals(new String[] {}, result, "Expected empty array when input is null");
    }

    @Test
    public void testStripAll_WithEmptyArray() {
        String[] result = StringUtils.stripAll(new String[] {});
        assertArrayEquals(new String[] {}, result, "Expected empty array when input is empty");
    }

    @Test
    public void testStripAll_WithSingleEmptyString() {
        String[] result = StringUtils.stripAll(new String[] { "" });
        assertArrayEquals(new String[] { "" }, result, "Expected array containing empty string");
    }

    @Test
    public void testStripAll_WithSingleNonEmptyString() {
        String[] result = StringUtils.stripAll(new String[] { "test" });
        assertArrayEquals(new String[] { "test" }, result, "Expected array containing the same non-empty string");
    }

    @Test
    public void testStripAll_WithMultipleStrings() {
        String[] result = StringUtils.stripAll(new String[] { "test", "", "example" });
        assertArrayEquals(new String[] { "test", "", "example" }, result, "Expected array containing the same strings");
    }

    @Test
    public void testStripAll_WithNullStringsInArray() {
        String[] result = StringUtils.stripAll(new String[] { "test", null, "example" });
        assertArrayEquals(new String[] { "test", null, "example" }, result, "Expected array containing null in place of the null string");
    }

    @Test
    public void testStripAll_WithWhitespaceStrings() {
        String[] result = StringUtils.stripAll(new String[] { "   ", "\t", "\n" });
        assertArrayEquals(new String[] { "   ", "\t", "\n" }, result, "Expected array containing whitespace strings");
    }
}
