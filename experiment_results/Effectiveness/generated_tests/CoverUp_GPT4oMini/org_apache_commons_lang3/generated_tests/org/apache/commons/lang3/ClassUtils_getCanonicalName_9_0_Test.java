package org.apache.commons.lang3;

import org.apache.commons.lang3.ClassUtils;
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
    public void testGetCanonicalName_WithNullClass_ReturnsValueIfNull() {
        String expected = "defaultValue";
        String actual = ClassUtils.getCanonicalName(null, expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithClass_ReturnsCanonicalName() {
        String expected = "java.lang.String";
        String actual = ClassUtils.getCanonicalName(String.class, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithAnonymousClass_ReturnsCanonicalName() {
        // Assuming this is the name of the anonymous class
        String expected = "ClassUtilsTest$1";
        Class<?> anonymousClass = new Object() {
        }.getClass();
        String actual = ClassUtils.getCanonicalName(anonymousClass, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithLocalClass_ReturnsCanonicalName() {
        // Assuming this is the name of the local class
        String expected = "ClassUtilsTest$LocalClass";
        class LocalClass {
        }
        String actual = ClassUtils.getCanonicalName(LocalClass.class, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithPrimitiveClass_ReturnsCanonicalName() {
        String expected = "int";
        String actual = ClassUtils.getCanonicalName(int.class, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithNullClass_ReturnsNullValueIfNull() {
        String actual = ClassUtils.getCanonicalName(null, null);
        assertEquals(null, actual);
    }
}
