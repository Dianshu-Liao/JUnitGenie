package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class MethodUtils_invokeMethod_25_4_Test {

    private static class TestClass {

        public String testMethod(String input) {
            return "Hello, " + input;
        }

        private int privateMethod(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokePublicMethod() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "testMethod", "World");
        assertEquals("Hello, World", result);
    }

    @Test
    void testInvokePrivateMethod() throws Exception {
        TestClass testObject = new TestClass();
        Method privateMethod = TestClass.class.getDeclaredMethod("privateMethod", int.class, int.class);
        privateMethod.setAccessible(true);
        int result = (int) privateMethod.invoke(testObject, 5, 10);
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethodWithNullArguments() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "testMethod", (Object) null);
        assertEquals("Hello, null", result);
    }

    @Test
    void testInvokeMethodWithEmptyArguments() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "testMethod", new Object[0]);
        assertEquals("Hello, null", result);
    }

    @Test
    void testInvokeMethodWithNoSuchMethod() {
        TestClass testObject = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethodWithIllegalAccess() throws Exception {
        TestClass testObject = new TestClass();
        Method privateMethod = TestClass.class.getDeclaredMethod("privateMethod", int.class, int.class);
        privateMethod.setAccessible(true);
        assertThrows(IllegalAccessException.class, () -> {
            privateMethod.invoke(testObject, 1, 2);
        });
    }

    @Test
    void testInvokeMethodWithInvocationTargetException() {
        TestClass testObject = new TestClass();
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(testObject, "testMethod", new Object[] { new Object() });
        });
    }
}
