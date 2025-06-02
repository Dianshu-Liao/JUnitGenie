package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

public class StringUtils_join_108_0_Test {

    @Test
    public void testJoin_NullList() {
        String result = invokeJoinMethod(null, ',', 0, 1);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyList() {
        String result = invokeJoinMethod(Collections.emptyList(), ',', 0, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        List<String> list = Arrays.asList("A");
        String result = invokeJoinMethod(list, ',', 0, 1);
        assertEquals("A", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoinMethod(list, ',', 0, 3);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_SubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = invokeJoinMethod(list, ',', 1, 3);
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_StartIndexGreaterThanEndIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoinMethod(list, ',', 2, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_NegativeStartIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoinMethod(list, ',', -1, 2);
        assertEquals("A,B", result);
    }

    @Test
    public void testJoin_EndIndexExceedsListSize() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = invokeJoinMethod(list, ',', 0, 5);
        assertEquals("A,B,C", result);
    }

    private String invokeJoinMethod(List<?> list, char separator, int startIndex, int endIndex) {
        try {
            Method method = StringUtils.class.getDeclaredMethod("join", List.class, char.class, int.class, int.class);
            method.setAccessible(true);
            return (String) method.invoke(null, list, separator, startIndex, endIndex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
