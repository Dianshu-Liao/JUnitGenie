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

public class StringUtils_lastIndexOf_121_0_Test {

    @Test
    public void testLastIndexOf_WithValidInputs() throws Exception {
        CharSequence seq = "Hello World";
        CharSequence searchSeq = "o";
        int startPos = 10;
        // Invoke the method using reflection
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, seq, searchSeq, startPos);
        // 'o' is at index 7
        assertEquals(7, result);
    }

    @Test
    public void testLastIndexOf_WithSearchSequenceNotFound() throws Exception {
        CharSequence seq = "Hello World";
        CharSequence searchSeq = "x";
        int startPos = 10;
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, seq, searchSeq, startPos);
        // 'x' not found
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_WithNegativeStartPos() throws Exception {
        CharSequence seq = "Hello World";
        CharSequence searchSeq = "o";
        int startPos = -1;
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, seq, searchSeq, startPos);
        // Invalid start position
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_WithEmptySequence() throws Exception {
        CharSequence seq = "";
        CharSequence searchSeq = "o";
        int startPos = 0;
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, seq, searchSeq, startPos);
        // Empty sequence
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_WithNullSequence() throws Exception {
        CharSequence seq = null;
        CharSequence searchSeq = "o";
        int startPos = 10;
        // Expecting a NullPointerException
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        assertThrows(NullPointerException.class, () -> {
            method.invoke(null, seq, searchSeq, startPos);
        });
    }

    @Test
    public void testLastIndexOf_WithNullSearchSequence() throws Exception {
        CharSequence seq = "Hello World";
        CharSequence searchSeq = null;
        int startPos = 10;
        // Expecting a NullPointerException
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        assertThrows(NullPointerException.class, () -> {
            method.invoke(null, seq, searchSeq, startPos);
        });
    }
}
