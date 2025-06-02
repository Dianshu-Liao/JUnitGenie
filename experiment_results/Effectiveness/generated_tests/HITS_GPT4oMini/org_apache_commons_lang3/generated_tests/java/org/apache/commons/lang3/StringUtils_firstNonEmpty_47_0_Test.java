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
    public void testFirstNonEmpty_withMultipleEmptyStrings() {
        String result = StringUtils.firstNonEmpty("", "", "");
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_withSingleNonEmptyString() {
        String result = StringUtils.firstNonEmpty("", "Hello", "");
        assertEquals("Hello", result);
    }

    @Test
    public void testFirstNonEmpty_withMultipleNonEmptyStrings() {
        String result = StringUtils.firstNonEmpty("Hello", "World", "!");
        assertEquals("Hello", result);
    }

    @Test
    public void testFirstNonEmpty_withLeadingEmptyStrings() {
        String result = StringUtils.firstNonEmpty("", "", "Test");
        assertEquals("Test", result);
    }

    @Test
    public void testFirstNonEmpty_withNullArray() {
        String result = StringUtils.firstNonEmpty(null);
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_withAllNulls() {
        String result = StringUtils.firstNonEmpty((String[]) null);
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_withMixedNullAndEmptyStrings() {
        String result = StringUtils.firstNonEmpty(new String[] { null, "", "NotEmpty" });
        assertEquals("NotEmpty", result);
    }

    @Test
    public void testFirstNonEmpty_withSingleEmptyString() {
        String result = StringUtils.firstNonEmpty("");
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_withSingleNonEmptyStringUnique() {
        String result = StringUtils.firstNonEmpty("NonEmpty");
        assertEquals("NonEmpty", result);
    }

    @Test
    public void testFirstNonEmpty_withNonEmptyAndEmptyStrings() {
        String result = StringUtils.firstNonEmpty("", "NonEmpty");
        assertEquals("NonEmpty", result);
    }
}
