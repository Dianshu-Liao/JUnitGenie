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

class StringUtils_wrap_237_0_Test {

    @Test
    void testWrapWithNonEmptyString() {
        String result = StringUtils.wrap("test", '*');
        assertEquals("*test*", result);
    }

    @Test
    void testWrapWithEmptyString() {
        String result = StringUtils.wrap("", '*');
        assertEquals("", result);
    }

    @Test
    void testWrapWithNullCharacter() {
        String result = StringUtils.wrap("test", '\0');
        assertEquals("test", result);
    }

    @Test
    void testWrapWithSpace() {
        String result = StringUtils.wrap("test", ' ');
        assertEquals(" test ", result);
    }

    @Test
    void testWrapWithSpecialCharacter() {
        String result = StringUtils.wrap("test", '#');
        assertEquals("#test#", result);
    }

    @Test
    void testWrapWithNullString() {
        String result = StringUtils.wrap(null, '*');
        assertEquals(null, result);
    }
}
