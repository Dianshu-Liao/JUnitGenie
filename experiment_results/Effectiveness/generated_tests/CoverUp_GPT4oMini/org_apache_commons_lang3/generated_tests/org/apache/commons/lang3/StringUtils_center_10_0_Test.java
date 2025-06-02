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

public class StringUtils_center_10_0_Test {

    @Test
    public void testCenter_NullString() {
        String result = StringUtils.center(null, 10, "*");
        assertNull(result);
    }

    @Test
    public void testCenter_ZeroSize() {
        String result = StringUtils.center("test", 0, "*");
        assertEquals("test", result);
    }

    @Test
    public void testCenter_EmptyPaddingString() {
        String result = StringUtils.center("test", 10, "");
        assertEquals("   test   ", result);
    }

    @Test
    public void testCenter_StringLongerThanSize() {
        String result = StringUtils.center("test", 2, "*");
        assertEquals("test", result);
    }

    @Test
    public void testCenter_WithPaddingString() {
        String result = StringUtils.center("test", 10, "*");
        assertEquals("**test****", result);
    }

    @Test
    public void testCenter_WithDifferentPaddingString() {
        String result = StringUtils.center("test", 11, "ab");
        assertEquals("ababtestaba", result);
    }

    @Test
    public void testCenter_WithNullPaddingString() {
        String result = StringUtils.center("test", 10, null);
        assertEquals("   test   ", result);
    }

    @Test
    public void testCenter_WithLargeSize() {
        String result = StringUtils.center("test", 20, "*");
        assertEquals("*******test********", result);
    }

    private String invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod(methodName, String.class, int.class, String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, args);
    }
}
