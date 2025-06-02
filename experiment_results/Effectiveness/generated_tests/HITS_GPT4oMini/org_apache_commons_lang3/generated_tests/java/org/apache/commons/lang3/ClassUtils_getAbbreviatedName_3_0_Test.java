// Change this to your actual package name
package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils_getAbbreviatedName_3_0_Test {

    @Test
    public void testGetAbbreviatedName_NullClass() {
        // Test case for null class
        String result = ClassUtils.getAbbreviatedName((Class<?>) null, 5);
        assertEquals("", result, "Expected empty string when class is null");
    }

    @Test
    public void testGetAbbreviatedName_ClassNameShorterThanLengthHint() {
        // Test case for class name shorter than length hint
        String result = ClassUtils.getAbbreviatedName(String.class, 5);
        assertEquals("java.lang.String", result, "Expected full class name when shorter than length hint");
    }

    @Test
    public void testGetAbbreviatedName_ClassNameEqualToLengthHint() {
        // Test case for class name equal to length hint
        String result = ClassUtils.getAbbreviatedName("java.lang.String", 17);
        assertEquals("java.lang.String", result, "Expected full class name when equal to length hint");
    }

    @Test
    public void testGetAbbreviatedName_ClassNameLongerThanLengthHint() {
        // Test case for class name longer than length hint
        String result = ClassUtils.getAbbreviatedName("org.example.MyLongClassName", 10);
        assertEquals("org.example.MyL...", result, "Expected abbreviated class name when longer than length hint");
    }

    @Test
    public void testGetAbbreviatedName_NegativeLengthHint() {
        // Test case for negative length hint
        assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName(String.class, -1);
        }, "Expected IllegalArgumentException for negative length hint");
    }

    @Test
    public void testGetAbbreviatedName_ZeroLengthHint() {
        // Test case for zero length hint
        assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName(String.class, 0);
        }, "Expected IllegalArgumentException for zero length hint");
    }
}
