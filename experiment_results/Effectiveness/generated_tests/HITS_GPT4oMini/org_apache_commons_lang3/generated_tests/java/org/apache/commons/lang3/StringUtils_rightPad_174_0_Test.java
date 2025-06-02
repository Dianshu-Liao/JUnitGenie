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

public class StringUtils_rightPad_174_0_Test {

    @Test
    public void testRightPad_NullString() {
        assertNull(StringUtils.rightPad(null, 10));
    }

    @Test
    public void testRightPad_EmptyString() {
        assertEquals("          ", StringUtils.rightPad("", 10));
    }

    @Test
    public void testRightPad_SmallerSize() {
        assertEquals("test", StringUtils.rightPad("test", 2));
    }

    @Test
    public void testRightPad_ExactSize() {
        assertEquals("test", StringUtils.rightPad("test", 4));
    }

    @Test
    public void testRightPad_LargerSize() {
        assertEquals("test      ", StringUtils.rightPad("test", 10));
    }

    @Test
    public void testRightPad_WithSpecialCharacters() {
        assertEquals("!@#$%^&*  ", StringUtils.rightPad("!@#$%^&*", 10));
    }

    @Test
    public void testRightPad_WithPadCharacter() {
        assertEquals("testxx", StringUtils.rightPad("test", 6, 'x'));
    }

    @Test
    public void testRightPad_WithLargeSize() {
        String result = StringUtils.rightPad("test", 8192);
        assertEquals(8192, result.length());
        assertEquals("test" + StringUtils.repeat(' ', 8188), result);
    }
}
