package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
public class StringUtils_join_109_3_Test {

    @Test
    public void testJoin_NullList() {
        String result = StringUtils.join((List<?>) null, ",", 0, 1);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyList() {
        String result = StringUtils.join(Collections.emptyList(), ",", 0, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_StartIndexGreaterThanEndIndex() {
        String result = StringUtils.join(Arrays.asList("a", "b", "c"), ",", 2, 1);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testJoin_ValidInput() {
        String result = StringUtils.join(Arrays.asList("a", "b", "c"), ",", 0, 3);
        assertEquals("a,b,c", result);
    }

    @Test
    public void testJoin_SubList() {
        String result = StringUtils.join(Arrays.asList("a", "b", "c", "d"), ",", 1, 3);
        assertEquals("b,c", result);
    }

    @Test
    public void testJoin_SingleElement() {
        String result = StringUtils.join(Arrays.asList("a"), ",", 0, 1);
        assertEquals("a", result);
    }
}
