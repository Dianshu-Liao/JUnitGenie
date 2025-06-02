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

public class StringUtils_join_112_0_Test {

    @Test
    public void testJoin_NullArray() {
        String result = StringUtils.join((Object[]) null, ',');
        assertNull(result, "Joining a null array should return null.");
    }

    @Test
    public void testJoin_EmptyArray() {
        String result = StringUtils.join(new Object[] {}, ',');
        assertEquals("", result, "Joining an empty array should return an empty string.");
    }

    @Test
    public void testJoin_SingleElement() {
        String result = StringUtils.join(new Object[] { "Hello" }, ',');
        assertEquals("Hello", result, "Joining an array with a single element should return that element.");
    }

    @Test
    public void testJoin_MultipleElements() {
        String result = StringUtils.join(new Object[] { "Hello", "World" }, ',');
        assertEquals("Hello,World", result, "Joining multiple elements should return them separated by the delimiter.");
    }

    @Test
    public void testJoin_NonStringElements() {
        String result = StringUtils.join(new Object[] { 1, 2, 3 }, ',');
        assertEquals("1,2,3", result, "Joining non-string elements should convert them to strings.");
    }

    @Test
    public void testJoin_WithNullElements() {
        String result = StringUtils.join(new Object[] { "Hello", null, "World" }, ',');
        assertEquals("Hello,null,World", result, "Joining an array with null elements should treat them as 'null'.");
    }

    @Test
    public void testJoin_WhitespaceDelimiter() {
        String result = StringUtils.join(new Object[] { "Hello", "World" }, ' ');
        assertEquals("Hello World", result, "Joining with whitespace as a delimiter should separate words with a space.");
    }

    @Test
    public void testJoin_EmptyStringDelimiter() {
        String result = StringUtils.join(new Object[] { "Hello", "World" }, '\0');
        assertEquals("HelloWorld", result, "Joining with an empty delimiter should concatenate without spaces.");
    }
}
