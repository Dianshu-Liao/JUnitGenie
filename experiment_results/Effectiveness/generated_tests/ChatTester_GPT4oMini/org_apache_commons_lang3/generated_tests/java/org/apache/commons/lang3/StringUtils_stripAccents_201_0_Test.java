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

public class StringUtils_stripAccents_201_0_Test {

    @Test
    public void testStripAccents_WithAccentedCharacters() throws Exception {
        String input = "éèêë";
        String expected = "eeee";
        String actual = invokeStripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_WithEmptyString() throws Exception {
        String input = "";
        String expected = "";
        String actual = invokeStripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_WithNullInput() throws Exception {
        String input = null;
        String actual = invokeStripAccents(input);
        assertNull(actual);
    }

    @Test
    public void testStripAccents_WithNoAccents() throws Exception {
        String input = "Hello World";
        String expected = "Hello World";
        String actual = invokeStripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_WithMixedAccents() throws Exception {
        String input = "Café naïve façade";
        String expected = "Cafe naive facade";
        String actual = invokeStripAccents(input);
        assertEquals(expected, actual);
    }

    private String invokeStripAccents(String input) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("stripAccents", String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, input);
    }
}
