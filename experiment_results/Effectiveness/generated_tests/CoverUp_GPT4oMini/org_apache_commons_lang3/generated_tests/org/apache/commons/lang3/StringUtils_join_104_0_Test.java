package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class StringUtils_join_104_0_Test {

    @Test
    public void testJoin_NullIterable_ReturnsNull() throws Exception {
        String result = invokeJoinMethod(null, ',');
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyIterable_ReturnsEmptyString() throws Exception {
        String result = invokeJoinMethod(Collections.emptyList(), ',');
        assertEquals("", result);
    }

    @Test
    public void testJoin_SingleElementIterable_ReturnsElement() throws Exception {
        String result = invokeJoinMethod(Collections.singletonList("element"), ',');
        assertEquals("element", result);
    }

    @Test
    public void testJoin_MultipleElements_ReturnsJoinedString() throws Exception {
        List<String> elements = Arrays.asList("one", "two", "three");
        String result = invokeJoinMethod(elements, ',');
        assertEquals("one,two,three", result);
    }

    @Test
    public void testJoin_WithDifferentSeparator_ReturnsJoinedStringWithSeparator() throws Exception {
        List<String> elements = Arrays.asList("apple", "banana", "cherry");
        String result = invokeJoinMethod(elements, '|');
        assertEquals("apple|banana|cherry", result);
    }

    private String invokeJoinMethod(Iterable<?> iterable, char separator) throws Exception {
        Method joinMethod = StringUtils.class.getDeclaredMethod("join", Iterable.class, char.class);
        joinMethod.setAccessible(true);
        return (String) joinMethod.invoke(null, iterable, separator);
    }
}
