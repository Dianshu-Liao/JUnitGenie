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

public class StringUtils_joinWith_119_0_Test {

    @Test
    public void testJoinWith_NullArray() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.joinWith(",", null);
        });
        assertEquals("Object varargs must not be null", exception.getMessage());
    }

    @Test
    public void testJoinWith_EmptyArray() {
        String result = StringUtils.joinWith(",", new Object[] {});
        assertEquals("", result);
    }

    @Test
    public void testJoinWith_SingleElement() {
        String result = StringUtils.joinWith(",", new Object[] { "element" });
        assertEquals("element", result);
    }

    @Test
    public void testJoinWith_TwoElements() {
        String result = StringUtils.joinWith(",", new Object[] { "element1", "element2" });
        assertEquals("element1,element2", result);
    }

    @Test
    public void testJoinWith_MultipleElements() {
        String result = StringUtils.joinWith(",", new Object[] { "one", "two", "three" });
        assertEquals("one,two,three", result);
    }

    @Test
    public void testJoinWith_CustomDelimiter() {
        String result = StringUtils.joinWith(" | ", new Object[] { "apple", "banana", "cherry" });
        assertEquals("apple | banana | cherry", result);
    }

    @Test
    public void testJoinWith_NullElementInArray() {
        String result = StringUtils.joinWith(",", new Object[] { "element1", null, "element3" });
        assertEquals("element1,null,element3", result);
    }

    @Test
    public void testJoinWith_EmptyStringDelimiter() {
        String result = StringUtils.joinWith("", new Object[] { "a", "b", "c" });
        assertEquals("abc", result);
    }

    @Test
    public void testJoinWith_SpaceDelimiter() {
        String result = StringUtils.joinWith(" ", new Object[] { "Hello", "World" });
        assertEquals("Hello World", result);
    }

    @Test
    public void testJoinWith_SingleNullElement() {
        String result = StringUtils.joinWith(",", new Object[] { null });
        assertEquals("null", result);
    }
}
