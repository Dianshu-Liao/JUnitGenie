package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.IllegalArgumentException;
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

class MethodUtils_invokeMethod_24_4_Test {

    private static class TestClass {

        public String sayHello() {
            return "Hello, World!";
        }

        private int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokePublicMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, "sayHello");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        Method method = MethodUtils.class.getDeclaredMethod("invokeMethod", Object.class, String.class, Object[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, testClass, "add", new Object[] { 5, 3 }, null);
        assertEquals(8, result);
    }

    @Test
    void testInvokeMethodWithNonExistentMethod() {
        TestClass testClass = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testClass, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethodWithNullObject() {
        assertThrows(IllegalArgumentException.class, () -> {
            MethodUtils.invokeMethod(null, "sayHello");
        });
    }

    @Test
    void testInvokeMethodWithNullMethodName() {
        TestClass testClass = new TestClass();
        assertThrows(IllegalArgumentException.class, () -> {
            MethodUtils.invokeMethod(testClass, null);
        });
    }
}
