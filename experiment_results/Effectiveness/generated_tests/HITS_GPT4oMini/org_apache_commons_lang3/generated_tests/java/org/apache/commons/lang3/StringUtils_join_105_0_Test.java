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

public class StringUtils_join_105_0_Test {

    @Test
    public void testJoin_NullIterable_ReturnsNull() {
        // Arrange
        Iterable<?> iterable = null;
        String separator = ",";
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertNull(result, "Expected result to be null when iterable is null");
    }

    @Test
    public void testJoin_EmptyIterable_ReturnsNull() {
        // Arrange
        Iterable<?> iterable = Arrays.asList();
        String separator = ",";
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("", result, "Expected result to be an empty string when iterable is empty");
    }

    @Test
    public void testJoin_SingleElementIterable_ReturnsElement() {
        // Arrange
        Iterable<String> iterable = Arrays.asList("element");
        String separator = ",";
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("element", result, "Expected result to be 'element' for a single element iterable");
    }

    @Test
    public void testJoin_MultipleElementsIterable_ReturnsJoinedElements() {
        // Arrange
        Iterable<String> iterable = Arrays.asList("one", "two", "three");
        String separator = ",";
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("one,two,three", result, "Expected result to join elements with the specified separator");
    }

    @Test
    public void testJoin_NonStringElements_ReturnsStringRepresentation() {
        // Arrange
        Iterable<Object> iterable = Arrays.asList(1, 2.5, true);
        String separator = ",";
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("1,2.5,true", result, "Expected result to join non-string elements by their string representation");
    }
}
