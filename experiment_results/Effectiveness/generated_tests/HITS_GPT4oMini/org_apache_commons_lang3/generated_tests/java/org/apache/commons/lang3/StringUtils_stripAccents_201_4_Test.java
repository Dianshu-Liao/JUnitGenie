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

public class StringUtils_stripAccents_201_4_Test {

    @Test
    public void testStripAccents_withNormalString() {
        String input = "Café";
        String expected = "Cafe";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withStringContainingMultipleAccents() {
        String input = "Crème brûlée";
        String expected = "Creme brulee";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withNullInput() {
        String input = null;
        String expected = null;
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withStringWithoutAccents() {
        String input = "Hello World";
        String expected = "Hello World";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withStringContainingDiacriticalMarks() {
        String input = "Ångström";
        String expected = "Angstrom";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withStringContainingVariousAccents() {
        String input = "São Paulo";
        String expected = "Sao Paulo";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withStringContainingSpecialCharacters() {
        String input = "Pâté à la mode!";
        String expected = "Pate a la mode!";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testStripAccents_withStringContainingUnicodeCharacters() {
        String input = "Déjà vu";
        String expected = "Deja vu";
        String actual = StringUtils.stripAccents(input);
        assertEquals(expected, actual);
    }
}
