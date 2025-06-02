package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class StringUtils_rightPad_175_0_Test {

    @Test
    public void testRightPad_NullString() {
        String result = StringUtils.rightPad(null, 10, '*');
        assertNull(result);
    }

    @Test
    public void testRightPad_ZeroPadding() {
        String result = StringUtils.rightPad("test", 4, '*');
        assertEquals("test", result);
    }

    @Test
    public void testRightPad_ExactPadding() {
        String result = StringUtils.rightPad("test", 8, '*');
        assertEquals("test****", result);
    }

    @Test
    public void testRightPad_ExceedingPadLimit() {
        String result = StringUtils.rightPad("test", 8200, '*');
        assertEquals("test" + repeat('*', 8196), result);
    }

    @Test
    public void testRightPad_SingleCharacterPadding() {
        String result = StringUtils.rightPad("test", 6, '*');
        assertEquals("test**", result);
    }

    @Test
    public void testRightPad_MultipleCharacterPadding() {
        String result = StringUtils.rightPad("test", 10, 'a');
        assertEquals("testaaaaaa", result);
    }

    @Test
    public void testRightPad_EmptyString() {
        String result = StringUtils.rightPad("", 5, '*');
        assertEquals("*****", result);
    }

    @Test
    public void testRightPad_PaddingWithEmptyChar() {
        String result = StringUtils.rightPad("test", 8, ' ');
        assertEquals("test    ", result);
    }

    @Test
    public void testRightPad_NegativePadding() {
        String result = StringUtils.rightPad("test", -1, '*');
        assertEquals("test", result);
    }

    @Test
    public void testRightPad_SpacePadding() {
        String result = StringUtils.rightPad("test", 10, ' ');
        assertEquals("test      ", result);
    }

    @Test
    public void testRightPad_EmptyPadString() {
        String result = StringUtils.rightPad("test", 10, ' ');
        assertEquals("test      ", result);
    }

    private static String repeat(char ch, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
