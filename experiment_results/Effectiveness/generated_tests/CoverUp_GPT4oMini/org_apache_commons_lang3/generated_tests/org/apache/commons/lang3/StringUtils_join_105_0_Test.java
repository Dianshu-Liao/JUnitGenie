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

public class StringUtils_join_105_0_Test {

    @Test
    public void testJoin_WithNonEmptyIterable() throws Exception {
        List<String> elements = Arrays.asList("apple", "banana", "cherry");
        String separator = ", ";
        String expected = "apple, banana, cherry";
        String actual = invokeJoin(elements, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testJoin_WithEmptyIterable() throws Exception {
        List<String> elements = Collections.emptyList();
        String separator = ", ";
        String expected = "";
        String actual = invokeJoin(elements, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void testJoin_WithNullIterable() throws Exception {
        String separator = ", ";
        String actual = invokeJoin(null, separator);
        assertNull(actual);
    }

    @Test
    public void testJoin_WithSingleElement() throws Exception {
        List<String> elements = Collections.singletonList("apple");
        String separator = ", ";
        String expected = "apple";
        String actual = invokeJoin(elements, separator);
        assertEquals(expected, actual);
    }

    private String invokeJoin(Iterable<?> iterable, String separator) throws Exception {
        Method joinMethod = StringUtils.class.getDeclaredMethod("join", Iterable.class, String.class);
        joinMethod.setAccessible(true);
        return (String) joinMethod.invoke(null, iterable, separator);
    }
}
