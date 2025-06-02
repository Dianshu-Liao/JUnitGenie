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

public class StringUtils_lastIndexOf_120_0_Test {

    @Test
    public void testLastIndexOf_WithValidInputs() {
        // Test with normal strings
        assertEquals(5, StringUtils.lastIndexOf("hello world", "o"));
        assertEquals(6, StringUtils.lastIndexOf("hello world", "world"));
        assertEquals(0, StringUtils.lastIndexOf("hello", "h"));
    }

    @Test
    public void testLastIndexOf_WithEmptySearchSeq() {
        // Test with empty search sequence
        assertEquals(11, StringUtils.lastIndexOf("hello world", ""));
        assertEquals(0, StringUtils.lastIndexOf("hello", ""));
    }

    @Test
    public void testLastIndexOf_WithNotFound() {
        // Test with search sequence not found
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("hello world", "x"));
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("", "hello"));
    }

    @Test
    public void testLastIndexOf_WithNullInputs() {
        // Test with null inputs
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf(null, "hello"));
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("hello", null));
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf(null, null));
    }

    @Test
    public void testLastIndexOf_WithSpecialCharacters() {
        // Test with special characters
        assertEquals(2, StringUtils.lastIndexOf("abc@def#ghi", "#"));
        assertEquals(0, StringUtils.lastIndexOf("!@#$%^", "!"));
    }
}
