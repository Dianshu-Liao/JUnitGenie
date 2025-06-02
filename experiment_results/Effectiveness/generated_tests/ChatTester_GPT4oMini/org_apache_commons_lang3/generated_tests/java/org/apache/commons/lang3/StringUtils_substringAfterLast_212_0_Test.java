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

public class StringUtils_substringAfterLast_212_0_Test {

    @Test
    public void testSubstringAfterLast_withEmptyString() {
        String result = StringUtils.substringAfterLast("", 'a');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withNoSeparator() {
        String result = StringUtils.substringAfterLast("hello", 'x');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withSeparatorAtEnd() {
        String result = StringUtils.substringAfterLast("hello,", ',');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withValidSeparator() {
        String result = StringUtils.substringAfterLast("hello,world,java", ',');
        assertEquals("java", result);
    }

    @Test
    public void testSubstringAfterLast_withMultipleSeparators() {
        String result = StringUtils.substringAfterLast("a,b,c,d,e", ',');
        assertEquals("e", result);
    }

    @Test
    public void testSubstringAfterLast_withSeparatorNotFound() {
        String result = StringUtils.substringAfterLast("teststring", 'x');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withNullString() {
        String result = StringUtils.substringAfterLast(null, 'a');
        assertNull(result);
    }
}
