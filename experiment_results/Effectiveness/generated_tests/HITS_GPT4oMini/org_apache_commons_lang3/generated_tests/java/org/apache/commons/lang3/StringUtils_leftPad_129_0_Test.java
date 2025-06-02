package org.apache.commons.lang3;

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

public class StringUtils_leftPad_129_0_Test {

    @Test
    public void testLeftPad_NullString() {
        assertNull(StringUtils.leftPad(null, 10));
    }

    @Test
    public void testLeftPad_ZeroSize() {
        assertEquals("", StringUtils.leftPad("", 0));
    }

    @Test
    public void testLeftPad_ExactSize() {
        assertEquals("test", StringUtils.leftPad("test", 4));
    }

    @Test
    public void testLeftPad_SmallerSize() {
        assertEquals("test", StringUtils.leftPad("test", 2));
    }

    @Test
    public void testLeftPad_LargerSize() {
        assertEquals("    test", StringUtils.leftPad("test", 10));
    }

    @Test
    public void testLeftPad_LargerSizeWithPadChar() {
        assertEquals("****test", StringUtils.leftPad("test", 10, '*'));
    }

    @Test
    public void testLeftPad_ExceedingPadLimit() {
        String input = "test";
        int size = 8200;
        String result = StringUtils.leftPad(input, size);
        assertEquals(repeat(" ", 8196) + "test", result);
    }

    @Test
    public void testLeftPad_NegativeSize() {
        assertEquals("test", StringUtils.leftPad("test", -5));
    }

    @Test
    public void testLeftPad_EmptyString() {
        assertEquals("        ", StringUtils.leftPad("", 8));
    }

    private String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
