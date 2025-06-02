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

class StringUtils_wrapIfMissing_240_0_Test {

    @Test
    void testWrapIfMissing_NullString() {
        assertNull(StringUtils.wrapIfMissing(null, "wrap"));
    }

    @Test
    void testWrapIfMissing_EmptyString() {
        assertEquals("", StringUtils.wrapIfMissing("", "wrap"));
    }

    @Test
    void testWrapIfMissing_NullWrap() {
        assertEquals("test", StringUtils.wrapIfMissing("test", null));
    }

    @Test
    void testWrapIfMissing_EmptyWrap() {
        assertEquals("test", StringUtils.wrapIfMissing("test", ""));
    }

    @Test
    void testWrapIfMissing_NoWrapNeeded() {
        assertEquals("test", StringUtils.wrapIfMissing("test", "wrap"));
    }

    @Test
    void testWrapIfMissing_WrapStartOnly() {
        assertEquals("wraptest", StringUtils.wrapIfMissing("test", "wrap"));
    }

    @Test
    void testWrapIfMissing_WrapEndOnly() {
        assertEquals("testwrap", StringUtils.wrapIfMissing("test", "wrap"));
    }

    @Test
    void testWrapIfMissing_WrapBoth() {
        assertEquals("wraptestwrap", StringUtils.wrapIfMissing("test", "wrap"));
    }
}
