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
    public void testGetJaroWinklerDistance_NullFirstString() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance(null, "test");
        });
        Assertions.assertEquals("Strings must not be null", thrown.getMessage());
    }

    @Test
    public void testGetJaroWinklerDistance_NullSecondString() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getJaroWinklerDistance("test", null);
        });
        Assertions.assertEquals("Strings must not be null", thrown.getMessage());
    }

    @Test
    public void testGetJaroWinklerDistance_EmptyStrings() {
        double result = StringUtils.getJaroWinklerDistance("", "");
        Assertions.assertEquals(1.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_IdenticalStrings() {
        double result = StringUtils.getJaroWinklerDistance("test", "test");
        Assertions.assertEquals(1.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_CompletelyDifferentStrings() {
        double result = StringUtils.getJaroWinklerDistance("abc", "def");
        Assertions.assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_SimilarStrings() {
        double result = StringUtils.getJaroWinklerDistance("hello", "hallo");
        Assertions.assertTrue(result > 0.7);
    }

    @Test
    public void testGetJaroWinklerDistance_StringsWithDifferentLengths() {
        double result = StringUtils.getJaroWinklerDistance("short", "longer");
        Assertions.assertTrue(result < 1.0 && result > 0.0);
    }

    @Test
    public void testGetJaroWinklerDistance_PrefixImpact() {
        double result = StringUtils.getJaroWinklerDistance("hello", "hell");
        Assertions.assertTrue(result > 0.8);
    }

    @Test
    public void testGetJaroWinklerDistance_ComplexCase() {
        double result = StringUtils.getJaroWinklerDistance("DWAYNE", "DUANE");
        Assertions.assertEquals(0.84, result, 0.01);
    }
}
