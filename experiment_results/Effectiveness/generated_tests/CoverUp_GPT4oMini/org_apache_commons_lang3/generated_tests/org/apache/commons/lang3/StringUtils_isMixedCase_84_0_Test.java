package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
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

public class StringUtils_isMixedCase_84_0_Test {

    @Test
    public void testIsMixedCase_withNull() {
        assertFalse(StringUtils.isMixedCase(null));
    }

    @Test
    public void testIsMixedCase_withEmptyString() {
        assertFalse(StringUtils.isMixedCase(StringUtils.EMPTY));
    }

    @Test
    public void testIsMixedCase_withSingleCharacterLowercase() {
        assertFalse(StringUtils.isMixedCase("a"));
    }

    @Test
    public void testIsMixedCase_withSingleCharacterUppercase() {
        assertFalse(StringUtils.isMixedCase("A"));
    }

    @Test
    public void testIsMixedCase_withAllLowercase() {
        assertFalse(StringUtils.isMixedCase("lowercase"));
    }

    @Test
    public void testIsMixedCase_withAllUppercase() {
        assertFalse(StringUtils.isMixedCase("UPPERCASE"));
    }

    @Test
    public void testIsMixedCase_withMixedCase() {
        assertTrue(StringUtils.isMixedCase("MixedCase"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseWithNumbers() {
        assertTrue(StringUtils.isMixedCase("Mixed123"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseWithSpecialCharacters() {
        assertTrue(StringUtils.isMixedCase("Mixed!@#"));
    }

    @Test
    public void testIsMixedCase_withAllSameCaseCharacters() {
        assertFalse(StringUtils.isMixedCase("AAAAA"));
        assertFalse(StringUtils.isMixedCase("aaaaa"));
    }

    @Test
    public void testIsMixedCase_withSpaces() {
        assertTrue(StringUtils.isMixedCase("Mixed Case"));
        assertFalse(StringUtils.isMixedCase("    "));
    }
}
