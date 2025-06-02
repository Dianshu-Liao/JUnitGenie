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

public class StringUtils_join_112_0_Test {

    @Test
    public void testJoin_NullArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String result = invokeJoinMethod(stringUtils, null, ',');
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String result = invokeJoinMethod(stringUtils, new Object[] {}, ',');
        assertEquals("", result);
    }

    @Test
    public void testJoin_SingleElementArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String result = invokeJoinMethod(stringUtils, new Object[] { "Hello" }, ',');
        assertEquals("Hello", result);
    }

    @Test
    public void testJoin_MultipleElementsArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String result = invokeJoinMethod(stringUtils, new Object[] { "Hello", "World" }, ',');
        assertEquals("Hello,World", result);
    }

    @Test
    public void testJoin_WithDelimiter() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String result = invokeJoinMethod(stringUtils, new Object[] { "One", "Two", "Three" }, '-');
        assertEquals("One-Two-Three", result);
    }

    private String invokeJoinMethod(StringUtils stringUtils, Object[] array, char delimiter) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("join", Object[].class, char.class);
        method.setAccessible(true);
        return (String) method.invoke(stringUtils, new Object[] { array, delimiter });
    }
}
