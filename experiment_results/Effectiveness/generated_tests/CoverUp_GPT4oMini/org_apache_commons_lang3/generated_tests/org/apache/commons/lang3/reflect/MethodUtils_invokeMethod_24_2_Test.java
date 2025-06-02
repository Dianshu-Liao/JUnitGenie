package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
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

class MethodUtils_invokeMethod_24_2_Test {

    private static class TestClass {

        public String sayHello() {
            return "Hello";
        }

        public int add(int a, int b) {
            return a + b;
        }

        private String privateMethod() {
            return "Private Method Invoked";
        }
    }

    @Test
    void testInvokeMethod_publicMethod() throws Exception {
        TestClass testClass = new TestClass();
        Object result = MethodUtils.invokeMethod(testClass, "sayHello");
        assertEquals("Hello", result);
    }

    @Test
    void testInvokeMethod_withParameters() throws Exception {
        TestClass testClass = new TestClass();
        Object result = MethodUtils.invokeMethod(testClass, "add", new Object[] { 5, 10 });
        assertEquals(15, result);
    }

    @Test
    void testInvokeMethod_noSuchMethod() {
        TestClass testClass = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testClass, "nonExistentMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testInvokeMethod_illegalAccess() {
        TestClass testClass = new TestClass();
        Executable executable = () -> MethodUtils.invokeMethod(testClass, "privateMethod");
        assertThrows(InvocationTargetException.class, executable);
    }

    @Test
    void testInvokeMethod_privateMethod() throws Exception {
        TestClass testClass = new TestClass();
        Method privateMethod = TestClass.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        Object result = privateMethod.invoke(testClass);
        assertEquals("Private Method Invoked", result);
    }
}
