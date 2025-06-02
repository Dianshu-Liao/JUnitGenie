package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
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
    void testInvokePublicMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        Object result = MethodUtils.invokeMethod(testClass, "greet", "World");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        Object result = MethodUtils.invokeMethod(testClass, "add", 5, 10);
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethodWithNoArguments() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        Object result = MethodUtils.invokeMethod(testClass, "greet");
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeNonExistentMethod() {
        TestClass testClass = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testClass, "nonExistentMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testInvokeMethodWithWrongArgumentType() {
        TestClass testClass = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testClass, "add", "5", "10");
        assertThrows(InvocationTargetException.class, executable);
    }

    @Test
    void testInvokeMethodWithNullObject() {
        Executable executable = () -> MethodUtils.invokeMethod(null, "greet", "World");
        assertThrows(IllegalAccessException.class, executable);
    }
}
