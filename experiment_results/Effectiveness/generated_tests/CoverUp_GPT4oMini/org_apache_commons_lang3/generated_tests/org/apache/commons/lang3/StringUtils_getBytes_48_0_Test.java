package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import java.nio.charset.Charset;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
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

public class StringUtils_getBytes_48_0_Test {

    @Test
    public void testGetBytes_withNullString() {
        byte[] result = invokeGetBytes(null, Charset.defaultCharset());
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testGetBytes_withEmptyString() {
        byte[] result = invokeGetBytes("", Charset.defaultCharset());
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testGetBytes_withValidStringAndCharset() {
        String testString = "Hello";
        Charset charset = Charset.forName("UTF-8");
        byte[] expected = testString.getBytes(charset);
        byte[] result = invokeGetBytes(testString, charset);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetBytes_withValidStringAndNullCharset() {
        String testString = "Hello";
        byte[] expected = testString.getBytes(Charset.defaultCharset());
        byte[] result = invokeGetBytes(testString, null);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetBytes_withValidStringAndUnsupportedCharset() {
        String testString = "Hello";
        Charset charset = Charset.forName("ISO-8859-1");
        byte[] expected = testString.getBytes(charset);
        byte[] result = invokeGetBytes(testString, charset);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeGetBytes(String string, Charset charset) {
        try {
            Method method = StringUtils.class.getDeclaredMethod("getBytes", String.class, Charset.class);
            method.setAccessible(true);
            return (byte[]) method.invoke(null, string, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
