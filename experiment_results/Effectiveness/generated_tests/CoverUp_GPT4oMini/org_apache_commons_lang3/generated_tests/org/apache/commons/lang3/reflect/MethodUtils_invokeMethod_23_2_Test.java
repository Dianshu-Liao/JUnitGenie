package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MethodUtils_invokeMethod_23_2_Test {

    private static class TestClass {

        private String concatenate(String a, String b) {
            return a + b;
        }

        private int add(int x, int y) {
            return x + y;
        }

        private void noReturn() {
            // no return
        }
    }

    @Test
    void testInvokeMethodWithValidMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, true, "concatenate", new Object[] { "Hello, ", "World!" }, new Class<?>[] { String.class, String.class });
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethodWithValidMethodAndPrimitiveTypes() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        int result = (int) MethodUtils.invokeMethod(testClass, true, "add", new Object[] { 5, 10 }, new Class<?>[] { int.class, int.class });
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethodWithVoidReturnType() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        assertDoesNotThrow(() -> MethodUtils.invokeMethod(testClass, true, "noReturn", null, null));
    }

    @Test
    void testInvokeMethodWithNoSuchMethod() {
        TestClass testClass = new TestClass();
        NoSuchMethodException exception = assertThrows(NoSuchMethodException.class, () -> MethodUtils.invokeMethod(testClass, true, "nonExistentMethod", null, null));
        assertEquals("No such method: nonExistentMethod() on object: " + TestClass.class.getName(), exception.getMessage());
    }

    @Test
    void testInvokeMethodWithNullObject() {
        NoSuchMethodException exception = assertThrows(NoSuchMethodException.class, () -> MethodUtils.invokeMethod(null, true, "concatenate", new Object[] { "Hello, ", "World!" }, new Class<?>[] { String.class, String.class }));
        assertEquals("No such method: concatenate() on object: null", exception.getMessage());
    }

    @Test
    void testInvokeMethodWithNonAccessibleMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, true, "concatenate", new Object[] { "Hello, ", "World!" }, new Class<?>[] { String.class, String.class });
        assertEquals("Hello, World!", result);
    }
}
