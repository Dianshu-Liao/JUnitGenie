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

public class StringUtils_join_112_2_Test {

    @Test
    public void testJoin_NullArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String result = invokeJoin(stringUtils, null, ',');
        assertNull(result);
    }

    @Test
    public void testJoin_EmptyArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] array = {};
        String result = invokeJoin(stringUtils, array, ',');
        assertEquals("", result);
    }

    @Test
    public void testJoin_SingleElementArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] array = { "Hello" };
        String result = invokeJoin(stringUtils, array, ',');
        assertEquals("Hello", result);
    }

    @Test
    public void testJoin_MultipleElementsArray() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] array = { "Hello", "World", "Test" };
        String result = invokeJoin(stringUtils, array, ',');
        assertEquals("Hello,World,Test", result);
    }

    @Test
    public void testJoin_ArrayWithNullElement() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] array = { "Hello", null, "World" };
        String result = invokeJoin(stringUtils, array, ',');
        assertEquals("Hello,null,World", result);
    }

    private String invokeJoin(StringUtils stringUtils, Object[] array, char delimiter) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("join", Object[].class, char.class);
        method.setAccessible(true);
        return (String) method.invoke(stringUtils, new Object[] { array, delimiter });
    }
}
