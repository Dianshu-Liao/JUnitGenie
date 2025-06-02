package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
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

public class StringUtils_join_106_0_Test {

    @Test
    public void testJoin_NullIterator() {
        String result = StringUtils.join((Iterator<?>) null, ',');
        assertNull(result, "Expected null for null iterator");
    }

    @Test
    public void testJoin_EmptyIterator() {
        String result = StringUtils.join(Arrays.asList().iterator(), ',');
        assertEquals(StringUtils.EMPTY, result, "Expected empty string for empty iterator");
    }

    @Test
    public void testJoin_SingleElement() {
        String result = StringUtils.join(Arrays.asList("element").iterator(), ',');
        assertEquals("element", result, "Expected single element string");
    }

    @Test
    public void testJoin_MultipleElements() {
        String result = StringUtils.join(Arrays.asList("one", "two", "three").iterator(), ',');
        assertEquals("one,two,three", result, "Expected joined string with separator");
    }

    @Test
    public void testJoin_WithDifferentSeparator() {
        String result = StringUtils.join(Arrays.asList("a", "b", "c").iterator(), '|');
        assertEquals("a|b|c", result, "Expected joined string with different separator");
    }

    @Test
    public void testJoin_NullElement() {
        String result = StringUtils.join(Arrays.asList("a", null, "c").iterator(), ',');
        assertEquals("a,null,c", result, "Expected joined string with null as a string");
    }
}
