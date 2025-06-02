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

public class StringUtils_uncapitalize_231_0_Test {

    @Test
    public void testUncapitalize_EmptyString() {
        String result = StringUtils.uncapitalize("");
        assertEquals("", result);
    }

    @Test
    public void testUncapitalize_SingleCharacterUppercase() {
        String result = StringUtils.uncapitalize("A");
        assertEquals("a", result);
    }

    @Test
    public void testUncapitalize_SingleCharacterLowercase() {
        String result = StringUtils.uncapitalize("a");
        assertEquals("a", result);
    }

    @Test
    public void testUncapitalize_MultipleCharacters() {
        String result = StringUtils.uncapitalize("Hello");
        assertEquals("hello", result);
    }

    @Test
    public void testUncapitalize_AlreadyLowercase() {
        String result = StringUtils.uncapitalize("hello");
        assertEquals("hello", result);
    }

    @Test
    public void testUncapitalize_MixedCase() {
        String result = StringUtils.uncapitalize("HeLLo");
        assertEquals("heLLo", result);
    }

    @Test
    public void testUncapitalize_WithNonAlphabeticCharacters() {
        String result = StringUtils.uncapitalize("1Hello");
        assertEquals("1hello", result);
    }

    @Test
    public void testUncapitalize_WithUnicodeCharacters() {
        String result = StringUtils.uncapitalize("Éclair");
        assertEquals("éclair", result);
    }

    @Test
    public void testUncapitalize_WithLeadingSpaces() {
        String result = StringUtils.uncapitalize(" Hello");
        assertEquals(" hello", result);
    }

    @Test
    public void testUncapitalize_WithNull() {
        String result = StringUtils.uncapitalize(null);
        assertNull(result);
    }
}
