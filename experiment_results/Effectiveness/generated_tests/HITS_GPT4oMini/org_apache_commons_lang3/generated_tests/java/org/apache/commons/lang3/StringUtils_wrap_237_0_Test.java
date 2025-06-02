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

public class StringUtils_wrap_237_0_Test {

    @Test
    public void testWrap_NullString() {
        String result = StringUtils.wrap(null, '*');
        assertEquals(null, result, "Expected result should be null when input string is null.");
    }

    @Test
    public void testWrap_EmptyString() {
        String result = StringUtils.wrap(StringUtils.EMPTY, '*');
        assertEquals(StringUtils.EMPTY, result, "Expected result should be an empty string when input is empty.");
    }

    @Test
    public void testWrap_ValidString_WithChar() {
        String result = StringUtils.wrap("test", '*');
        assertEquals("*test*", result, "Expected result should wrap the string with the specified character.");
    }

    @Test
    public void testWrap_ValidString_WithDifferentChar() {
        String result = StringUtils.wrap("hello", '#');
        assertEquals("#hello#", result, "Expected result should wrap the string with the specified character.");
    }

    @Test
    public void testWrap_NullCharacter() {
        String result = StringUtils.wrap("test", '\0');
        assertEquals("test", result, "Expected result should be the original string when wrap character is null character.");
    }

    @Test
    public void testWrap_ValidString_WithSpace() {
        String result = StringUtils.wrap("example", ' ');
        assertEquals(" example ", result, "Expected result should wrap the string with a space character.");
    }
}
