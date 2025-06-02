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

class StringUtils_joinWith_119_0_Test {

    @Test
    void testJoinWith_NullArray_ThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.joinWith(";", null);
        });
        assertEquals("Object varargs must not be null", exception.getMessage());
    }

    @Test
    void testJoinWith_EmptyArray_ReturnsEmptyString() {
        String result = StringUtils.joinWith(";", new Object[] {});
        assertEquals("", result);
    }

    @Test
    void testJoinWith_SingleElementArray_ReturnsElement() {
        String result = StringUtils.joinWith(",", new Object[] { "element" });
        assertEquals("element", result);
    }

    @Test
    void testJoinWith_MultipleElements_ReturnsJoinedString() {
        String result = StringUtils.joinWith(";", new Object[] { "one", "two", "three" });
        assertEquals("one;two;three", result);
    }

    @Test
    void testJoinWith_NullElementInArray_ReturnsStringWithNull() {
        String result = StringUtils.joinWith(",", new Object[] { "one", null, "three" });
        assertEquals("one,null,three", result);
    }

    @Test
    void testJoinWith_EmptyDelimiter_ReturnsConcatenatedString() {
        String result = StringUtils.joinWith("", new Object[] { "a", "b", "c" });
        assertEquals("abc", result);
    }

    @Test
    void testJoinWith_SpaceDelimiter_ReturnsSpaceSeparatedString() {
        String result = StringUtils.joinWith(" ", new Object[] { "Hello", "World" });
        assertEquals("Hello World", result);
    }

    @Test
    void testJoinWith_SpecialCharacters() {
        String result = StringUtils.joinWith(":", new Object[] { "a", "b", "c" });
        assertEquals("a:b:c", result);
    }
}
