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

public class StringUtils_lastIndexOf_121_0_Test {

    @Test
    public void testLastIndexOf_ValidInputs() {
        CharSequence seq = "hello world";
        CharSequence searchSeq = "o";
        int startPos = 10;
        // Last index of 'o' before position 10
        int expected = 7;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_EmptySearchSeq() {
        CharSequence seq = "hello world";
        CharSequence searchSeq = "";
        int startPos = 10;
        // Empty search sequence should return startPos
        int expected = 10;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_NegativeStartPos() {
        CharSequence seq = "hello world";
        CharSequence searchSeq = "o";
        int startPos = -1;
        // Negative start position should return -1
        int expected = -1;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_SearchNotFound() {
        CharSequence seq = "hello world";
        CharSequence searchSeq = "x";
        int startPos = 10;
        // Search sequence not found
        int expected = -1;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_SearchAtStartPos() {
        CharSequence seq = "hello world";
        CharSequence searchSeq = "d";
        int startPos = 10;
        // Search sequence found at startPos
        int expected = 10;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_SearchBeforeStartPos() {
        CharSequence seq = "hello world";
        CharSequence searchSeq = "l";
        int startPos = 5;
        // Last index of 'l' before position 5
        int expected = 3;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_WholeStringSearch() {
        CharSequence seq = "hello";
        CharSequence searchSeq = "hello";
        int startPos = 4;
        // Whole string found at index 0
        int expected = 0;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }

    @Test
    public void testLastIndexOf_EmptyString() {
        CharSequence seq = "";
        CharSequence searchSeq = "a";
        int startPos = 0;
        // Search in empty string should return -1
        int expected = -1;
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
        assertEquals(expected, result);
    }
}
