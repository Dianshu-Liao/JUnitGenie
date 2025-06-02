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

public class StringUtils_leftPad_131_0_Test {

    @Test
    public void testLeftPad_NullString() {
        assertNull(StringUtils.leftPad(null, 5, "*"));
    }

    @Test
    public void testLeftPad_EmptyPadString() {
        assertEquals("     ", StringUtils.leftPad("test", 5, ""));
    }

    @Test
    public void testLeftPad_StringLongerThanSize() {
        assertEquals("test", StringUtils.leftPad("test", 2, "*"));
    }

    @Test
    public void testLeftPad_SingleCharPad() {
        assertEquals("*****test", StringUtils.leftPad("test", 10, "*"));
    }

    @Test
    public void testLeftPad_PadStringExactlyMatches() {
        assertEquals("pads", StringUtils.leftPad("pads", 4, "pad"));
    }

    @Test
    public void testLeftPad_PadStringLongerThanNeeded() {
        assertEquals("xxxtest", StringUtils.leftPad("test", 7, "xxx"));
    }

    @Test
    public void testLeftPad_PadStringShorterThanNeeded() {
        assertEquals("xxxtest", StringUtils.leftPad("test", 7, "x"));
    }

    @Test
    public void testLeftPad_PadStringWithMultipleChars() {
    }
}
