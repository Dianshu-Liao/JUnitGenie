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

public class StringUtils_lastIndexOf_122_0_Test {

    @Test
    public void testLastIndexOf_NullSequence() {
        int result = StringUtils.lastIndexOf(null, 'a');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptySequence() {
        int result = StringUtils.lastIndexOf(StringUtils.EMPTY, 'a');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterNotFound() {
        int result = StringUtils.lastIndexOf("hello", 'z');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterFoundAtEnd() {
        int result = StringUtils.lastIndexOf("hello", 'o');
        assertEquals(4, result);
    }

    @Test
    public void testLastIndexOf_CharacterFoundAtBeginning() {
        int result = StringUtils.lastIndexOf("banana", 'b');
        assertEquals(0, result);
    }

    @Test
    public void testLastIndexOf_CharacterFoundMultipleTimes() {
        int result = StringUtils.lastIndexOf("banana", 'a');
        assertEquals(5, result);
    }

    // Reflection test for private method isEmpty
    @Test
    public void testIsEmpty() throws Exception {
        Method isEmptyMethod = StringUtils.class.getDeclaredMethod("isEmpty", CharSequence.class);
        isEmptyMethod.setAccessible(true);
        boolean result1 = (boolean) isEmptyMethod.invoke(null, null);
        boolean result2 = (boolean) isEmptyMethod.invoke(null, "");
        boolean result3 = (boolean) isEmptyMethod.invoke(null, "not empty");
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }
}
