// Test method
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
    public void testJoin_withNonEmptyIterable() {
        // Arrange
        List<String> elements = Arrays.asList("apple", "banana", "cherry");
        String separator = ", ";
        // Act
        String result = StringUtils.join(elements, separator);
        // Assert
        assertEquals("apple, banana, cherry", result);
    }

    @Test
    public void testJoin_withEmptyIterable() {
        // Arrange
        List<String> elements = Arrays.asList();
        String separator = ", ";
        // Act
        String result = StringUtils.join(elements, separator);
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testJoin_withNullIterable() {
        // Arrange
        String result = StringUtils.join((Iterable<?>) null, ", ");
        // Assert
        assertNull(result);
    }

    @Test
    public void testJoin_withSingleElement() {
        // Arrange
        List<String> elements = Arrays.asList("apple");
        String separator = ", ";
        // Act
        String result = StringUtils.join(elements, separator);
        // Assert
        assertEquals("apple", result);
    }

    @Test
    public void testJoin_withNullSeparator() {
        // Arrange
        List<String> elements = Arrays.asList("apple", "banana", "cherry");
        String separator = null;
        // Act
        String result = StringUtils.join(elements, separator);
        // Assert
        // Assuming join handles null separator
        assertEquals("applebananacherry", result);
    }

    @Test
    public void testJoin_withEmptySeparator() {
        // Arrange
        List<String> elements = Arrays.asList("apple", "banana", "cherry");
        String separator = "";
        // Act
        String result = StringUtils.join(elements, separator);
        // Assert
        // Assuming join handles empty separator
        assertEquals("applebananacherry", result);
    }
}
