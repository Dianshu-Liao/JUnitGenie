package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
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

class MethodUtils_invokeMethod_25_3_Test {

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
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "greet", "World");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokePrivateMethod() throws Exception {
        TestClass testObject = new TestClass();
        int result = (int) invokePrivateMethod(testObject, "add", 2, 3);
        assertEquals(5, result);
    }

    @Test
    void testInvokeMethodWithNullArgument() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "greet", (Object) null);
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethodWithNoArguments() throws Exception {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, "greet");
        assertEquals("Hello, null!", result);
    }

    @Test
    void testInvokeMethodWithInvalidMethodName() {
        TestClass testObject = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethodWithIncorrectArgumentType() {
        TestClass testObject = new TestClass();
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(testObject, "greet", 123);
        });
    }

    private Object invokePrivateMethod(Object object, String methodName, Object... args) throws Exception {
        Class<?> clazz = object.getClass();
        Method method = clazz.getDeclaredMethod(methodName, getParameterTypes(args));
        method.setAccessible(true);
        return method.invoke(object, args);
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return Arrays.stream(args).map(arg -> arg == null ? Object.class : arg.getClass()).toArray(Class<?>[]::new);
    }
}
