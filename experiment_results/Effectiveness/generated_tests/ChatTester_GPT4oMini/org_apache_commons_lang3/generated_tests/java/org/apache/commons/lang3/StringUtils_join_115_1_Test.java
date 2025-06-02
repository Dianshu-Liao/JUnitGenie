package org.apache.commons.lang3;

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
import java.util.Arrays;
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

public class StringUtils_join_115_1_Test {

    @Test
    public void testJoin_NullArray() {
        String result = StringUtils.join((Object[]) null, ",", 0, 2);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyArray() {
        String result = StringUtils.join(new Object[] {}, ",", 0, 2);
        assertEquals("", result);
    }

    @Test
    public void testJoin_StartIndexGreaterThanEndIndex() {
        String result = StringUtils.join(new Object[] { "a", "b", "c" }, ",", 2, 1);
        assertEquals("", result);
    }

    @Test
    public void testJoin_ValidParameters() {
        String result = StringUtils.join(new Object[] { "a", "b", "c" }, ",", 0, 3);
        assertEquals("a,b,c", result);
    }

    @Test
    public void testJoin_ValidParameters_WithDelimiter() {
        String result = StringUtils.join(new Object[] { "1", "2", "3" }, "-", 0, 3);
        assertEquals("1-2-3", result);
    }

    @Test
    public void testJoin_StartIndexOutOfBounds() {
        String result = StringUtils.join(new Object[] { "a", "b", "c" }, ",", 5, 10);
        assertEquals("", result);
    }

    @Test
    public void testJoin_EndIndexOutOfBounds() {
        String result = StringUtils.join(new Object[] { "a", "b", "c" }, ",", 1, 5);
        assertEquals("b,c", result);
    }

    @Test
    public void testJoin_NegativeStartIndex() {
        String result = StringUtils.join(new Object[] { "a", "b", "c" }, ",", -1, 2);
        assertEquals("a,b", result);
    }
}
