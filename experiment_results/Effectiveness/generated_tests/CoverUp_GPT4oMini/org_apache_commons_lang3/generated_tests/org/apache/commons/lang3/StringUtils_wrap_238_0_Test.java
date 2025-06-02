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
    public void testWrap_NonEmptyStrings() {
        String str = "test";
        String wrapWith = "*";
        String expected = "*test*";
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test
    public void testWrap_EmptyString() {
        String str = "";
        String wrapWith = "*";
        // should return the original string
        String expected = "";
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test
    public void testWrap_NullString() {
        String str = null;
        String wrapWith = "*";
        // should return the original string
        String expected = null;
        String actual = StringUtils.wrap(str, wrapWith);
        assertNull(actual);
    }

    @Test
    public void testWrap_EmptyWrapWith() {
        String str = "test";
        String wrapWith = "";
        // should return the original string
        String expected = "test";
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test
    public void testWrap_NullWrapWith() {
        String str = "test";
        String wrapWith = null;
        // should return the original string
        String expected = "test";
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test
    public void testWrap_BothEmpty() {
        String str = "";
        String wrapWith = "";
        // should return the original string
        String expected = "";
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test
    public void testWrap_BothNull() {
        String str = null;
        String wrapWith = null;
        // should return the original string
        String expected = null;
        String actual = StringUtils.wrap(str, wrapWith);
        assertNull(actual);
    }
}
