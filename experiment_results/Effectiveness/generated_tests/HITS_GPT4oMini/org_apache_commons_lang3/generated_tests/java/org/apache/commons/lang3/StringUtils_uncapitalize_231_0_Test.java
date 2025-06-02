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
        assertEquals("", result, "Expected empty string to remain unchanged");
    }

    @Test
    public void testUncapitalize_SingleUppercaseLetter() {
        String result = StringUtils.uncapitalize("A");
        assertEquals("a", result, "Expected 'A' to be converted to 'a'");
    }

    @Test
    public void testUncapitalize_SingleLowercaseLetter() {
        String result = StringUtils.uncapitalize("a");
        assertEquals("a", result, "Expected 'a' to remain unchanged");
    }

    @Test
    public void testUncapitalize_UppercaseFirstLetter() {
        String result = StringUtils.uncapitalize("Hello");
        assertEquals("hello", result, "Expected 'Hello' to be converted to 'hello'");
    }

    @Test
    public void testUncapitalize_LowercaseFirstLetter() {
        String result = StringUtils.uncapitalize("world");
        assertEquals("world", result, "Expected 'world' to remain unchanged");
    }

    @Test
    public void testUncapitalize_MixedCase() {
        String result = StringUtils.uncapitalize("JavaProgramming");
        assertEquals("javaProgramming", result, "Expected 'JavaProgramming' to be converted to 'javaProgramming'");
    }

    @Test
    public void testUncapitalize_NonAlphabeticFirstCharacter() {
        String result = StringUtils.uncapitalize("1Hello");
        assertEquals("1hello", result, "Expected '1Hello' to be converted to '1hello'");
    }

    @Test
    public void testUncapitalize_NullInput() {
        String result = StringUtils.uncapitalize(null);
        assertNull(result, "Expected null input to return null");
    }

    @Test
    public void testUncapitalize_SpecialCharacters() {
        String result = StringUtils.uncapitalize("@Hello");
        assertEquals("@hello", result, "Expected '@Hello' to be converted to '@hello'");
    }

    @Test
    public void testUncapitalize_Whitespace() {
        String result = StringUtils.uncapitalize(" Hello");
        assertEquals(" hello", result, "Expected ' Hello' to be converted to ' hello'");
    }
}
