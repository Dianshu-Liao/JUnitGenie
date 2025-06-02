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

public class StringUtils_center_8_0_Test {

    @Test
    public void testCenterWithNullString() {
        String result = StringUtils.center(null, 10);
        assertNull(result);
    }

    @Test
    public void testCenterWithZeroSize() {
        String result = StringUtils.center("test", 0);
        assertEquals("test", result);
    }

    @Test
    public void testCenterWithNegativeSize() {
        String result = StringUtils.center("test", -5);
        assertEquals("test", result);
    }

    @Test
    public void testCenterWithExactSize() {
        String result = StringUtils.center("test", 4);
        assertEquals("test", result);
    }

    @Test
    public void testCenterWithLargerSize() {
        String result = StringUtils.center("test", 10);
        assertEquals("   test    ", result);
    }

    @Test
    public void testCenterWithLargerSizeAndDifferentPadChar() throws Exception {
        Method centerMethod = StringUtils.class.getDeclaredMethod("center", String.class, int.class, char.class);
        centerMethod.setAccessible(true);
        String result = (String) centerMethod.invoke(null, "test", 10, '*');
        assertEquals("***test****", result);
    }

    @Test
    public void testCenterWithStringLongerThanSize() {
        String result = StringUtils.center("longer than size", 10);
        assertEquals("longer than size", result);
    }

    @Test
    public void testCenterWithEmptyString() {
        String result = StringUtils.center("", 10);
        assertEquals("          ", result);
    }

    @Test
    public void testCenterWithSpaceSize() {
        String result = StringUtils.center("test", 8);
        assertEquals("  test  ", result);
    }
}
