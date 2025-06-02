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

public class StringUtils_getJaroWinklerDistance_55_0_Test {

    @Test
    public void testGetJaroWinklerDistance_BothStringsAreNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance(null, null);
        });
    }

    @Test
    public void testGetJaroWinklerDistance_FirstStringIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance(null, "test");
        });
    }

    @Test
    public void testGetJaroWinklerDistance_SecondStringIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance("test", null);
        });
    }

    @Test
    public void testGetJaroWinklerDistance_EmptyStrings() {
        double result = StringUtils.getJaroWinklerDistance("", "");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_OneEmptyString() {
        double result = StringUtils.getJaroWinklerDistance("test", "");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_SameStrings() {
        double result = StringUtils.getJaroWinklerDistance("test", "test");
        assertEquals(1.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_DifferentStrings() {
        double result = StringUtils.getJaroWinklerDistance("test", "best");
        assertEquals(0.9333, result, 0.0001);
    }

    @Test
    public void testGetJaroWinklerDistance_SimilarStrings() {
        double result = StringUtils.getJaroWinklerDistance("hello", "hallo");
        assertEquals(0.8667, result, 0.0001);
    }

    @Test
    public void testGetJaroWinklerDistance_VeryDifferentStrings() {
        double result = StringUtils.getJaroWinklerDistance("abc", "xyz");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_PrefixScalingEffect() {
        double result = StringUtils.getJaroWinklerDistance("hello", "hell");
        assertEquals(1.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_VaryingLengths() {
        double result = StringUtils.getJaroWinklerDistance("short", "longer");
        assertEquals(0.5, result, 0.0001);
    }
}
