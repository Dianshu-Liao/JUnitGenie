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

public class StringUtils_join_104_2_Test {

    @Test
    public void testJoin_NonEmptyIterable() {
        List<String> input = Arrays.asList("apple", "banana", "cherry");
        char separator = ',';
        String result = StringUtils.join(input, separator);
        assertEquals("apple,banana,cherry", result);
    }

    @Test
    public void testJoin_EmptyIterable() {
        List<String> input = Arrays.asList();
        char separator = ',';
        String result = StringUtils.join(input, separator);
        assertEquals("", result);
    }

    @Test
    public void testJoin_NullIterable() {
        List<String> input = null;
        char separator = ',';
        String result = StringUtils.join(input, separator);
        assertNull(result);
    }

    @Test
    public void testJoin_SingleElementIterable() {
        List<String> input = Arrays.asList("single");
        char separator = ',';
        String result = StringUtils.join(input, separator);
        assertEquals("single", result);
    }

    @Test
    public void testJoin_SeparatorEmpty() {
        List<String> input = Arrays.asList("one", "two", "three");
        char separator = ' ';
        String result = StringUtils.join(input, separator);
        assertEquals("one two three", result);
    }

    @Test
    public void testJoin_NullElementInIterable() {
        List<String> input = Arrays.asList("apple", null, "cherry");
        char separator = ',';
        String result = StringUtils.join(input, separator);
        assertEquals("apple,null,cherry", result);
    }

    @Test
    public void testJoin_SpecialCharacters() {
        List<String> input = Arrays.asList("a&b", "c@d", "e#f");
        char separator = '|';
        String result = StringUtils.join(input, separator);
        assertEquals("a&b|c@d|e#f", result);
    }
}
