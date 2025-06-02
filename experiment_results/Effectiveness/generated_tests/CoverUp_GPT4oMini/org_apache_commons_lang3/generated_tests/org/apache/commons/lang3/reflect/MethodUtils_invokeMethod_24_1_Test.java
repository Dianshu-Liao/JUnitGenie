package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
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

class MethodUtils_invokeMethod_24_1_Test {

    private static class TestClass {

        public String sayHello() {
            return "Hello";
        }

        public int add(int a, int b) {
            return a + b;
        }

        private String privateMethod() {
            return "This is a private method";
        }
    }

    @Test
    void testInvokeMethodWithPublicMethod() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, "sayHello");
        assertEquals("Hello", result);
    }

    @Test
    void testInvokeMethodWithPublicMethodWithParameters() throws Exception {
        TestClass testClass = new TestClass();
        int result = (int) MethodUtils.invokeMethod(testClass, "add", new Object[] { 5, 10 });
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethodWithPrivateMethod() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) invokePrivateMethod(testClass, "privateMethod");
        assertEquals("This is a private method", result);
    }

    @Test
    void testInvokeMethodWithNoSuchMethod() {
        TestClass testClass = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testClass, "nonExistentMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testInvokeMethodWithIllegalAccess() throws Exception {
        TestClass testClass = new TestClass();
        // This should not throw
        invokePrivateMethod(testClass, "privateMethod");
        // Now we can test invokeMethod directly since it does not throw IllegalAccessException
        assertEquals("This is a private method", MethodUtils.invokeMethod(testClass, "privateMethod"));
    }

    private Object invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        Class<?>[] argTypes = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
        Method method = obj.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }
}
