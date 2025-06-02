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
        assertEquals(3, StringUtils.lastIndexOf("Hello World", "o"));
        assertEquals(6, StringUtils.lastIndexOf("Hello World", "World"));
        assertEquals(0, StringUtils.lastIndexOf("Hello", "H"));
        assertEquals(-1, StringUtils.lastIndexOf("Hello", "x"));
        assertEquals(4, StringUtils.lastIndexOf("banana", "na"));
    }

    @Test
    public void testLastIndexOf_WithNullInputs() {
        // Test with null inputs
        assertEquals(-1, StringUtils.lastIndexOf(null, "search"));
        assertEquals(-1, StringUtils.lastIndexOf("sequence", null));
        assertEquals(-1, StringUtils.lastIndexOf(null, null));
    }

    @Test
    public void testLastIndexOf_WithEmptyStrings() {
        // Test with empty strings
        assertEquals(-1, StringUtils.lastIndexOf("", "search"));
        assertEquals(-1, StringUtils.lastIndexOf("sequence", ""));
        assertEquals(0, StringUtils.lastIndexOf("", ""));
    }

    @Test
    public void testLastIndexOf_WithLeadingAndTrailingSpaces() {
        // Test with strings that have leading and trailing spaces
        assertEquals(5, StringUtils.lastIndexOf("   Hello   ", " "));
        assertEquals(0, StringUtils.lastIndexOf("   ", " "));
        assertEquals(-1, StringUtils.lastIndexOf("   Hello   ", "X"));
    }

    @Test
    public void testLastIndexOf_WithSpecialCharacters() {
        // Test with special characters
        assertEquals(7, StringUtils.lastIndexOf("Hello@World@", "@"));
        assertEquals(5, StringUtils.lastIndexOf("Hello#World#", "#"));
        assertEquals(-1, StringUtils.lastIndexOf("Hello*World*", "$"));
    }
}
