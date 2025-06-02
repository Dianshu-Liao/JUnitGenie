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

public class StringUtils_wrapIfMissing_239_0_Test {

    @Test
    public void testWrapIfMissing_NullString() {
        String result = StringUtils.wrapIfMissing(null, '*');
        assertEquals(null, result, "Expected null when input string is null");
    }

    @Test
    public void testWrapIfMissing_EmptyString() {
        String result = StringUtils.wrapIfMissing("", '*');
        assertEquals("", result, "Expected empty string when input string is empty");
    }

    @Test
    public void testWrapIfMissing_NoWrapNeeded() {
        String result = StringUtils.wrapIfMissing("hello", '*');
        assertEquals("hello", result, "Expected the same string when no wrapping is needed");
    }

    @Test
    public void testWrapIfMissing_WrapStartOnly() {
        String result = StringUtils.wrapIfMissing("hello", '*');
        assertEquals("*hello*", result, "Expected string wrapped with '*' on both sides");
    }

    @Test
    public void testWrapIfMissing_WrapEndOnly() {
        String result = StringUtils.wrapIfMissing("hello*", '*');
        assertEquals("hello*", result, "Expected string with '*' at the end only");
    }

    @Test
    public void testWrapIfMissing_WrapBothEnds() {
        String result = StringUtils.wrapIfMissing("*hello", '*');
        assertEquals("*hello*", result, "Expected string wrapped with '*' on both sides");
    }

    @Test
    public void testWrapIfMissing_WrapWithNullCharacter() {
        String result = StringUtils.wrapIfMissing("hello", '\0');
        assertEquals("hello", result, "Expected the same string when wrapWith is null character");
    }

    @Test
    public void testWrapIfMissing_WrapWithDifferentCharacter() {
        String result = StringUtils.wrapIfMissing("hello", '#');
        assertEquals("#hello#", result, "Expected string wrapped with '#' on both sides");
    }
}
