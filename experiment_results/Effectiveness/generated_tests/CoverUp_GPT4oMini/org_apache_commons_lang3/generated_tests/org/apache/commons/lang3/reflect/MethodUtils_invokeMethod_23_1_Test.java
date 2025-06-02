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

class MethodUtils_invokeMethod_23_1_Test {

    private static class TestClass {

        private String concatenate(String a, String b) {
            return a + b;
        }

        private int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testInvokeMethodWithValidMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "concatenate", new Object[] { "Hello, ", "World!" }, new Class<?>[] { String.class, String.class });
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethodWithVarArgs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "concatenate", new Object[] { "Hello", " ", "World!" }, new Class<?>[] { String.class, String.class });
        assertEquals("Hello World!", result);
    }

    @Test
    void testInvokeMethodWithInvalidMethod() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, true, "nonExistentMethod", null, null);
        });
        assertTrue(exception.getMessage().contains("No such method: nonExistentMethod() on object:"));
    }

    @Test
    void testInvokeMethodWithAccessControl() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testObject = new TestClass();
        int result = (int) MethodUtils.invokeMethod(testObject, true, "add", new Object[] { 5, 10 }, new Class<?>[] { int.class, int.class });
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethodWithNullObject() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            MethodUtils.invokeMethod(null, true, "someMethod", null, null);
        });
        assertEquals("object", exception.getMessage());
    }

    @Test
    void testInvokeMethodWithNullParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testObject, true, "concatenate", new Object[] { null, null }, new Class<?>[] { String.class, String.class });
        assertEquals("nullnull", result);
    }
}
