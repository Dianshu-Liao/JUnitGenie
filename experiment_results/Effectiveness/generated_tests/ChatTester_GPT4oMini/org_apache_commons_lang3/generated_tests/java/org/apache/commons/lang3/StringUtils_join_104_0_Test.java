// Test method
package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
    public void testJoin_NonEmptyIterable() {
        List<String> elements = Arrays.asList("apple", "banana", "cherry");
        char separator = ',';
        String result = StringUtils.join(elements, separator);
        assertEquals("apple,banana,cherry", result);
    }

    @Test
    public void testJoin_EmptyIterable() {
        List<String> elements = Arrays.asList();
        char separator = ',';
        String result = StringUtils.join(elements, separator);
        assertEquals("", result);
    }

    @Test
    public void testJoin_NullIterable() {
        // Fixed the buggy line
        String result = StringUtils.join((Iterable<?>) null, ',');
        assertNull(result);
    }

    @Test
    public void testJoin_SingleElementIterable() {
        List<String> elements = Arrays.asList("apple");
        char separator = ',';
        String result = StringUtils.join(elements, separator);
        assertEquals("apple", result);
    }

    @Test
    public void testJoin_WithSpaces() {
        List<String> elements = Arrays.asList("apple", " banana ", "cherry");
        char separator = ',';
        String result = StringUtils.join(elements, separator);
        assertEquals("apple, banana ,cherry", result);
    }

    @Test
    public void testJoin_WithNullElements() {
        List<String> elements = Arrays.asList("apple", null, "cherry");
        char separator = ',';
        String result = StringUtils.join(elements, separator);
        assertEquals("apple,null,cherry", result);
    }

    // Reflection test for private method (if needed)
    private String invokePrivateJoinMethod(Iterable<?> iterable, char separator) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("join", Iterable.class, char.class);
        method.setAccessible(true);
        return (String) method.invoke(null, iterable, separator);
    }
}
