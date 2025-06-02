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

public class StringUtils_join_114_0_Test {

    @Test
    public void testJoin_NullArray_ReturnsNull() {
        String result = StringUtils.join((Object[]) null, ",");
        assertNull(result, "Expected null when array is null");
    }

    @Test
    public void testJoin_EmptyArray_ReturnsEmptyString() {
        String[] array = {};
        String result = StringUtils.join(array, ",");
        assertEquals("", result, "Expected empty string when array is empty");
    }

    @Test
    public void testJoin_SingleElementArray_ReturnsElement() {
        String[] array = { "test" };
        String result = StringUtils.join(array, ",");
        assertEquals("test", result, "Expected single element to be returned without delimiter");
    }

    @Test
    public void testJoin_MultipleElementsArray_ReturnsJoinedString() {
        String[] array = { "one", "two", "three" };
        String result = StringUtils.join(array, ",");
        assertEquals("one,two,three", result, "Expected elements to be joined by delimiter");
    }

    @Test
    public void testJoin_NullDelimiter_ReturnsJoinedString() {
        String[] array = { "one", "two", "three" };
        String result = StringUtils.join(array, null);
        assertEquals("onetwothree", result, "Expected elements to be joined without delimiter when delimiter is null");
    }

    @Test
    public void testJoin_WhitespaceDelimiter_ReturnsJoinedString() {
        String[] array = { "one", "two", "three" };
        String result = StringUtils.join(array, " ");
        assertEquals("one two three", result, "Expected elements to be joined by whitespace");
    }

    @Test
    public void testJoin_SingleNullElement_ReturnsStringWithDelimiter() {
        String[] array = { "one", null, "three" };
        String result = StringUtils.join(array, ",");
        assertEquals("one,null,three", result, "Expected null element to be represented as 'null' in the joined string");
    }

    @Test
    public void testJoin_NullAndEmptyElements_ReturnsStringWithDelimiter() {
        String[] array = { null, "", "three" };
        String result = StringUtils.join(array, ",");
        assertEquals("null,,three", result, "Expected null and empty elements to be represented correctly in the joined string");
    }
}
