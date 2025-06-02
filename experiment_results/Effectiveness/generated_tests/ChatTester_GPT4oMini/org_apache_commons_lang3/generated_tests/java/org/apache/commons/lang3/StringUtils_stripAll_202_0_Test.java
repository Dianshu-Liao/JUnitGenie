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

class StringUtils_stripAll_202_0_Test {

    @Test
    void testStripAll_withNullInput() {
        String[] result = StringUtils.stripAll(null);
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    void testStripAll_withEmptyArray() {
        String[] result = StringUtils.stripAll(new String[] {});
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    void testStripAll_withSingleEmptyString() {
        String[] result = StringUtils.stripAll(new String[] { "" });
        assertArrayEquals(new String[] { "" }, result);
    }

    @Test
    void testStripAll_withSingleNonEmptyString() {
        String[] result = StringUtils.stripAll(new String[] { "Hello" });
        assertArrayEquals(new String[] { "Hello" }, result);
    }

    @Test
    void testStripAll_withMultipleStrings() {
        String[] result = StringUtils.stripAll(new String[] { " Hello ", " World ", " " });
        assertArrayEquals(new String[] { "Hello", "World", "" }, result);
    }

    @Test
    void testStripAll_withStringsContainingAccents() {
        String[] result = StringUtils.stripAll(new String[] { "Café", " résumé " });
        assertArrayEquals(new String[] { "Cafe", "resume" }, result);
    }

    @Test
    void testStripAll_withNullStringsInArray() {
        String[] result = StringUtils.stripAll(new String[] { "Hello", null, "World" });
        assertArrayEquals(new String[] { "Hello", null, "World" }, result);
    }
}
