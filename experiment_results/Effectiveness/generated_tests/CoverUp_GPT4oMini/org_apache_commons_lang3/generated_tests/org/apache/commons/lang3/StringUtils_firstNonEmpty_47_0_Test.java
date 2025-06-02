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

public class StringUtils_firstNonEmpty_47_0_Test {

    @Test
    public void testFirstNonEmpty_WithMultipleNonEmptyValues() {
        String result = StringUtils.firstNonEmpty("Hello", "World", "!");
        assertEquals("Hello", result);
    }

    @Test
    public void testFirstNonEmpty_WithLeadingEmptyValues() {
        String result = StringUtils.firstNonEmpty("", "", "Hello", "World");
        assertEquals("Hello", result);
    }

    @Test
    public void testFirstNonEmpty_WithAllEmptyValues() {
        String result = StringUtils.firstNonEmpty("", "", "");
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_WithNullArray() {
        String result = StringUtils.firstNonEmpty((String[]) null);
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_WithSingleEmptyValue() {
        String result = StringUtils.firstNonEmpty("");
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_WithSingleNonEmptyValue() {
        String result = StringUtils.firstNonEmpty("NonEmpty");
        assertEquals("NonEmpty", result);
    }

    @Test
    public void testFirstNonEmpty_WithMixedValues() {
        String result = StringUtils.firstNonEmpty("", " ", "NonEmpty", null);
        assertEquals("NonEmpty", result);
    }

    @Test
    public void testFirstNonEmpty_WithOnlyNulls() {
        String result = StringUtils.firstNonEmpty((String) null, null);
        assertNull(result);
    }
}
