package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
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
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyIterator() {
        String result = StringUtils.join(Collections.emptyIterator(), ',');
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_SingleElementIterator() {
        String result = StringUtils.join(Arrays.asList("element").iterator(), ',');
        assertEquals("element", result);
    }

    @Test
    public void testJoin_MultipleElementsIterator() {
        String result = StringUtils.join(Arrays.asList("one", "two", "three").iterator(), ',');
        assertEquals("one,two,three", result);
    }

    @Test
    public void testJoin_IteratorWithNullElements() {
        String result = StringUtils.join(Arrays.asList("one", null, "three").iterator(), ',');
        assertEquals("one,null,three", result);
    }

    @Test
    public void testJoin_Separator() {
        String result = StringUtils.join(Arrays.asList("a", "b", "c").iterator(), '-');
        assertEquals("a-b-c", result);
    }
}
