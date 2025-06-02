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

public class StringUtils_center_9_0_Test {

    @Test
    public void testCenter_NullString() throws Exception {
        String result = invokeCenterMethod(null, 10, '*');
        assertNull(result);
    }

    @Test
    public void testCenter_ZeroSize() throws Exception {
        String result = invokeCenterMethod("test", 0, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_NegativeSize() throws Exception {
        String result = invokeCenterMethod("test", -5, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_SmallerSize() throws Exception {
        String result = invokeCenterMethod("test", 3, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_ExactSize() throws Exception {
        String result = invokeCenterMethod("test", 4, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_WithPadding() throws Exception {
        String result = invokeCenterMethod("test", 10, '*');
        assertEquals("**test****", result);
    }

    @Test
    public void testCenter_OddSizeWithPadding() throws Exception {
        String result = invokeCenterMethod("test", 9, '*');
        assertEquals("*test****", result);
    }

    private String invokeCenterMethod(String str, int size, char padChar) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("center", String.class, int.class, char.class);
        method.setAccessible(true);
        return (String) method.invoke(null, str, size, padChar);
    }
}
