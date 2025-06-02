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

public class StringUtils_indexOfAny_64_0_Test {

    @Test
    public void testIndexOfAny_EmptyCharSequence() {
        // Arrange
        CharSequence cs = null;
        String searchChars = "abc";
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_EmptySearchChars() {
        // Arrange
        CharSequence cs = "hello";
        String searchChars = "";
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_BothEmpty() {
        // Arrange
        CharSequence cs = null;
        String searchChars = null;
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_NonEmpty() {
        // Arrange
        CharSequence cs = "hello";
        String searchChars = "abc";
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_CharFound() {
        // Arrange
        CharSequence cs = "hello";
        String searchChars = "eol";
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        // 'e' is at index 1
        assertEquals(1, result);
    }

    @Test
    public void testIndexOfAny_CharFoundAtEnd() {
        // Arrange
        CharSequence cs = "hello";
        String searchChars = "lo";
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        // 'l' is at index 3
        assertEquals(3, result);
    }

    @Test
    public void testIndexOfAny_CharFoundAtStart() {
        // Arrange
        CharSequence cs = "hello";
        String searchChars = "h";
        // Act
        int result = StringUtils.indexOfAny(cs, searchChars);
        // Assert
        // 'h' is at index 0
        assertEquals(0, result);
    }
}
