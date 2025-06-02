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

public class StringUtils_stripAccents_201_1_Test {

    @Test
    public void testStripAccents_withAccentedCharacters() {
        String input = "Café naïve résumé";
        String expected = "Cafe naive resume";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withMixedCharacters() {
        String input = "Crème brûlée";
        String expected = "Creme brulee";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withNoAccents() {
        String input = "Hello World";
        String expected = "Hello World";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withEmptyString() {
        String input = "";
        String expected = "";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withNullInput() {
        String input = null;
        String expected = null;
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withCharactersToConvert() {
        String input = "Łódź";
        String expected = "Lodz";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withMultipleAccents() {
        String input = "Dänemark übermäßige";
        String expected = "Danemark ubermassige";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }

    @Test
    public void testStripAccents_withSpecialCharacters() {
        String input = "Fête @ 2023!";
        String expected = "Fete @ 2023!";
        String result = StringUtils.stripAccents(input);
        assertEquals(expected, result);
    }
}
