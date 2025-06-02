package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_21_1_Test {

    private static class TestClass {

        private String secretMethod(String input) {
            return "Hello, " + input;
        }
    }

    @Test
    void testInvokeMethod_ValidMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "secretMethod", new Object[] { "World" });
        assertEquals("Hello, World", result);
    }

    @Test
    void testInvokeMethod_NoSuchMethod() {
        TestClass testObject = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, true, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethod_IllegalAccess() {
        TestClass testObject = new TestClass();
        assertThrows(IllegalAccessException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, "secretMethod");
        });
    }

    @Test
    void testInvokeMethod_InvocationTargetException() {
        TestClass testObject = new TestClass();
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(testObject, true, "secretMethod", new Object[] { null });
        });
    }

    @Test
    void testInvokeMethod_ForceAccess() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "secretMethod", new Object[] { "JUnit" });
        assertEquals("Hello, JUnit", result);
    }
}
