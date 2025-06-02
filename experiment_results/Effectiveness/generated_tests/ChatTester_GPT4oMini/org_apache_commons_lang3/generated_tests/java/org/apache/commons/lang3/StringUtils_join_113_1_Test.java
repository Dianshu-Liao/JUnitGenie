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

public class StringUtils_join_113_1_Test {

    @Test
    public void testJoin_ValidInput() {
        Object[] array = { "Hello", "World", "Test" };
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 3;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("Hello,World,Test", result);
    }

    @Test
    public void testJoin_EmptyArray() {
        Object[] array = {};
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 0;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("", result);
    }

    @Test
    public void testJoin_SingleElement() {
        Object[] array = { "OnlyOne" };
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 1;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("OnlyOne", result);
    }

    @Test
    public void testJoin_NegativeStartIndex() {
        Object[] array = { "A", "B", "C" };
        char delimiter = ',';
        int startIndex = -1;
        int endIndex = 3;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_EndIndexGreaterThanArrayLength() {
        Object[] array = { "A", "B", "C" };
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 5;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("A,B,C", result);
    }

    @Test
    public void testJoin_OnlyDelimiter() {
        Object[] array = { null, null, null };
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 3;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(",,,", result);
    }

    @Test
    public void testJoin_EmptyStringElements() {
        Object[] array = { "", "", "" };
        char delimiter = ',';
        int startIndex = 0;
        int endIndex = 3;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals(",,", result);
    }

    @Test
    public void testJoin_NonStringElements() {
        Object[] array = { 1, 2, 3 };
        char delimiter = '-';
        int startIndex = 0;
        int endIndex = 3;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("1-2-3", result);
    }

    @Test
    public void testJoin_MixedElements() {
        Object[] array = { "Hello", null, "World", 123 };
        char delimiter = '|';
        int startIndex = 0;
        int endIndex = 4;
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
        assertEquals("Hello|null|World|123", result);
    }
}
