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
    public void testCenter_EmptyPadStr() {
        String result = StringUtils.center("test", 10, "");
        assertEquals("   test    ", result);
    }

    @Test
    public void testCenter_ExactSize() {
        String result = StringUtils.center("test", 4, "*");
        assertEquals("test", result);
    }

    @Test
    public void testCenter_LargerSize() {
        String result = StringUtils.center("test", 10, "*");
        assertEquals("   test    ", result);
    }

    @Test
    public void testCenter_SmallerSize() {
        String result = StringUtils.center("test", 3, "*");
        assertEquals("test", result);
    }

    @Test
    public void testCenter_WithCustomPadStr() {
        String result = StringUtils.center("test", 10, "-");
        assertEquals("---test----", result);
    }

    // Reflection test for private methods
    @Test
    public void testCenter_Reflection() throws Exception {
        Method leftPadMethod = StringUtils.class.getDeclaredMethod("leftPad", String.class, int.class, String.class);
        leftPadMethod.setAccessible(true);
        Method rightPadMethod = StringUtils.class.getDeclaredMethod("rightPad", String.class, int.class, String.class);
        rightPadMethod.setAccessible(true);
        // You could also test the leftPad and rightPad methods directly if they are accessible
        // For this example, we are just ensuring we can access them
        assertNotNull(leftPadMethod);
        assertNotNull(rightPadMethod);
    }
}
