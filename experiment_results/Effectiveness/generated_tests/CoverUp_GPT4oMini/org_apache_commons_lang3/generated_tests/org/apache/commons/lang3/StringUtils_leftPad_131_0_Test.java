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

class StringUtils_leftPad_131_0_Test {

    @Test
    void testLeftPad_NullString() {
        assertNull(StringUtils.leftPad(null, 5, '*'));
    }

    @Test
    void testLeftPad_EmptyPadStr() {
        assertEquals("     ", StringUtils.leftPad("test", 5, ""));
    }

    @Test
    void testLeftPad_PadLengthGreaterThanStringLength() {
        assertEquals("****test", StringUtils.leftPad("test", 8, "*"));
    }

    @Test
    void testLeftPad_PadLengthEqualToStringLength() {
        assertEquals("test", StringUtils.leftPad("test", 4, "*"));
    }

    @Test
    void testLeftPad_PadLengthLessThanStringLength() {
        assertEquals("test", StringUtils.leftPad("test", 3, "*"));
    }

    @Test
    void testLeftPad_PadStrShorterThanPads() {
        assertEquals("abtest", StringUtils.leftPad("test", 6, "ab"));
    }

    @Test
    void testLeftPad_PadStrEqualToPads() {
        assertEquals("test", StringUtils.leftPad("test", 4, "abc"));
    }

    @Test
    void testLeftPad_PadStrLongerThanPads() {
        assertEquals("abc", StringUtils.leftPad("", 3, "abc"));
    }

    @Test
    void testLeftPad_SingleCharacterPad() {
        assertEquals("****test", StringUtils.leftPad("test", 8, "*"));
    }

    @Test
    void testLeftPad_PadLimitExceeds() {
        assertEquals("********test", StringUtils.leftPad("test", 12, "ab"));
    }
}
