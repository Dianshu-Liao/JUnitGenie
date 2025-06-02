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

public class StringUtils_stripStart_205_0_Test {

    @Test
    public void testStripStart_NullString() {
        String result = StringUtils.stripStart(null, null);
        assertNull(result);
    }

    @Test
    public void testStripStart_EmptyString() {
        String result = StringUtils.stripStart("", null);
        assertEquals("", result);
    }

    @Test
    public void testStripStart_OnlyWhitespace() {
        String result = StringUtils.stripStart("   ", null);
        assertEquals("", result);
    }

    @Test
    public void testStripStart_LeadingWhitespace() {
        String result = StringUtils.stripStart("   Hello", null);
        assertEquals("Hello", result);
    }

    @Test
    public void testStripStart_LeadingCustomChars() {
        String result = StringUtils.stripStart("###Hello", "#");
        assertEquals("Hello", result);
    }

    @Test
    public void testStripStart_LeadingMixedChars() {
        String result = StringUtils.stripStart("###   Hello", "# ");
        assertEquals("Hello", result);
    }

    @Test
    public void testStripStart_NoStripChars() {
        String result = StringUtils.stripStart("Hello", null);
        assertEquals("Hello", result);
    }

    @Test
    public void testStripStart_EmptyStripChars() {
        String result = StringUtils.stripStart("Hello", "");
        assertEquals("Hello", result);
    }

    @Test
    public void testStripStart_NonLeadingChars() {
        String result = StringUtils.stripStart("Hello###", "#");
        assertEquals("Hello###", result);
    }

    @Test
    public void testStripStart_AllStripChars() {
        String result = StringUtils.stripStart("###", "#");
        assertEquals("", result);
    }
}
