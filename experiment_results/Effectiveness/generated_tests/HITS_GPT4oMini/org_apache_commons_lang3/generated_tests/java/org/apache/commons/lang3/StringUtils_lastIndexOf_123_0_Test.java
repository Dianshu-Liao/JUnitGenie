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

public class StringUtils_lastIndexOf_123_0_Test {

    @Test
    public void testLastIndexOf_NullSequence() {
        // Test when the sequence is null
        int result = StringUtils.lastIndexOf(null, 'a', 0);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptySequence() {
        // Test when the sequence is empty
        int result = StringUtils.lastIndexOf("", 'a', 0);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterNotFound() {
        // Test when the character is not found in the sequence
        int result = StringUtils.lastIndexOf("hello", 'z', 4);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterFoundAtEnd() {
        // Test when the character is found at the end of the sequence
        int result = StringUtils.lastIndexOf("hello", 'o', 4);
        assertEquals(4, result);
    }

    @Test
    public void testLastIndexOf_CharacterFoundInMiddle() {
        // Test when the character is found in the middle of the sequence
        int result = StringUtils.lastIndexOf("hello", 'l', 4);
        assertEquals(3, result);
    }

    @Test
    public void testLastIndexOf_CharacterFoundAtStart() {
        // Test when the character is found at the start of the sequence
        int result = StringUtils.lastIndexOf("hello", 'h', 4);
        assertEquals(0, result);
    }

    @Test
    public void testLastIndexOf_SearchBeyondLength() {
        // Test when searching beyond the length of the sequence
        int result = StringUtils.lastIndexOf("hello", 'l', 10);
        assertEquals(3, result);
    }

    @Test
    public void testLastIndexOf_NegativeStartPosition() {
        // Test when the start position is negative
        int result = StringUtils.lastIndexOf("hello", 'l', -1);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_ValidInputWithNegativeStartPosition() {
        // Test with valid input but negative start position
        int result = StringUtils.lastIndexOf("hello", 'l', -5);
        assertEquals(3, result);
    }
}
