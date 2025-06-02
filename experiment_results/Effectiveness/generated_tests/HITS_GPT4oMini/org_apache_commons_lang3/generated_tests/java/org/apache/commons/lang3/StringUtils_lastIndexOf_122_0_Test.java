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

public class StringUtils_lastIndexOf_122_0_Test {

    @Test
    public void testLastIndexOf_EmptyString() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("", 'a'));
    }

    @Test
    public void testLastIndexOf_NullSequence() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf(null, 'a'));
    }

    @Test
    public void testLastIndexOf_CharacterNotFound() {
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("hello", 'z'));
    }

    @Test
    public void testLastIndexOf_CharacterFoundAtEnd() {
        assertEquals(4, StringUtils.lastIndexOf("hello", 'o'));
    }

    @Test
    public void testLastIndexOf_CharacterFoundAtStart() {
        assertEquals(0, StringUtils.lastIndexOf("hello", 'h'));
    }

    @Test
    public void testLastIndexOf_CharacterFoundInMiddle() {
        assertEquals(2, StringUtils.lastIndexOf("hello", 'l'));
    }

    @Test
    public void testLastIndexOf_SingleCharacterString() {
        assertEquals(0, StringUtils.lastIndexOf("a", 'a'));
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("a", 'b'));
    }

    @Test
    public void testLastIndexOf_MultipleOccurrences() {
        assertEquals(2, StringUtils.lastIndexOf("banana", 'a'));
        assertEquals(5, StringUtils.lastIndexOf("banana", 'n'));
    }

    @Test
    public void testLastIndexOf_Whitespace() {
        assertEquals(1, StringUtils.lastIndexOf(" hello ", ' '));
        assertEquals(StringUtils.INDEX_NOT_FOUND, StringUtils.lastIndexOf("hello", ' '));
    }
}
