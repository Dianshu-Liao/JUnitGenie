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

public class StringUtils_stripAll_203_0_Test {

    @Test
    public void testStripAll_withNullArray() {
        String[] result = StringUtils.stripAll(null, "stripChars");
        assertArrayEquals(null, result);
    }

    @Test
    public void testStripAll_withEmptyArray() {
        String[] result = StringUtils.stripAll(new String[] {}, "stripChars");
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    public void testStripAll_withSingleElement() {
        String[] result = StringUtils.stripAll(new String[] { "  Hello  " }, " ");
        assertArrayEquals(new String[] { "Hello" }, result);
    }

    @Test
    public void testStripAll_withMultipleElements() {
        String[] result = StringUtils.stripAll(new String[] { "  Hello  ", "  World  " }, " ");
        assertArrayEquals(new String[] { "Hello", "World" }, result);
    }

    @Test
    public void testStripAll_withNoStripChars() {
        String[] result = StringUtils.stripAll(new String[] { "Hello", "World" }, "");
        assertArrayEquals(new String[] { "Hello", "World" }, result);
    }

    @Test
    public void testStripAll_withAllStripChars() {
        String[] result = StringUtils.stripAll(new String[] { "!!!Hello!!!", "!!!World!!!" }, "!");
        assertArrayEquals(new String[] { "Hello", "World" }, result);
    }

    @Test
    public void testStripAll_withNullStripChars() {
        String[] result = StringUtils.stripAll(new String[] { "  Hello  ", "  World  " }, null);
        assertArrayEquals(new String[] { "Hello", "World" }, result);
    }

    @Test
    public void testStripAll_withMixedStripChars() {
        String[] result = StringUtils.stripAll(new String[] { "*Hello*", "#World#" }, "*#");
        assertArrayEquals(new String[] { "Hello", "World" }, result);
    }

    @Test
    public void testStripAll_withSpecialCharacters() {
        String[] result = StringUtils.stripAll(new String[] { "@Hello@", "$World$" }, "@$");
        assertArrayEquals(new String[] { "Hello", "World" }, result);
    }
}
