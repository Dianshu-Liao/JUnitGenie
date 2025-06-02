package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.AccessibleObject;
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
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_25_0_Test {

    private static class TestClass {

        public String greet(String name) {
            return "Hello, " + name + "!";
        }

        private int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokePublicMethod() throws Exception {
        TestClass testInstance = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testInstance, "greet", "World");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokePrivateMethod() throws Exception {
        TestClass testInstance = new TestClass();
        Method addMethod = TestClass.class.getDeclaredMethod("add", int.class, int.class);
        AccessibleObject.setAccessible(new Method[] { addMethod }, true);
        int result = (int) addMethod.invoke(testInstance, 2, 3);
        assertEquals(5, result);
    }

    @Test
    void testInvokeMethodWithNullArgument() throws Exception {
        TestClass testInstance = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testInstance, "greet", (Object) null);
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethodWithNoArguments() throws Exception {
        TestClass testInstance = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testInstance, "greet");
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethodThrowsNoSuchMethodException() {
        TestClass testInstance = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testInstance, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethodThrowsIllegalAccessException() {
        TestClass testInstance = new TestClass();
        assertThrows(IllegalAccessException.class, () -> {
            MethodUtils.invokeMethod(testInstance, "add", 1, 2);
        });
    }

    @Test
    void testInvokeMethodThrowsInvocationTargetException() {
        TestClass testInstance = new TestClass() {

            private int faultyMethod() {
                throw new RuntimeException("Error");
            }
        };
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(testInstance, "faultyMethod");
        });
    }
}
