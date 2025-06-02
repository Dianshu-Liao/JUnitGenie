package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.List;
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
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_join_104_1_Test {

    @Test
    public void testJoin_NullIterable() {
        // Arrange
        Iterable<?> iterable = null;
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertNull(result, "The result should be null when the iterable is null");
    }

    @Test
    public void testJoin_EmptyIterable() {
        // Arrange
        Iterable<String> iterable = Arrays.asList();
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("", result, "The result should be an empty string when the iterable is empty");
    }

    @Test
    public void testJoin_SingleElementIterable() {
        // Arrange
        Iterable<String> iterable = Arrays.asList("element");
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("element", result, "The result should be the single element when the iterable has one element");
    }

    @Test
    public void testJoin_MultipleElementsIterable() {
        // Arrange
        Iterable<String> iterable = Arrays.asList("one", "two", "three");
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("one,two,three", result, "The result should join the elements with the specified separator");
    }

    @Test
    public void testJoin_NonStringElements() {
        // Arrange
        Iterable<Object> iterable = Arrays.asList(1, 2, 3);
        char separator = '-';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("1-2-3", result, "The result should join the non-string elements with the specified separator");
    }
}
