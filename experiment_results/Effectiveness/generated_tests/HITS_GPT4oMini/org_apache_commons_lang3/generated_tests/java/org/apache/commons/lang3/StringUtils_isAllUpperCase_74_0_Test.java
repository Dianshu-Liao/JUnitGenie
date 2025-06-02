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

public class StringUtils_isAllUpperCase_74_0_Test {

    @Test
    public void testIsAllUpperCase_WithEmptyString() {
        assertFalse(StringUtils.isAllUpperCase(""));
    }

    @Test
    public void testIsAllUpperCase_WithNull() {
        assertFalse(StringUtils.isAllUpperCase(null));
    }

    @Test
    public void testIsAllUpperCase_WithLowerCase() {
        assertFalse(StringUtils.isAllUpperCase("hello"));
    }

    @Test
    public void testIsAllUpperCase_WithMixedCase() {
        assertFalse(StringUtils.isAllUpperCase("HelloWorld"));
    }

    @Test
    public void testIsAllUpperCase_WithAllUpperCase() {
        assertTrue(StringUtils.isAllUpperCase("HELLO"));
    }

    @Test
    public void testIsAllUpperCase_WithSpaces() {
        assertFalse(StringUtils.isAllUpperCase("HELLO WORLD"));
        assertTrue(StringUtils.isAllUpperCase("HELLOWORLD"));
    }

    @Test
    public void testIsAllUpperCase_WithSpecialCharacters() {
        assertFalse(StringUtils.isAllUpperCase("HELLO!"));
        assertFalse(StringUtils.isAllUpperCase("12345"));
        assertFalse(StringUtils.isAllUpperCase("HELLO123"));
    }

    @Test
    public void testIsAllUpperCase_WithUnicodeCharacters() {
        assertTrue(StringUtils.isAllUpperCase("ÄÖÜ"));
        assertFalse(StringUtils.isAllUpperCase("ÄöÜ"));
    }
}
