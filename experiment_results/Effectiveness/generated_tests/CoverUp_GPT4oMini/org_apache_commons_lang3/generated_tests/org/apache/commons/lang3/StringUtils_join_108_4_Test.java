package org.apache.commons.lang3;

import org.junit.jupiter.api.function.Executable;
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

public class StringUtils_join_108_4_Test {

    @Test
    public void testJoin_NullList() {
        // Arrange
        List<?> list = null;
        char separator = ',';
        int startIndex = 0;
        int endIndex = 1;
        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);
        // Assert
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyList() {
        // Arrange
        List<?> list = Collections.emptyList();
        char separator = ',';
        int startIndex = 0;
        int endIndex = 0;
        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);
        // Assert
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        // Arrange
        List<String> list = Arrays.asList("A");
        char separator = ',';
        int startIndex = 0;
        int endIndex = 1;
        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);
        // Assert
        assertEquals("A", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        // Arrange
        List<String> list = Arrays.asList("A", "B", "C");
        char separator = ',';
        int startIndex = 0;
        int endIndex = 3;
        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);
        // Assert
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_SubList() {
        // Arrange
        List<String> list = Arrays.asList("A", "B", "C", "D");
        char separator = ',';
        int startIndex = 1;
        int endIndex = 3;
        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);
        // Assert
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_InvalidIndices() {
        // Arrange
        List<String> list = Arrays.asList("A", "B", "C");
        char separator = ',';
        int startIndex = 2;
        // Invalid range
        int endIndex = 1;
        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);
        // Assert
        assertEquals(StringUtils.EMPTY, result);
    }
}
