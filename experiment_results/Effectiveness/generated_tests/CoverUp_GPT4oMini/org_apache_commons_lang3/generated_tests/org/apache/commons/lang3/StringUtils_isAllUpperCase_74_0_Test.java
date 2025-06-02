package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class StringUtils_isAllUpperCase_74_0_Test {

    @Test
    public void testIsAllUpperCase_WithAllUpperCase() {
        assertTrue(StringUtils.isAllUpperCase("HELLO"));
    }

    @Test
    public void testIsAllUpperCase_WithMixedCase() {
        assertFalse(StringUtils.isAllUpperCase("Hello"));
    }

    @Test
    public void testIsAllUpperCase_WithLowerCase() {
        assertFalse(StringUtils.isAllUpperCase("hello"));
    }

    @Test
    public void testIsAllUpperCase_WithNumbers() {
        assertFalse(StringUtils.isAllUpperCase("1234"));
    }

    @Test
    public void testIsAllUpperCase_WithSpecialCharacters() {
        assertFalse(StringUtils.isAllUpperCase("!@#$"));
    }

    @Test
    public void testIsAllUpperCase_WithEmptyString() {
        assertFalse(StringUtils.isAllUpperCase(""));
    }

    @Test
    public void testIsAllUpperCase_WithNull() {
        assertFalse(StringUtils.isAllUpperCase(null));
    }

    @Test
    public void testIsAllUpperCase_WithSpaces() {
        assertFalse(StringUtils.isAllUpperCase("   "));
    }

    @Test
    public void testIsAllUpperCase_WithUpperCaseAndSpaces() {
        assertFalse(StringUtils.isAllUpperCase("HEL LO"));
    }

    @Test
    public void testIsAllUpperCase_WithUnicodeUpperCase() {
        assertTrue(StringUtils.isAllUpperCase("ÄÖÜ"));
    }

    @Test
    public void testIsAllUpperCase_PrivateMethodInvocation() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("isAllUpperCase", CharSequence.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(null, "UPPERCASE"));
        assertFalse((Boolean) method.invoke(null, "lowercase"));
    }
}
