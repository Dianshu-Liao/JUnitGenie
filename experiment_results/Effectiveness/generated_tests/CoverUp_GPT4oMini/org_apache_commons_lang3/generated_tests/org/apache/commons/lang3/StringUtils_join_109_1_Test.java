package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class StringUtils_join_109_1_Test {

    @Test
    public void testJoin_NullList() {
        String result = invokeJoin(null, ",", 0, 5);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyList() {
        List<String> list = Arrays.asList();
        String result = invokeJoin(list, ",", 0, 0);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        List<String> list = Arrays.asList("A");
        String result = invokeJoin(list, ",", 0, 1);
        assertEquals("A", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoin(list, ",", 0, 3);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_WithStartIndex() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = invokeJoin(list, ",", 1, 3);
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_WithOutOfBounds() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoin(list, ",", 1, 5);
        // Should handle out of bounds
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_NegativeStartIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoin(list, ",", -1, 2);
        // Should handle negative start index
        assertEquals("A,B", result);
    }

    @Test
    public void testJoin_SameStartEndIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoin(list, ",", 1, 1);
        // No elements to join
        assertEquals(StringUtils.EMPTY, result);
    }

    private String invokeJoin(List<?> list, String separator, int startIndex, int endIndex) {
        try {
            Method method = StringUtils.class.getDeclaredMethod("join", List.class, String.class, int.class, int.class);
            method.setAccessible(true);
            return (String) method.invoke(null, list, separator, startIndex, endIndex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
