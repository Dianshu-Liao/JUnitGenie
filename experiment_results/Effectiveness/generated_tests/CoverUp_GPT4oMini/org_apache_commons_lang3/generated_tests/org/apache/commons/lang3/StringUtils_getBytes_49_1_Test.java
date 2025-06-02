package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class StringUtils_getBytes_49_1_Test {

    @Test
    void testGetBytes_NullString() {
        assertThrows(UnsupportedEncodingException.class, () -> {
            invokeGetBytes(null, "UTF-8");
        });
    }

    @Test
    void testGetBytes_ValidStringAndCharset() throws Exception {
        String input = "Hello, World!";
        String charset = "UTF-8";
        byte[] result = invokeGetBytes(input, charset);
        assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    void testGetBytes_ValidStringAndNullCharset() throws Exception {
        String input = "Hello, World!";
        byte[] result = invokeGetBytes(input, null);
        assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    void testGetBytes_ValidStringAndInvalidCharset() {
        String input = "Hello, World!";
        String charset = "INVALID_CHARSET";
        assertThrows(UnsupportedEncodingException.class, () -> {
            invokeGetBytes(input, charset);
        });
    }

    @Test
    void testGetBytes_EmptyString() throws Exception {
        byte[] result = invokeGetBytes("", "UTF-8");
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testGetBytes_ValidStringAndDefaultCharset() throws Exception {
        String input = "Hello, World!";
        byte[] result = invokeGetBytes(input, "ISO-8859-1");
        assertArrayEquals(input.getBytes(StandardCharsets.ISO_8859_1), result);
    }

    private byte[] invokeGetBytes(String string, String charset) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("getBytes", String.class, String.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, string, charset);
    }
}
