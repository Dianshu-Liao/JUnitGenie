package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
public class StringUtils_join_109_0_Test {

    @Test
    public void testJoin_NullList() {
        String result = StringUtils.join((List<?>) null, ",", 0, 2);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyList() {
        String result = StringUtils.join(Collections.emptyList(), ",", 0, 2);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        List<String> list = Arrays.asList("A");
        String result = StringUtils.join(list, ",", 0, 1);
        assertEquals("A", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 0, 3);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_SubList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = StringUtils.join(list, ",", 1, 3);
        assertEquals("B,C", result);
    }

    @Test
    public void testJoin_InvalidRange() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 2, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_StartIndexGreaterThanListSize() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 3, 5);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_EndIndexGreaterThanListSize() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 1, 5);
        assertEquals("B,C", result);
    }
}
