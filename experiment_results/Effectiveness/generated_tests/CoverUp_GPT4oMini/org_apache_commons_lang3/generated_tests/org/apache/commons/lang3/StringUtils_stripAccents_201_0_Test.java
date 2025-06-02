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

    private StringUtils stringUtils;

    @BeforeEach
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    public void testStripAccents_NullInput() {
        String result = StringUtils.stripAccents(null);
        assertNull(result);
    }

    @Test
    public void testStripAccents_EmptyInput() {
        String result = StringUtils.stripAccents(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testStripAccents_NoAccents() {
        String result = StringUtils.stripAccents("Hello World");
        assertEquals("Hello World", result);
    }

    @Test
    public void testStripAccents_WithAccents() {
        String result = StringUtils.stripAccents("Café naïve résumé");
        assertEquals("Cafe naive resume", result);
    }

    @Test
    public void testStripAccents_WithDiacriticalMarks() {
        String result = StringUtils.stripAccents("Dànçë");
        assertEquals("Dance", result);
    }

    @Test
    public void testStripAccents_WithComplexAccents() {
        String result = StringUtils.stripAccents("Lüçîfër");
        assertEquals("Lucifer", result);
    }

    @Test
    public void testStripAccents_OnlyAccents() {
        String result = StringUtils.stripAccents("\u00E0\u00E9\u00EC\u00F2\u00F9");
        assertEquals("aeiou", result);
    }

    @Test
    public void testStripAccents_SpecialCharacters() {
        String result = StringUtils.stripAccents("Hëllö Wörld!");
        assertEquals("Hello World!", result);
    }

    @Test
    public void testStripAccents_AccentsMixedWithNonAccented() {
        String result = StringUtils.stripAccents("Crème brûlée");
        assertEquals("Creme brulee", result);
    }

    @Test
    public void testStripAccents_SingleAccentCharacter() {
        String result = StringUtils.stripAccents("é");
        assertEquals("e", result);
    }

    @Test
    public void testConvertRemainingAccentCharacters() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("convertRemainingAccentCharacters", StringBuilder.class);
        method.setAccessible(true);
        StringBuilder input = new StringBuilder("Dànçë");
        method.invoke(null, input);
        assertEquals("Dance", input.toString());
    }
}
