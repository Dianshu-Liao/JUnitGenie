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
        int result = StringUtils.lastIndexOf(null, 'a', 10);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptySequence() {
        int result = StringUtils.lastIndexOf(StringUtils.EMPTY, 'a', 10);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterNotFound() {
        String sequence = "hello world";
        int result = StringUtils.lastIndexOf(sequence, 'x', 10);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterFound() {
        String sequence = "hello world";
        int result = StringUtils.lastIndexOf(sequence, 'o', 10);
        assertEquals(7, result);
    }

    @Test
    public void testLastIndexOf_StartPosOutOfBounds() {
        String sequence = "hello world";
        int result = StringUtils.lastIndexOf(sequence, 'o', 20);
        // Should still find 'o' at index 7
        assertEquals(7, result);
    }

    @Test
    public void testLastIndexOf_NegativeStartPos() {
        String sequence = "hello world";
        int result = StringUtils.lastIndexOf(sequence, 'o', -1);
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }
}
