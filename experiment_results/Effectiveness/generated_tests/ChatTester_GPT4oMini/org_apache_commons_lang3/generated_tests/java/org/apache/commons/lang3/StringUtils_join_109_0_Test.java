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

public class StringUtils_join_109_0_Test {

    @Test
    public void testJoin_NullList() {
        String result = StringUtils.join((List<?>) null, ",", 0, 2);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptySubList() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 1, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 1, 2);
        assertEquals("B", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 0, 3);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_OutOfBounds() {
        List<String> list = Arrays.asList("A", "B", "C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            StringUtils.join(list, ",", 0, 5);
        });
    }

    @Test
    public void testJoin_NegativeStartIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            StringUtils.join(list, ",", -1, 2);
        });
    }

    @Test
    public void testJoin_SameStartEndIndex() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, ",", 1, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SeparatorNull() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, null, 0, 3);
        // Assuming join handles null separator by using space
        assertEquals("A B C", result);
    }

    @Test
    public void testJoin_EmptySeparator() {
        List<String> list = Arrays.asList("A", "B", "C");
        String result = StringUtils.join(list, "", 0, 3);
        // No separator should concatenate elements
        assertEquals("ABC", result);
    }
}
