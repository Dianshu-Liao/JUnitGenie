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

public class StringUtils_wrap_238_0_Test {

    @Test
    public void testWrap_WithNonEmptyStringAndWrapWith() {
        String result = StringUtils.wrap("test", "*");
        assertEquals("*test*", result);
    }

    @Test
    public void testWrap_WithEmptyString() {
        String result = StringUtils.wrap("", "*");
        assertEquals("", result);
    }

    @Test
    public void testWrap_WithEmptyWrapWith() {
        String result = StringUtils.wrap("test", "");
        assertEquals("test", result);
    }

    @Test
    public void testWrap_WithBothEmptyStrings() {
        String result = StringUtils.wrap("", "");
        assertEquals("", result);
    }

    @Test
    public void testWrap_WithNullString() {
        String result = StringUtils.wrap(null, "*");
        assertEquals(null, result);
    }

    @Test
    public void testWrap_WithNullWrapWith() {
        String result = StringUtils.wrap("test", null);
        assertEquals("test", result);
    }

    @Test
    public void testWrap_WithBothNullStrings() {
        String result = StringUtils.wrap(null, null);
        assertEquals(null, result);
    }
}
