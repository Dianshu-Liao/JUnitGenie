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

public class StringUtils_chomp_11_0_Test {

    @Test
    public void testChomp_EmptyString() {
        String result = StringUtils.chomp(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testChomp_SingleCharacter() {
        String result = StringUtils.chomp("a");
        assertEquals("a", result);
        result = StringUtils.chomp(StringUtils.CR);
        assertEquals(StringUtils.EMPTY, result);
        result = StringUtils.chomp(StringUtils.LF);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testChomp_TrailingNewline() {
        String result = StringUtils.chomp("Hello\n");
        assertEquals("Hello", result);
        result = StringUtils.chomp("Hello\r\n");
        assertEquals("Hello", result);
    }

    @Test
    public void testChomp_NoTrailingNewline() {
        String result = StringUtils.chomp("Hello");
        assertEquals("Hello", result);
    }

    @Test
    public void testChomp_MultipleNewlines() {
        String result = StringUtils.chomp("Hello\n\n");
        assertEquals("Hello\n", result);
        result = StringUtils.chomp("Hello\r\n\r\n");
        assertEquals("Hello\r\n", result);
    }

    @Test
    public void testChomp_MixedNewline() {
        String result = StringUtils.chomp("Hello\r\nWorld\n");
        assertEquals("Hello\r\nWorld", result);
    }

    @Test
    public void testChomp_OnlyNewline() {
        String result = StringUtils.chomp("\n");
        assertEquals(StringUtils.EMPTY, result);
        result = StringUtils.chomp("\r");
        assertEquals(StringUtils.EMPTY, result);
    }

    // Reflection test for private methods if needed
    @Test
    public void testChomp_Reflection() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("isEmpty", String.class);
        method.setAccessible(true);
        boolean isEmptyResult = (boolean) method.invoke(null, "test");
        assertFalse(isEmptyResult);
    }
}
