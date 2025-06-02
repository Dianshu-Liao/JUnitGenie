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

public class StringUtils_rightPad_174_0_Test {

    @Test
    public void testRightPad_NullString() {
        String result = StringUtils.rightPad(null, 10);
        assertNull(result);
    }

    @Test
    public void testRightPad_ZeroSize() {
        String result = StringUtils.rightPad("test", 0);
        assertEquals("test", result);
    }

    @Test
    public void testRightPad_SmallerSize() {
        String result = StringUtils.rightPad("test", 2);
        assertEquals("test", result);
    }

    @Test
    public void testRightPad_ExactSize() {
        String result = StringUtils.rightPad("test", 4);
        assertEquals("test", result);
    }

    @Test
    public void testRightPad_GreaterSize() {
        String result = StringUtils.rightPad("test", 10);
        // 6 spaces
        assertEquals("test      ", result);
    }

    @Test
    public void testRightPad_LargeSize() {
        String result = StringUtils.rightPad("test", 8200);
        // 8196 spaces
        assertEquals("test" + new String(new char[8196]).replace('\0', ' '), result);
    }

    @Test
    public void testRightPad_WithSpecialCharacters() {
        String result = StringUtils.rightPad("test", 8);
        // 4 spaces
        assertEquals("test    ", result);
    }

    @Test
    public void testRightPad_WithNegativeSize() {
        String result = StringUtils.rightPad("test", -5);
        assertEquals("test", result);
    }

    private String invokePrivateRightPad(String str, int size) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("rightPad", String.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(null, str, size);
    }

    @Test
    public void testRightPad_PrivateMethod() throws Exception {
        String result = invokePrivateRightPad("test", 10);
        // 6 spaces
        assertEquals("test      ", result);
    }
}
