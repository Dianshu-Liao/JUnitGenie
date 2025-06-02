package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
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

public class StringUtils_chomp_11_0_Test {

    @Test
    public void testChomp_EmptyString() {
        assertEquals(StringUtils.EMPTY, StringUtils.chomp(StringUtils.EMPTY));
    }

    @Test
    public void testChomp_SingleCharacter() {
        assertEquals("a", StringUtils.chomp("a"));
        assertEquals(StringUtils.EMPTY, StringUtils.chomp(StringUtils.CR));
        assertEquals(StringUtils.EMPTY, StringUtils.chomp(StringUtils.LF));
    }

    @Test
    public void testChomp_TrailingNewline() {
        assertEquals("hello", StringUtils.chomp("hello\n"));
        assertEquals("hello", StringUtils.chomp("hello\r\n"));
        assertEquals("hello", StringUtils.chomp("hello\r"));
    }

    @Test
    public void testChomp_NoTrailingNewline() {
        assertEquals("hello", StringUtils.chomp("hello"));
        assertEquals("hello", StringUtils.chomp("hello world"));
    }

    @Test
    public void testChomp_MultipleNewlines() {
        assertEquals("hello", StringUtils.chomp("hello\n\n"));
        assertEquals("hello", StringUtils.chomp("hello\r\n\r\n"));
        assertEquals("hello", StringUtils.chomp("hello\r\r"));
    }

    @Test
    public void testChomp_OnlyNewlines() {
        assertEquals(StringUtils.EMPTY, StringUtils.chomp("\n"));
        assertEquals(StringUtils.EMPTY, StringUtils.chomp("\r"));
        assertEquals(StringUtils.EMPTY, StringUtils.chomp("\r\n"));
    }

    @Test
    public void testChomp_NullInput() {
        assertEquals(null, StringUtils.chomp(null));
    }
}
