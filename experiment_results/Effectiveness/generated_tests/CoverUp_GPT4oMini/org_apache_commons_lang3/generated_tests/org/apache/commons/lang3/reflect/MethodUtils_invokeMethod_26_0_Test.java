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

class MethodUtils_invokeMethod_26_0_Test {

    private static class TestClass {

        private String greet(String name) {
            return "Hello, " + name + "!";
        }

        private int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokeMethodWithValidMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "greet", new Object[] { "World" }, new Class<?>[] { String.class });
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethodWithValidMethodAndDifferentParameterTypes() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        int result = (int) MethodUtils.invokeMethod(testObject, "add", new Object[] { 5, 10 }, new Class<?>[] { int.class, int.class });
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethodWithNoSuchMethod() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, "nonExistentMethod", null, null);
        });
        assertTrue(exception.getMessage().contains("No such accessible method: nonExistentMethod() on object:"));
    }

    @Test
    void testInvokeMethodWithNullObject() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            MethodUtils.invokeMethod(null, "greet", new Object[] { "World" }, new Class<?>[] { String.class });
        });
        assertEquals("object", exception.getMessage());
    }

    @Test
    void testInvokeMethodWithForceAccess() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        Method method = testObject.getClass().getDeclaredMethod("greet", String.class);
        method.setAccessible(true);
        String result = (String) MethodUtils.invokeMethod(testObject, "greet", new Object[] { "Force" }, new Class<?>[] { String.class });
        assertEquals("Hello, Force!", result);
        assertTrue(method.isAccessible());
    }

    @Test
    void testInvokeMethodWithNullArgs() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "greet", null, null);
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethodWithEmptyArgs() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "greet", new Object[] {}, new Class<?>[] {});
        assertEquals("Hello, null!", result);
    }
}
