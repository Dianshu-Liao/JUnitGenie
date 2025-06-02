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

public class StringUtils_join_108_0_Test {

    @Test
    public void testJoin_NullList() {
        String result = StringUtils.join((Iterable<?>) null, ',', 0, 3);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyList() {
        List<String> list = Arrays.asList();
        String result = StringUtils.join(list, ',', 0, 0);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        List<String> list = Arrays.asList("A");
        String result = StringUtils.join(list, ',', 0, 1);
        assertEquals("A", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ',', 0, 3);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_SubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = StringUtils.join(list, ',', 1, 3);
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_InvalidIndices() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ',', 3, 3);
        assertEquals(StringUtils.EMPTY, result);
        result = StringUtils.join(list, ',', 1, 5);
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_NegativeStartIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ',', -1, 2);
        assertEquals("A,B", result);
    }

    @Test
    public void testJoin_ZeroLengthSubList() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ',', 1, 1);
        assertEquals(StringUtils.EMPTY, result);
    }
}
