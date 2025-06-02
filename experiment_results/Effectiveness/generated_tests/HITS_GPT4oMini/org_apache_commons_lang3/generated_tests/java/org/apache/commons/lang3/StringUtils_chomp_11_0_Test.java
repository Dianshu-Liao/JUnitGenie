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

public class StringUtils_chomp_11_0_Test {

    @Test
    public void testChomp_NullString() {
        String result = StringUtils.chomp(null);
        assertEquals(null, result);
    }

    @Test
    public void testChomp_EmptyString() {
        String result = StringUtils.chomp(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testChomp_SingleCharacter() {
        String result = StringUtils.chomp("a");
        assertEquals("a", result);
    }

    @Test
    public void testChomp_SingleCR() {
        String result = StringUtils.chomp(StringUtils.CR);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testChomp_SingleLF() {
        String result = StringUtils.chomp(StringUtils.LF);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testChomp_CRLF() {
        String result = StringUtils.chomp("Hello" + StringUtils.CR + StringUtils.LF);
        assertEquals("Hello", result);
    }

    @Test
    public void testChomp_LFNotFollowedByCR() {
        String result = StringUtils.chomp("Hello" + StringUtils.LF + "World");
        assertEquals("Hello" + StringUtils.LF + "World", result);
    }

    @Test
    public void testChomp_NoLineEnding() {
        String result = StringUtils.chomp("Hello World");
        assertEquals("Hello World", result);
    }

    @Test
    public void testChomp_TrailingSpaces() {
        String result = StringUtils.chomp("Hello World   ");
        assertEquals("Hello World   ", result);
    }

    @Test
    public void testChomp_MultipleCRLF() {
        String result = StringUtils.chomp("Line1" + StringUtils.CR + "Line2" + StringUtils.LF);
        assertEquals("Line1" + StringUtils.CR + "Line2", result);
    }

    @Test
    public void testChomp_MultipleLF() {
        String result = StringUtils.chomp("Hello" + StringUtils.LF + "World" + StringUtils.LF);
        assertEquals("Hello" + StringUtils.LF + "World", result);
    }
}
