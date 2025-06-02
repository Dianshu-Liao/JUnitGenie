package org.apache.commons.lang3;

import java.util.Locale;
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
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_lowerCase_134_0_Test {

    @Test
    public void testLowerCase_NullInput() {
        // Arrange
        String input = null;
        Locale locale = Locale.ENGLISH;
        // Act
        String result = StringUtils.lowerCase(input, locale);
        // Assert
        Assertions.assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testLowerCase_EmptyString() {
        // Arrange
        String input = "";
        Locale locale = Locale.ENGLISH;
        // Act
        String result = StringUtils.lowerCase(input, locale);
        // Assert
        Assertions.assertEquals("", result, "Expected empty string when input is empty");
    }

    @Test
    public void testLowerCase_SingleUppercaseCharacter() {
        // Arrange
        String input = "A";
        Locale locale = Locale.ENGLISH;
        // Act
        String result = StringUtils.lowerCase(input, locale);
        // Assert
        Assertions.assertEquals("a", result, "Expected 'a' when input is 'A'");
    }

    @Test
    public void testLowerCase_MixedCaseString() {
        // Arrange
        String input = "HeLLo WoRLd";
        Locale locale = Locale.ENGLISH;
        // Act
        String result = StringUtils.lowerCase(input, locale);
        // Assert
        Assertions.assertEquals("hello world", result, "Expected 'hello world' for mixed case input");
    }

    @Test
    public void testLowerCase_NonLatinCharacters() {
        // Arrange
        String input = "ÄÖÜß";
        Locale locale = Locale.GERMAN;
        // Act
        String result = StringUtils.lowerCase(input, locale);
        // Assert
        Assertions.assertEquals("äöüß", result, "Expected 'äöüß' for German locale input");
    }

    @Test
    public void testLowerCase_NullLocale() {
        // Arrange
        String input = "HELLO";
        Locale locale = null;
        // Act
        String result = StringUtils.lowerCase(input, locale);
        // Assert
        Assertions.assertEquals("hello", result, "Expected 'hello' when locale is null (default locale used)");
    }
}
