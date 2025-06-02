package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
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

public class StringUtils_substringAfterLast_212_0_Test {

    @Test
    public void testSubstringAfterLast_withEmptyString() throws Exception {
        String result = invokeSubstringAfterLast("", 'a');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withNoSeparator() throws Exception {
        String result = invokeSubstringAfterLast("testString", 'x');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withSeparatorAtEnd() throws Exception {
        String result = invokeSubstringAfterLast("testString#", '#');
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withValidSeparator() throws Exception {
        String result = invokeSubstringAfterLast("testString#value", '#');
        assertEquals("value", result);
    }

    @Test
    public void testSubstringAfterLast_withMultipleSeparators() throws Exception {
        String result = invokeSubstringAfterLast("test#string#value", '#');
        assertEquals("value", result);
    }

    private String invokeSubstringAfterLast(String str, int separator) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("substringAfterLast", String.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(null, str, separator);
    }
}
