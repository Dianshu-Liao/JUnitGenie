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

public class StringUtils_wrap_237_0_Test {

    @Test
    public void testWrap_NullString() {
        String result = StringUtils.wrap(null, '*');
        assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testWrap_EmptyString() {
        String result = StringUtils.wrap(StringUtils.EMPTY, '*');
        assertEquals(StringUtils.EMPTY, result, "Expected empty string when input is empty");
    }

    @Test
    public void testWrap_ValidString() {
        String result = StringUtils.wrap("test", '*');
        assertEquals("*test*", result, "Expected string to be wrapped with '*'");
    }

    @Test
    public void testWrap_WithNullCharacter() {
        String result = StringUtils.wrap("test", '\0');
        assertEquals("test", result, "Expected no wrapping when wrapWith is null character");
    }

    @Test
    public void testWrap_WithDifferentCharacter() {
        String result = StringUtils.wrap("hello", '#');
        assertEquals("#hello#", result, "Expected string to be wrapped with '#'");
    }

    @Test
    public void testWrap_CharacterIsSpace() {
        String result = StringUtils.wrap("world", ' ');
        assertEquals(" world ", result, "Expected string to be wrapped with space");
    }

    @Test
    public void testWrap_CharacterIsSpecial() {
        String result = StringUtils.wrap("test", '@');
        assertEquals("@test@", result, "Expected string to be wrapped with '@'");
    }

    // Reflection test for private method (if needed)
    @Test
    public void testPrivateMethodUsingReflection() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("wrap", String.class, char.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, "test", '*');
        assertEquals("*test*", result, "Expected string to be wrapped with '*' using reflection");
    }
}
