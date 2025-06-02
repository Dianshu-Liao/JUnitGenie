package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.ArrayUtils;
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
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_23_3_Test {

    private static class TestClass {

        private String privateMethod(String input) {
            return "Hello, " + input;
        }

        public String publicMethod(String input) {
            return "Hi, " + input;
        }
    }

    @Test
    void testInvokePrivateMethod() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "privateMethod", new Object[] { "World" }, new Class<?>[] { String.class });
        assertEquals("Hello, World", result);
    }

    @Test
    void testInvokePublicMethod() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, false, "publicMethod", new Object[] { "World" }, new Class<?>[] { String.class });
        assertEquals("Hi, World", result);
    }

    @Test
    void testInvokeMethodWithNullArgs() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, false, "publicMethod", new Object[] { null }, new Class<?>[] { String.class });
        assertEquals("Hi, null", result);
    }

    @Test
    void testInvokeMethodWithNullParameterTypes() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, false, "publicMethod", new Object[] { "World" }, null);
        assertEquals("Hi, World", result);
    }

    @Test
    void testInvokeNonExistentMethod() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, "nonExistentMethod", new Object[] {}, new Class<?>[] {});
        });
        assertTrue(exception.getMessage().contains("No such accessible method: nonExistentMethod()"));
    }

    @Test
    void testInvokeMethodWithForceAccess() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "privateMethod", new Object[] { "World" }, new Class<?>[] { String.class });
        assertEquals("Hello, World", result);
    }

    @Test
    void testInvokeMethodWithWrongParameterTypes() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, "publicMethod", new Object[] { 123 }, new Class<?>[] { String.class });
        });
        assertTrue(exception.getMessage().contains("No such accessible method: publicMethod()"));
    }
}
