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

public class StringUtils_isMixedCase_84_0_Test {

    @Test
    public void testIsMixedCase_EmptyString() {
        assertFalse(StringUtils.isMixedCase(StringUtils.EMPTY));
    }

    @Test
    public void testIsMixedCase_SingleCharacterLowercase() {
        assertFalse(StringUtils.isMixedCase("a"));
    }

    @Test
    public void testIsMixedCase_SingleCharacterUppercase() {
        assertFalse(StringUtils.isMixedCase("A"));
    }

    @Test
    public void testIsMixedCase_AllLowercase() {
        assertFalse(StringUtils.isMixedCase("abc"));
    }

    @Test
    public void testIsMixedCase_AllUppercase() {
        assertFalse(StringUtils.isMixedCase("ABC"));
    }

    @Test
    public void testIsMixedCase_MixedCase() {
        assertTrue(StringUtils.isMixedCase("aBc"));
    }

    @Test
    public void testIsMixedCase_MixedCaseWithNumbers() {
        assertTrue(StringUtils.isMixedCase("a1B2"));
    }

    @Test
    public void testIsMixedCase_SpecialCharacters() {
        assertTrue(StringUtils.isMixedCase("a@B#"));
    }

    @Test
    public void testIsMixedCase_NumbersOnly() {
        assertFalse(StringUtils.isMixedCase("12345"));
    }

    @Test
    public void testIsMixedCase_NullInput() {
        assertFalse(StringUtils.isMixedCase(null));
    }

    @Test
    public void testIsMixedCase_Whitespace() {
        assertFalse(StringUtils.isMixedCase("   "));
    }
}
