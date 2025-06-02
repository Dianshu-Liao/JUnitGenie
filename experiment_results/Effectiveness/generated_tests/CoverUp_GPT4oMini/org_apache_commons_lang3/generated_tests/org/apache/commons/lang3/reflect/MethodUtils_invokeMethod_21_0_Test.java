package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Array;
import org.apache.commons.lang3.ArrayUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
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
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_21_0_Test {

    private static class TestClass {

        private String privateMethod() {
            return "Hello, World!";
        }

        private int sum(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        // Invoke private method with no parameters
        Object result = MethodUtils.invokeMethod(testObject, true, "privateMethod");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokePrivateMethodWithParameters() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testObject = new TestClass();
        // Invoke private method with parameters
        Object result = MethodUtils.invokeMethod(testObject, true, "sum", new Object[] { 2, 3 });
        assertEquals(5, result);
    }

    @Test
    void testInvokeMethodNotFound() {
        TestClass testObject = new TestClass();
        // Test invoking a non-existing method
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, true, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethodIllegalAccess() {
        TestClass testObject = new TestClass();
        // Test invoking a method without access
        assertThrows(IllegalAccessException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, "privateMethod");
        });
    }

    @Test
    void testInvokeMethodInvocationTargetException() {
        TestClass testObject = new TestClass();
        // Test invoking a method that throws an exception
        assertThrows(InvocationTargetException.class, () -> {
            Method method = TestClass.class.getDeclaredMethod("sum", int.class, int.class);
            method.setAccessible(true);
            // Invalid parameters to trigger an exception
            MethodUtils.invokeMethod(testObject, true, "sum", new Object[] { 2, null });
        });
    }
}
