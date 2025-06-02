package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.lang.reflect.Method;
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

public class StringUtils_join_106_2_Test {

    @Test
    public void testJoin_NullIterator() {
        // Test with null iterator
        String result = invokeJoinMethod(null, ',');
        assertNull(result, "Expected null for null iterator");
    }

    @Test
    public void testJoin_EmptyIterator() {
        // Test with an empty iterator
        Iterator<String> emptyIterator = Collections.emptyIterator();
        String result = invokeJoinMethod(emptyIterator, ',');
        assertEquals(StringUtils.EMPTY, result, "Expected empty string for empty iterator");
    }

    @Test
    public void testJoin_SingleElement() {
        // Test with a single element
        Iterator<String> singleElementIterator = Arrays.asList("element").iterator();
        String result = invokeJoinMethod(singleElementIterator, ',');
        assertEquals("element", result, "Expected single element without separator");
    }

    @Test
    public void testJoin_MultipleElements() {
        // Test with multiple elements
        Iterator<String> multipleElementsIterator = Arrays.asList("one", "two", "three").iterator();
        String result = invokeJoinMethod(multipleElementsIterator, ',');
        assertEquals("one,two,three", result, "Expected elements joined by separator");
    }

    @Test
    public void testJoin_SeparatorAsSpace() {
        // Test with space as separator
        Iterator<String> spaceSeparatorIterator = Arrays.asList("Hello", "World").iterator();
        String result = invokeJoinMethod(spaceSeparatorIterator, ' ');
        assertEquals("Hello World", result, "Expected elements joined by space");
    }

    @Test
    public void testJoin_SeparatorAsEmpty() {
        // Test with empty string as separator
        Iterator<String> emptySeparatorIterator = Arrays.asList("A", "B", "C").iterator();
        // '\0' as a non-visible separator
        String result = invokeJoinMethod(emptySeparatorIterator, '\0');
        assertEquals("ABC", result, "Expected elements joined without any visible separator");
    }

    private String invokeJoinMethod(Iterator<?> iterator, char separator) {
        try {
            Method joinMethod = StringUtils.class.getDeclaredMethod("join", Iterator.class, char.class);
            joinMethod.setAccessible(true);
            return (String) joinMethod.invoke(null, iterator, separator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
