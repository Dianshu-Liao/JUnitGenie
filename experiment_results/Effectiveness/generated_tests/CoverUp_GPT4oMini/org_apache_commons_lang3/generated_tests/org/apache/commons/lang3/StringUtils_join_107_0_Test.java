package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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

public class StringUtils_join_107_0_Test {

    @Test
    public void testJoin_NullIterator() {
        // Test with null iterator
        String result = StringUtils.join((Iterator<?>) null, ",");
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyIterator() {
        // Test with empty iterator
        String result = StringUtils.join(Collections.emptyIterator(), ",");
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        // Test with single element
        Iterator<String> iterator = Arrays.asList("Hello").iterator();
        String result = StringUtils.join(iterator, ",");
        assertEquals("Hello", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        // Test with multiple elements
        Iterator<String> iterator = Arrays.asList("Hello", "World").iterator();
        String result = StringUtils.join(iterator, ", ");
        assertEquals("Hello, World", result);
    }

    @Test
    public void testJoin_NullSeparator() {
        // Test with null separator
        Iterator<String> iterator = Arrays.asList("Hello", "World").iterator();
        String result = StringUtils.join(iterator, null);
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testJoin_EmptySeparator() {
        // Test with empty separator
        Iterator<String> iterator = Arrays.asList("Hello", "World").iterator();
        String result = StringUtils.join(iterator, StringUtils.EMPTY);
        assertEquals("HelloWorld", result);
    }
}
