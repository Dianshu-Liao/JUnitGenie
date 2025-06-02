package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
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

class MethodUtils_invokeMethod_21_0_Test {

    private static class TestClass {

        private String greet(String name) {
            return "Hello, " + name + "!";
        }

        private int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokeMethod_WithValidMethod() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "greet");
        // Since we are not passing any arguments
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethod_WithValidMethodAndArgument() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "greet", new Object[] { "World" });
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethod_WithValidMethodReturningInt() throws Exception {
        TestClass testObject = new TestClass();
        int result = (int) MethodUtils.invokeMethod(testObject, true, "add", new Object[] { 5, 10 });
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethod_WithNonExistentMethod() {
        TestClass testObject = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testObject, true, "nonExistentMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testInvokeMethod_WithAccessControl() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, false, "greet");
        // Since we are not passing any arguments
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethod_WithForceAccess() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "greet");
        // Since we are not passing any arguments
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethod_WithInvalidAccess() {
        TestClass testObject = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testObject, false, "add");
        assertThrows(IllegalAccessException.class, executable);
    }
}
