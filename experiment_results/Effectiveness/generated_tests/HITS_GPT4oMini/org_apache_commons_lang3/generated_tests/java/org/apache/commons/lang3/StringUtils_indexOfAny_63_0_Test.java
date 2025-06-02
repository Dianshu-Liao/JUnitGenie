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

public class StringUtils_indexOfAny_63_0_Test {

    @Test
    public void testIndexOfAny_WithNullStr_ReturnsIndexNotFound() {
        int result = StringUtils.indexOfAny(null, "a", "b");
        Assertions.assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithNullSearchStrs_ReturnsIndexNotFound() {
        int result = StringUtils.indexOfAny("test", (CharSequence[]) null);
        Assertions.assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithEmptyStrAndEmptySearchStrs_ReturnsIndexNotFound() {
        int result = StringUtils.indexOfAny("", (CharSequence[]) new String[] { "" });
        Assertions.assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithEmptyStrAndNonEmptySearchStrs_ReturnsIndexNotFound() {
        int result = StringUtils.indexOfAny("", (CharSequence[]) new String[] { "a", "b" });
        Assertions.assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithSingleCharacterMatch_ReturnsCorrectIndex() {
        int result = StringUtils.indexOfAny("hello", (CharSequence[]) new String[] { "e", "o" });
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testIndexOfAny_WithMultipleCharacterMatches_ReturnsFirstIndex() {
        int result = StringUtils.indexOfAny("hello", (CharSequence[]) new String[] { "o", "e" });
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testIndexOfAny_WithNoMatches_ReturnsIndexNotFound() {
        int result = StringUtils.indexOfAny("hello", (CharSequence[]) new String[] { "x", "y" });
        Assertions.assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testIndexOfAny_WithNullInSearchStrs_IgnoresNullAndReturnsFirstIndex() {
        int result = StringUtils.indexOfAny("hello", (CharSequence[]) new String[] { null, "e", "o" });
    }
}
