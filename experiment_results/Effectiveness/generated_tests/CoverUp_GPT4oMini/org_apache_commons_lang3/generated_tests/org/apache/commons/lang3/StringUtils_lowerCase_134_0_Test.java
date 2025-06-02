package org.apache.commons.lang3;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Locale;
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
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_lowerCase_134_0_Test {

    @Test
    public void testLowerCase_WithNullString() {
        // Test case where input string is null
        String result = StringUtils.lowerCase(null, Locale.ENGLISH);
        assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testLowerCase_WithEmptyString() {
        // Test case where input string is empty
        String result = StringUtils.lowerCase("", Locale.ENGLISH);
        assertEquals("", result, "Expected empty string when input is empty");
    }

    @Test
    public void testLowerCase_WithNormalString() {
        // Test case with a normal string
        String result = StringUtils.lowerCase("Hello World", Locale.ENGLISH);
        assertEquals("hello world", result, "Expected lower case string");
    }

    @Test
    public void testLowerCase_WithLocale() {
        // Test case with a specific locale
        String result = StringUtils.lowerCase("Äpfel", Locale.GERMAN);
        assertEquals("äpfel", result, "Expected lower case string for German locale");
    }

    @Test
    public void testLowerCase_WithDifferentLocale() {
        // Test case with a different locale
        String result = StringUtils.lowerCase("HELLO", Locale.FRENCH);
        assertEquals("hello", result, "Expected lower case string for French locale");
    }

    @Test
    public void testLowerCase_WithLocaleDefault() {
        // Test case with Locale.DEFAULT
        Locale defaultLocale = Locale.getDefault();
        String result = StringUtils.lowerCase("Mixed CASE", defaultLocale);
        assertEquals("mixed case", result, "Expected lower case string for default locale");
    }
}
