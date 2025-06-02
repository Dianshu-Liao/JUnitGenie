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

public class StringUtils_containsAny_21_0_Test {

    @Test
    public void testContainsAny_WithNullSearchChars_ReturnsFalse() {
        // Arrange
        CharSequence input = "hello world";
        CharSequence searchChars = null;
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertFalse(result, "Expected containsAny to return false when searchChars is null");
    }

    @Test
    public void testContainsAny_WithEmptyInputAndNullSearchChars_ReturnsFalse() {
        // Arrange
        CharSequence input = "";
        CharSequence searchChars = null;
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertFalse(result, "Expected containsAny to return false when input is empty and searchChars is null");
    }

    @Test
    public void testContainsAny_WithNullInputAndNullSearchChars_ReturnsFalse() {
        // Arrange
        CharSequence input = null;
        CharSequence searchChars = null;
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertFalse(result, "Expected containsAny to return false when both input and searchChars are null");
    }

    @Test
    public void testContainsAny_WithValidInputAndNullSearchChars_ReturnsFalse() {
        // Arrange
        CharSequence input = "hello world";
        CharSequence searchChars = null;
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertFalse(result, "Expected containsAny to return false when searchChars is null regardless of input");
    }

    @Test
    public void testContainsAny_WithValidInputAndEmptySearchChars_ReturnsFalse() {
        // Arrange
        CharSequence input = "hello world";
        CharSequence searchChars = "";
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertFalse(result, "Expected containsAny to return false when searchChars is empty");
    }

    @Test
    public void testContainsAny_WithValidInputAndSearchChars_ReturnsTrue() {
        // Arrange
        CharSequence input = "hello world";
        CharSequence searchChars = "o";
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertTrue(result, "Expected containsAny to return true when input contains any character from searchChars");
    }

    @Test
    public void testContainsAny_WithValidInputAndMultipleSearchChars_ReturnsTrue() {
        // Arrange
        CharSequence input = "hello world";
        CharSequence searchChars = "aeiou";
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertTrue(result, "Expected containsAny to return true when input contains any character from multiple searchChars");
    }

    @Test
    public void testContainsAny_WithValidInputAndNoMatchingSearchChars_ReturnsFalse() {
        // Arrange
        CharSequence input = "hello world";
        CharSequence searchChars = "xyz";
        // Act
        boolean result = StringUtils.containsAny(input, searchChars);
        // Assert
        assertFalse(result, "Expected containsAny to return false when input does not contain any characters from searchChars");
    }
}
