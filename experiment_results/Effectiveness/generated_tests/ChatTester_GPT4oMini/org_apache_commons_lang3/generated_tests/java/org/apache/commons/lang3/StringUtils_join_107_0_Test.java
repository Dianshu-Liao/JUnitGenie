package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Iterator;
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
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

class StringUtils_join_107_0_Test {

    @Test
    void testJoin_NullIterator() {
        // Arrange
        Iterator<?> iterator = null;
        String separator = ",";
        // Act
        String result = StringUtils.join(iterator, separator);
        // Assert
        assertNull(result);
    }

    @Test
    void testJoin_EmptyIterator() {
        // Arrange
        Iterator<?> iterator = Arrays.asList().iterator();
        String separator = ",";
        // Act
        String result = StringUtils.join(iterator, separator);
        // Assert
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    void testJoin_SingleElement() {
        // Arrange
        Iterator<?> iterator = Arrays.asList("element").iterator();
        String separator = ",";
        // Act
        String result = StringUtils.join(iterator, separator);
        // Assert
        assertEquals("element", result);
    }

    @Test
    void testJoin_MultipleElements() {
        // Arrange
        List<String> elements = Arrays.asList("one", "two", "three");
        Iterator<?> iterator = elements.iterator();
        String separator = ",";
        // Act
        String result = StringUtils.join(iterator, separator);
        // Assert
        assertEquals("one,two,three", result);
    }

    @Test
    void testJoin_NullSeparator() {
        // Arrange
        List<String> elements = Arrays.asList("one", "two", "three");
        Iterator<?> iterator = elements.iterator();
        String separator = null;
        // Act
        String result = StringUtils.join(iterator, separator);
        // Assert
        assertEquals("onetwothree", result);
    }
}
