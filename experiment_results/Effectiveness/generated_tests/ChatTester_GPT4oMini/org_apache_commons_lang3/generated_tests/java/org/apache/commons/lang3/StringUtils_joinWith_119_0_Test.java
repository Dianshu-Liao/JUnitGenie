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

public class StringUtils_joinWith_119_0_Test {

    @Test
    public void testJoinWith_NullArray_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.joinWith(",", null);
        });
        assertEquals("Object varargs must not be null", exception.getMessage());
    }

    @Test
    public void testJoinWith_EmptyArray_ReturnsEmptyString() {
        String result = StringUtils.joinWith(",", new Object[] {});
        assertEquals("", result);
    }

    @Test
    public void testJoinWith_SingleElementArray_ReturnsElementAsString() {
        String result = StringUtils.joinWith(",", new Object[] { "Hello" });
        assertEquals("Hello", result);
    }

    @Test
    public void testJoinWith_MultipleElements_ReturnsJoinedString() {
        String result = StringUtils.joinWith(",", new Object[] { "Hello", "World", "!" });
        assertEquals("Hello,World,!", result);
    }

    @Test
    public void testJoinWith_NullElements_ReturnsStringWithNulls() {
        String result = StringUtils.joinWith(",", new Object[] { "Hello", null, "World" });
        assertEquals("Hello,null,World", result);
    }

    @Test
    public void testJoinWith_EmptyDelimiter_ReturnsConcatenatedString() {
        String result = StringUtils.joinWith("", new Object[] { "Hello", "World" });
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testJoinWith_SpaceDelimiter_ReturnsJoinedStringWithSpaces() {
        String result = StringUtils.joinWith(" ", new Object[] { "Hello", "World" });
        assertEquals("Hello World", result);
    }

    @Test
    public void testJoinWith_SpecialCharacters_ReturnsJoinedString() {
        String result = StringUtils.joinWith(",", new Object[] { "Hello", "@", "#", "$" });
        assertEquals("Hello,@,#,$", result);
    }

    @Test
    public void testJoinWith_NumericElements_ReturnsJoinedString() {
        String result = StringUtils.joinWith(",", new Object[] { 1, 2, 3 });
        assertEquals("1,2,3", result);
    }

    @Test
    public void testJoinWith_MixedTypes_ReturnsJoinedString() {
        String result = StringUtils.joinWith(",", new Object[] { "Hello", 123, true });
        assertEquals("Hello,123,true", result);
    }
}
