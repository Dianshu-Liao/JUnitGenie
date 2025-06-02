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
    public void testFirstNonEmpty_WithMultipleValues_ReturnsFirstNonEmpty() {
        String result = StringUtils.firstNonEmpty("", "first", "second");
        assertEquals("first", result);
    }

    @Test
    public void testFirstNonEmpty_WithAllEmptyValues_ReturnsNull() {
        String result = StringUtils.firstNonEmpty("", "", "");
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_WithNullArray_ReturnsNull() {
        String result = StringUtils.firstNonEmpty((String[]) null);
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_WithEmptyArray_ReturnsNull() {
        String result = StringUtils.firstNonEmpty(new String[0]);
        assertNull(result);
    }

    @Test
    public void testFirstNonEmpty_WithLeadingEmptyValues_ReturnsFirstNonEmpty() {
        String result = StringUtils.firstNonEmpty("", "", "third");
        assertEquals("third", result);
    }

    @Test
    public void testFirstNonEmpty_WithSingleNonEmptyValue_ReturnsThatValue() {
        String result = StringUtils.firstNonEmpty("only");
        assertEquals("only", result);
    }

    @Test
    public void testFirstNonEmpty_WithDifferentCharSequenceTypes_ReturnsFirstNonEmpty() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("non-empty");
        // Fixed line: Cast StringBuilder to CharSequence
        CharSequence result = StringUtils.firstNonEmpty(sb1, sb2);
        assertEquals("non-empty", result);
    }

    @Test
    public void testFirstNonEmpty_WithMixedCharSequenceTypes_ReturnsFirstNonEmpty() {
        CharSequence[] values = { new StringBuilder(""), new StringBuffer(""), "firstNonEmpty" };
        CharSequence result = StringUtils.firstNonEmpty(values);
        assertEquals("firstNonEmpty", result);
    }

    @Test
    public void testFirstNonEmpty_WithNullCharSequenceInArray_ReturnsFirstNonEmpty() {
        CharSequence[] values = { null, "", "notNull" };
        CharSequence result = StringUtils.firstNonEmpty(values);
        assertEquals("notNull", result);
    }
}
