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

public class StringUtils_isNoneBlank_85_0_Test {

    @Test
    public void testIsNoneBlank_withNonBlankStrings() {
        assertTrue(StringUtils.isNoneBlank("Hello", "World", "JUnit"));
    }

    @Test
    public void testIsNoneBlank_withEmptyString() {
        assertFalse(StringUtils.isNoneBlank("Hello", "", "JUnit"));
    }

    @Test
    public void testIsNoneBlank_withNullString() {
        assertFalse(StringUtils.isNoneBlank("Hello", null, "JUnit"));
    }

    @Test
    public void testIsNoneBlank_withAllBlankStrings() {
        assertFalse(StringUtils.isNoneBlank("", " ", null));
    }

    @Test
    public void testIsNoneBlank_withSingleBlankString() {
        assertFalse(StringUtils.isNoneBlank("Hello", " "));
    }

    @Test
    public void testIsNoneBlank_withMultipleBlankStrings() {
        assertFalse(StringUtils.isNoneBlank(" ", " ", " "));
    }

    @Test
    public void testIsNoneBlank_withNoArguments() {
        assertTrue(StringUtils.isNoneBlank());
    }

    @Test
    public void testIsNoneBlank_withMixedBlankAndNonBlankStrings() {
        assertFalse(StringUtils.isNoneBlank("Hello", " ", "World", null));
    }
}
