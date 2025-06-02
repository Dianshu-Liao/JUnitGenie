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
    public void testIsNoneBlank_WithNonBlankValues_ShouldReturnTrue() {
        assertTrue(StringUtils.isNoneBlank("Hello", "World", "Java"));
    }

    @Test
    public void testIsNoneBlank_WithEmptyString_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank("Hello", "", "Java"));
    }

    @Test
    public void testIsNoneBlank_WithNullValue_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank("Hello", null, "Java"));
    }

    @Test
    public void testIsNoneBlank_WithAllBlankValues_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank(" ", "", null));
    }

    @Test
    public void testIsNoneBlank_WithMixedValues_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank("Hello", " ", "Java"));
    }

    @Test
    public void testIsNoneBlank_WithEmptyArray_ShouldReturnTrue() {
        assertTrue(StringUtils.isNoneBlank());
    }

    @Test
    public void testIsNoneBlank_WithSingleNonBlankValue_ShouldReturnTrue() {
        assertTrue(StringUtils.isNoneBlank("SingleNonBlank"));
    }

    @Test
    public void testIsNoneBlank_WithMultipleNonBlankValues_ShouldReturnTrue() {
        assertTrue(StringUtils.isNoneBlank("First", "Second", "Third"));
    }

    @Test
    public void testIsNoneBlank_WithSingleBlankValue_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank(" "));
    }

    @Test
    public void testIsNoneBlank_WithAllNullValues_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank(null, null, null));
    }

    @Test
    public void testIsNoneBlank_WithMixedNullAndBlank_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank("Hello", null, " "));
    }
}
