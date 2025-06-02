package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
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

public class StringUtils_containsAny_20_0_Test {

    @Test
    public void testContainsAny_NullCharSequence() {
        assertFalse(StringUtils.containsAny(null, 'a', 'b'));
    }

    @Test
    public void testContainsAny_EmptyCharSequence() {
        assertFalse(StringUtils.containsAny("", 'a', 'b'));
    }

    @Test
    public void testContainsAny_EmptySearchChars() {
        assertFalse(StringUtils.containsAny("abc", new char[] {}));
    }

    @Test
    public void testContainsAny_NoMatch() {
        assertFalse(StringUtils.containsAny("abc", 'd', 'e', 'f'));
    }

    @Test
    public void testContainsAny_OneMatch() {
        assertTrue(StringUtils.containsAny("abc", 'a', 'd', 'e'));
    }

    @Test
    public void testContainsAny_MultipleMatches() {
        assertTrue(StringUtils.containsAny("abc", 'a', 'b', 'c'));
    }

    @Test
    public void testContainsAny_SurrogatePairMatch() {
        // Smiley face surrogate pair
        assertTrue(StringUtils.containsAny("\uD83D\uDE00", '\uD83D', '\uDE00'));
    }

    @Test
    public void testContainsAny_SurrogatePairNoMatch() {
        // No match
        assertFalse(StringUtils.containsAny("\uD83D\uDE00", '\uD83C', '\uDE00'));
    }

    @Test
    public void testContainsAny_MultipleChars() {
        assertTrue(StringUtils.containsAny("hello world", 'h', 'w', 'x'));
    }

    @Test
    public void testContainsAny_Whitespace() {
        assertTrue(StringUtils.containsAny("hello world", ' '));
    }

    @Test
    public void testContainsAny_SpecialCharacters() {
        assertTrue(StringUtils.containsAny("hello@world", '@', '#', '$'));
    }

    // Testing private method via reflection
    @Test
    public void testPrivateMethod() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("containsAny", CharSequence.class, char[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null, "abc", new char[] { 'a', 'b' });
        assertTrue(result);
    }
}
