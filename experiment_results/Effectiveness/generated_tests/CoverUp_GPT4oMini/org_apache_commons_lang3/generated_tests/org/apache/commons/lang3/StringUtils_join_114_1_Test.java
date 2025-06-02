package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class StringUtils_join_114_1_Test {

    @Test
    public void testJoin_NullArray() {
        String result = invokeJoinMethod(null, ",");
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyArray() {
        String result = invokeJoinMethod(new Object[] {}, ",");
        assertEquals("", result);
    }

    @Test
    public void testJoin_SingleElement() {
        String result = invokeJoinMethod(new Object[] { "Hello" }, ",");
        assertEquals("Hello", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        String result = invokeJoinMethod(new Object[] { "Hello", "World" }, ", ");
        assertEquals("Hello, World", result);
    }

    @Test
    public void testJoin_WithNullElement() {
        String result = invokeJoinMethod(new Object[] { "Hello", null, "World" }, ", ");
        assertEquals("Hello, null, World", result);
    }

    @Test
    public void testJoin_EmptyDelimiter() {
        String result = invokeJoinMethod(new Object[] { "Hello", "World" }, "");
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testJoin_SpaceDelimiter() {
        String result = invokeJoinMethod(new Object[] { "Hello", "World" }, " ");
        assertEquals("Hello World", result);
    }

    private String invokeJoinMethod(Object[] array, String delimiter) {
        try {
            Method joinMethod = StringUtils.class.getDeclaredMethod("join", Object[].class, String.class);
            joinMethod.setAccessible(true);
            return (String) joinMethod.invoke(null, new Object[] { array, delimiter });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
