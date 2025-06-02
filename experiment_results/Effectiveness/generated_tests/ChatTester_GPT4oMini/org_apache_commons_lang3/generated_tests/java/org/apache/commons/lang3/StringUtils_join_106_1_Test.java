// Test method
package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Iterator;
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

public class StringUtils_join_106_1_Test {

    @Test
    public void testJoin_NullIterator() {
        assertNull(StringUtils.join((Iterator<?>) null, ','));
    }

    @Test
    public void testJoin_EmptyIterator() {
        Iterator<String> emptyIterator = Arrays.asList("").iterator();
        assertEquals(StringUtils.EMPTY, StringUtils.join(emptyIterator, ','));
    }

    @Test
    public void testJoin_SingleElement() {
        Iterator<String> singleElementIterator = Arrays.asList("element").iterator();
        assertEquals("element", StringUtils.join(singleElementIterator, ','));
    }

    @Test
    public void testJoin_MultipleElements() {
        Iterator<String> multipleElementsIterator = Arrays.asList("one", "two", "three").iterator();
        assertEquals("one,two,three", StringUtils.join(multipleElementsIterator, ','));
    }

    @Test
    public void testJoin_WithDifferentSeparator() {
        Iterator<String> elementsIterator = Arrays.asList("apple", "banana", "cherry").iterator();
        assertEquals("apple|banana|cherry", StringUtils.join(elementsIterator, '|'));
    }

    @Test
    public void testJoin_SingleCharacterSeparator() {
        Iterator<String> charSeparatorIterator = Arrays.asList("A", "B", "C").iterator();
        assertEquals("A-B-C", StringUtils.join(charSeparatorIterator, '-'));
    }

    @Test
    public void testJoin_NonStringElements() {
        // Fixed the line to use Iterator<String> instead of Iterator<Object>
        Iterator<String> nonStringIterator = Arrays.asList("1", "2", "3").iterator();
        assertEquals("1,2,3", StringUtils.join(nonStringIterator, ','));
    }
}
