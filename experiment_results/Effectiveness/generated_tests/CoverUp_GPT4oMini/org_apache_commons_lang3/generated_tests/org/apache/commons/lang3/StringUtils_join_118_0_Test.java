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

class StringUtils_join_118_0_Test {

    @Test
    void testJoinWithNullArray() {
        String result = StringUtils.join((String[]) null);
        assertEquals("", result);
    }

    @Test
    void testJoinWithEmptyArray() {
        String result = StringUtils.join(new String[] {});
        assertEquals("", result);
    }

    @Test
    void testJoinWithSingleElement() {
        String result = StringUtils.join("Hello");
        assertEquals("Hello", result);
    }

    @Test
    void testJoinWithMultipleElements() {
        String result = StringUtils.join("Hello", "World", "!");
        assertEquals("HelloWorld!", result);
    }

    @Test
    void testJoinWithNullElement() {
        String result = StringUtils.join("Hello", null, "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    void testJoinWithAllNullElements() {
        String result = StringUtils.join((String) null, (String) null);
        assertEquals("", result);
    }

    @Test
    void testJoinWithMixedElements() {
        String result = StringUtils.join("Hello", 123, "World");
        assertEquals("Hello123World", result);
    }
}
