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
    public void testLastIndexOf_ValidInputs() throws Exception {
        // Arrange
        CharSequence seq = "Hello, world! Hello again!";
        CharSequence searchSeq = "Hello";
        int startPos = seq.length();
        // Act
        int result = invokeLastIndexOf(seq, searchSeq, startPos);
        // Assert
        // The last occurrence of "Hello" starts at index 13
        assertEquals(13, result);
    }

    @Test
    public void testLastIndexOf_NoMatch() throws Exception {
        // Arrange
        CharSequence seq = "Hello, world!";
        CharSequence searchSeq = "Goodbye";
        int startPos = seq.length();
        // Act
        int result = invokeLastIndexOf(seq, searchSeq, startPos);
        // Assert
        // Should return -1
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptySequence() throws Exception {
        // Arrange
        CharSequence seq = "";
        CharSequence searchSeq = "Hello";
        int startPos = seq.length();
        // Act
        int result = invokeLastIndexOf(seq, searchSeq, startPos);
        // Assert
        // Should return -1
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptySearchSequence() throws Exception {
        // Arrange
        CharSequence seq = "Hello, world!";
        CharSequence searchSeq = "";
        int startPos = seq.length();
        // Act
        int result = invokeLastIndexOf(seq, searchSeq, startPos);
        // Assert
        // Should return the length of seq
        assertEquals(seq.length(), result);
    }

    @Test
    public void testLastIndexOf_StartPositionOutOfBounds() throws Exception {
        // Arrange
        CharSequence seq = "Hello, world!";
        CharSequence searchSeq = "Hello";
        // Invalid start position
        int startPos = -1;
        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeLastIndexOf(seq, searchSeq, startPos);
        });
    }

    private int invokeLastIndexOf(CharSequence seq, CharSequence searchSeq, int startPos) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, CharSequence.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, seq, searchSeq, startPos);
    }
}
