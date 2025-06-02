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

public class StringUtils_join_106_1_Test {

    @Test
    public void testJoin_NullIterator() {
        String result = StringUtils.join((Iterator<?>) null, ',');
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyIterator() {
        String result = StringUtils.join(Collections.emptyIterator(), ',');
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElement() {
        Iterator<String> iterator = Arrays.asList("A").iterator();
        String result = StringUtils.join(iterator, ',');
        assertEquals("A", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        Iterator<String> iterator = Arrays.asList("A", "B", "C").iterator();
        String result = StringUtils.join(iterator, ',');
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_WithDifferentSeparator() {
        Iterator<String> iterator = Arrays.asList("1", "2", "3").iterator();
        String result = StringUtils.join(iterator, '-');
        assertEquals("1-2-3", result);
    }

    @Test
    public void testJoin_WithEmptyStrings() {
        Iterator<String> iterator = Arrays.asList("", "A", "", "B").iterator();
        String result = StringUtils.join(iterator, ',');
        assertEquals(",A,,B", result);
    }

    @Test
    public void testJoin_WithNullElements() {
        Iterator<String> iterator = Arrays.asList("A", null, "C").iterator();
        String result = StringUtils.join(iterator, ',');
        assertEquals("A,null,C", result);
    }
}
