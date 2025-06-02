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

public class ClassUtils_getCanonicalName_11_0_Test {

    @Test
    public void testGetCanonicalName_NullObject_ReturnsValueIfNull() {
        String expected = "defaultValue";
        String actual = ClassUtils.getCanonicalName(null, expected);
        assertEquals(expected, actual, "Expected to return the provided value if the object is null.");
    }

    @Test
    public void testGetCanonicalName_ObjectWithCanonicalName_ReturnsCanonicalName() {
        TestClass testObject = new TestClass();
        String expected = "org.apache.commons.lang3.ClassUtils_Test$TestClass";
        String actual = ClassUtils.getCanonicalName(testObject, "defaultValue");
        assertEquals(expected, actual, "Expected to return the canonical name of the object.");
    }

    @Test
    public void testGetCanonicalName_ObjectWithoutCanonicalName_ReturnsValueIfNull() {
        // Anonymous class with no canonical name
        Object anonymousObject = new Object() {
        };
        String expected = "defaultValue";
        String actual = ClassUtils.getCanonicalName(anonymousObject, expected);
        assertEquals(expected, actual, "Expected to return the provided value if the object's canonical name is null.");
    }

    private static class TestClass {
        // This is a simple test class for testing purposes
    }
}
