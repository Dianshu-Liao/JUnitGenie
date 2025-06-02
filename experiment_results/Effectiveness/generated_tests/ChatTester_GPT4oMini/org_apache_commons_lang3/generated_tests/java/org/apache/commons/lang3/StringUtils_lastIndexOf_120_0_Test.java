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

public class StringUtils_lastIndexOf_120_0_Test {

    @Test
    public void testLastIndexOf_WithValidInput() {
        // Test case where the search sequence is found in the sequence
        CharSequence seq = "hello world";
        CharSequence searchSeq = "o";
        // Last index of 'o' in "hello world"
        int expected = 7;
        int actual = StringUtils.lastIndexOf(seq, searchSeq);
        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOf_WithSearchSeqNotFound() {
        // Test case where the search sequence is not found
        CharSequence seq = "hello world";
        CharSequence searchSeq = "x";
        // Should return -1
        int expected = StringUtils.INDEX_NOT_FOUND;
        int actual = StringUtils.lastIndexOf(seq, searchSeq);
        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOf_WithEmptySequence() {
        // Test case where the sequence is empty
        CharSequence seq = StringUtils.EMPTY;
        CharSequence searchSeq = "o";
        // Should return -1
        int expected = StringUtils.INDEX_NOT_FOUND;
        int actual = StringUtils.lastIndexOf(seq, searchSeq);
        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOf_WithNullSeq() {
        // Test case where the sequence is null
        CharSequence seq = null;
        CharSequence searchSeq = "o";
        assertThrows(NullPointerException.class, () -> {
            StringUtils.lastIndexOf(seq, searchSeq);
        });
    }

    @Test
    public void testLastIndexOf_WithNullSearchSeq() {
        // Test case where the search sequence is null
        CharSequence seq = "hello world";
        CharSequence searchSeq = null;
        assertThrows(NullPointerException.class, () -> {
            StringUtils.lastIndexOf(seq, searchSeq);
        });
    }
}
