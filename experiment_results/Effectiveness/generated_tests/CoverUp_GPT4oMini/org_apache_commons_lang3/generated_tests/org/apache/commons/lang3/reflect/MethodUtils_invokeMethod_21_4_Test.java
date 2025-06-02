package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Array;
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
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

public class MethodUtils_invokeMethod_21_4_Test {

    // Test class with a method to invoke
    private static class TestClass {

        public String greet(String name) {
            return "Hello, " + name;
        }

        private int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    public void testInvokePublicMethod() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, false, "greet", new Object[] { "World" });
        assertEquals("Hello, World", result);
    }

    @Test
    public void testInvokePrivateMethod() throws Exception {
        TestClass testObject = new TestClass();
        Method method = MethodUtils.class.getDeclaredMethod("invokeMethod", Object.class, boolean.class, String.class, Object[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, testObject, true, "add", new Object[] { 5, 10 });
        assertEquals(15, result);
    }

    @Test
    public void testInvokeMethodWithNoSuchMethod() {
        TestClass testObject = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, "nonExistentMethod");
        });
    }

    @Test
    public void testInvokeMethodWithIllegalAccess() {
        TestClass testObject = new TestClass();
        assertThrows(IllegalAccessException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, "add", new Object[] { 5, 10 });
        });
    }

    @Test
    public void testInvokeMethodWithNullObject() {
        assertThrows(NullPointerException.class, () -> {
            MethodUtils.invokeMethod(null, false, "greet");
        });
    }
}
