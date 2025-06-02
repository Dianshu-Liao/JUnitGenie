package org.apache.commons.lang3;

import java.lang.reflect.Method;
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
        assertNull(result);
    }

    @Test
    public void testWrapIfMissing_EmptyString() {
        String result = StringUtils.wrapIfMissing(StringUtils.EMPTY, '*');
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testWrapIfMissing_NullCharacter() {
        String result = StringUtils.wrapIfMissing("test", '\0');
        assertEquals("test", result);
    }

    @Test
    public void testWrapIfMissing_NoWrapNeeded() {
        String result = StringUtils.wrapIfMissing("*test*", '*');
        assertEquals("*test*", result);
    }

    @Test
    public void testWrapIfMissing_WrapStartOnly() {
        String result = StringUtils.wrapIfMissing("test", '*');
        assertEquals("*test*", result);
    }

    @Test
    public void testWrapIfMissing_WrapEndOnly() {
        String result = StringUtils.wrapIfMissing("test", '*');
        assertEquals("test*", result);
    }

    @Test
    public void testWrapIfMissing_WrapBoth() {
        String result = StringUtils.wrapIfMissing("test", '*');
        assertEquals("*test*", result);
    }

    @Test
    public void testWrapIfMissing_WrapBothDifferentChar() {
        String result = StringUtils.wrapIfMissing("test", '#');
        assertEquals("#test#", result);
    }

    @Test
    public void testWrapIfMissing_SingleCharacter() {
        String result = StringUtils.wrapIfMissing("a", '*');
        assertEquals("*a*", result);
    }

    @Test
    public void testWrapIfMissing_AlreadyWrapped() {
        String result = StringUtils.wrapIfMissing("*", '*');
        assertEquals("*", result);
    }
}
