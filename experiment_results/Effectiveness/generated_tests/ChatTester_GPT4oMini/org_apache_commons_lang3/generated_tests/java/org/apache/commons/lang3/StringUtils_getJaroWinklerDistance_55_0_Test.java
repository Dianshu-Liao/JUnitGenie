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

public class StringUtils_getJaroWinklerDistance_55_0_Test {

    @Test
    public void testGetJaroWinklerDistance_NullFirstString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance(null, "test");
        });
        assertEquals("Strings must not be null", exception.getMessage());
    }

    @Test
    public void testGetJaroWinklerDistance_NullSecondString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance("test", null);
        });
        assertEquals("Strings must not be null", exception.getMessage());
    }

    @Test
    public void testGetJaroWinklerDistance_EmptyStrings() {
        double result = StringUtils.getJaroWinklerDistance("", "");
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
        assertEquals(0.8, result);
    }

    @Test
    public void testGetJaroWinklerDistance_VeryDifferentStrings() {
        double result = StringUtils.getJaroWinklerDistance("test", "xyz");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_SimilarStrings() {
        double result = StringUtils.getJaroWinklerDistance("dixon", "dicksonx");
        assertEquals(0.8133333, result, 0.0001);
    }

    @Test
    public void testGetJaroWinklerDistance_ScalingFactorApplication() {
        double result = StringUtils.getJaroWinklerDistance("hello", "hallo");
        assertEquals(0.96, result, 0.01);
    }
}
