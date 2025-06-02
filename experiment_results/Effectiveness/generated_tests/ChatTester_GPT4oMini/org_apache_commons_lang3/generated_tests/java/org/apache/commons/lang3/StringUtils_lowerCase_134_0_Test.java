package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.Locale;
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
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_lowerCase_134_0_Test {

    @Test
    public void testLowerCase_NullInput() {
        String result = StringUtils.lowerCase(null, Locale.ENGLISH);
        Assertions.assertNull(result);
    }

    @Test
    public void testLowerCase_EmptyString() {
        String result = StringUtils.lowerCase("", Locale.ENGLISH);
        Assertions.assertEquals("", result);
    }

    @Test
    public void testLowerCase_ValidInput() {
        String result = StringUtils.lowerCase("HELLO", Locale.ENGLISH);
        Assertions.assertEquals("hello", result);
    }

    @Test
    public void testLowerCase_WithLocale() {
        String result = StringUtils.lowerCase("ÇA VA", Locale.FRENCH);
        Assertions.assertEquals("ça va", result);
    }

    @Test
    public void testLowerCase_WithDifferentLocale() {
        String result = StringUtils.lowerCase("HELLO WORLD", Locale.GERMAN);
        Assertions.assertEquals("hello world", result);
    }

    @Test
    public void testLowerCase_UnsupportedLocale() {
        String result = StringUtils.lowerCase("HELLO", new Locale("xx"));
        Assertions.assertEquals("hello", result);
    }

    // Reflection test for private methods if needed
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}
