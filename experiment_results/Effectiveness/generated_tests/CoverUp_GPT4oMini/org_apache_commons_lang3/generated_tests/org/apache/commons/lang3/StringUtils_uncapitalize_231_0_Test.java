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

public class StringUtils_uncapitalize_231_0_Test {

    @Test
    public void testUncapitalize_EmptyString() throws Exception {
        String result = invokeUncapitalize("");
        assertEquals("", result);
    }

    @Test
    public void testUncapitalize_SingleUppercase() throws Exception {
        String result = invokeUncapitalize("Hello");
        assertEquals("hello", result);
    }

    @Test
    public void testUncapitalize_SingleLowercase() throws Exception {
        String result = invokeUncapitalize("hello");
        assertEquals("hello", result);
    }

    @Test
    public void testUncapitalize_AlreadyLowercase() throws Exception {
        String result = invokeUncapitalize("hElLo");
        assertEquals("hElLo", result);
    }

    @Test
    public void testUncapitalize_LeadingWhitespace() throws Exception {
        String result = invokeUncapitalize(" Hello");
        assertEquals(" hello", result);
    }

    @Test
    public void testUncapitalize_NonAlphabetic() throws Exception {
        String result = invokeUncapitalize("123Hello");
        assertEquals("123hello", result);
    }

    @Test
    public void testUncapitalize_NullInput() throws Exception {
        String result = invokeUncapitalize(null);
        assertEquals(null, result);
    }

    private String invokeUncapitalize(String str) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("uncapitalize", String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, str);
    }
}
