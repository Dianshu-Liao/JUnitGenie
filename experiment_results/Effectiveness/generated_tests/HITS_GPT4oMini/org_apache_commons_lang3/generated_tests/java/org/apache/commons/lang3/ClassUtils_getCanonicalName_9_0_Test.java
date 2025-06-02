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

public class ClassUtils_getCanonicalName_9_0_Test {

    @Test
    public void testGetCanonicalName_NullClass_ReturnsValueIfNull() {
        String expected = "defaultValue";
        String result = ClassUtils.getCanonicalName(null, expected);
        assertEquals(expected, result);
    }

    @Test
    public void testGetCanonicalName_ClassWithCanonicalName_ReturnsCanonicalName() {
        String result = ClassUtils.getCanonicalName(String.class, "defaultValue");
        assertEquals("java.lang.String", result);
    }

    @Test
    public void testGetCanonicalName_ClassWithoutCanonicalName_ReturnsValueIfNull() {
        // Array classes do not have a canonical name
        String expected = "defaultValue";
        String result = ClassUtils.getCanonicalName(int[].class, expected);
        assertEquals(expected, result);
    }

    @Test
    public void testGetCanonicalName_PrimitiveClass_ReturnsValueIfNull() {
        String expected = "defaultValue";
        String result = ClassUtils.getCanonicalName(int.class, expected);
        assertEquals(expected, result);
    }

    @Test
    public void testGetCanonicalName_NestedClass_ReturnsCanonicalName() {
        String result = ClassUtils.getCanonicalName(NestedClass.class, "defaultValue");
        assertEquals("org.apache.commons.lang3.ClassUtils_getCanonicalName_9_0_Test$NestedClass", result);
    }

    static class NestedClass {
    }
}
