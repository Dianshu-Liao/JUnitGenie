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

public class StringUtils_leftPad_129_2_Test {

    @Test
    public void testLeftPad_NullString() {
        String result = StringUtils.leftPad(null, 5);
        assertNull(result);
    }

    @Test
    public void testLeftPad_EmptyString() {
        String result = StringUtils.leftPad("", 5);
        assertEquals("     ", result);
    }

    @Test
    public void testLeftPad_ShortString() {
        String result = StringUtils.leftPad("abc", 5);
        assertEquals("  abc", result);
    }

    @Test
    public void testLeftPad_ExactLengthString() {
        String result = StringUtils.leftPad("abc", 3);
        assertEquals("abc", result);
    }

    @Test
    public void testLeftPad_LargeSize() {
        String result = StringUtils.leftPad("abc", 10);
        assertEquals("      abc", result);
    }

    @Test
    public void testLeftPad_ExceedPadLimit() {
        String result = StringUtils.leftPad("abc", 8200);
        assertEquals("      abc", result);
    }

    @Test
    public void testLeftPad_NegativeSize() {
        String result = StringUtils.leftPad("abc", -1);
        assertEquals("abc", result);
    }

    @Test
    public void testLeftPad_ZeroSize() {
        String result = StringUtils.leftPad("abc", 0);
        assertEquals("abc", result);
    }

    @Test
    public void testLeftPad_WithPadChar() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("leftPad", String.class, int.class, char.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "abc", 5, '*');
        assertEquals("**abc", result);
    }
}
