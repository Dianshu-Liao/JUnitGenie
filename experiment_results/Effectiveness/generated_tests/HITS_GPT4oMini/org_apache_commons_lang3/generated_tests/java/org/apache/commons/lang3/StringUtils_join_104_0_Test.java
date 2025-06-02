package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
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

public class StringUtils_join_104_0_Test {

    @Test
    public void testJoin_NullIterable() {
        // Arrange
        Iterable<?> iterable = null;
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertNull(result, "Joining a null iterable should return null");
    }

    @Test
    public void testJoin_EmptyIterable() {
        // Arrange
        Iterable<?> iterable = Collections.emptyList();
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("", result, "Joining an empty iterable should return an empty string");
    }

    @Test
    public void testJoin_SingleElementIterable() {
        // Arrange
        Iterable<?> iterable = Collections.singletonList("single");
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("single", result, "Joining a single element iterable should return the element itself");
    }

    @Test
    public void testJoin_MultipleElementsIterable() {
        // Arrange
        Iterable<?> iterable = Arrays.asList("one", "two", "three");
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("one,two,three", result, "Joining multiple elements should return them separated by the specified character");
    }

    @Test
    public void testJoin_NullElementInIterable() {
        // Arrange
        Iterable<?> iterable = Arrays.asList("one", null, "three");
        char separator = ',';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("one,,three", result, "Joining with a null element should result in consecutive separators");
    }

    @Test
    public void testJoin_SeparatorAsSpace() {
        // Arrange
        Iterable<?> iterable = Arrays.asList("hello", "world");
        char separator = ' ';
        // Act
        String result = StringUtils.join(iterable, separator);
        // Assert
        assertEquals("hello world", result, "Joining should respect the space separator");
    }
}
