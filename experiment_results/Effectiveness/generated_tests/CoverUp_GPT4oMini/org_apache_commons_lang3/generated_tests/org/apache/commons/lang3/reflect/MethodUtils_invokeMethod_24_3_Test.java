package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;
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

class MethodUtils_invokeMethod_24_3_Test {

    private static class TestClass {

        public String greet() {
            return "Hello, World!";
        }

        public int add(int a, int b) {
            return a + b;
        }

        private String secret() {
            return "This is a secret!";
        }
    }

    @Test
    void testInvokePublicMethod() throws Exception {
        TestClass testObject = new TestClass();
        Object result = MethodUtils.invokeMethod(testObject, "greet");
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokePublicMethodWithParameters() throws Exception {
        TestClass testObject = new TestClass();
        Object result = MethodUtils.invokeMethod(testObject, "add", new Object[] { 5, 3 });
        assertEquals(8, result);
    }

    @Test
    void testInvokePrivateMethod() throws Exception {
        TestClass testObject = new TestClass();
        Method secretMethod = TestClass.class.getDeclaredMethod("secret");
        secretMethod.setAccessible(true);
        Object result = secretMethod.invoke(testObject);
        assertEquals("This is a secret!", result);
    }

    @Test
    void testInvokeMethodThrowsNoSuchMethodException() {
        TestClass testObject = new TestClass();
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, "nonExistentMethod");
        });
    }

    @Test
    void testInvokeMethodThrowsIllegalAccessException() {
        TestClass testObject = new TestClass();
        assertThrows(IllegalAccessException.class, () -> {
            Method secretMethod = TestClass.class.getDeclaredMethod("secret");
            secretMethod.setAccessible(false);
            MethodUtils.invokeMethod(testObject, "secret");
        });
    }

    @Test
    void testInvokeMethodThrowsInvocationTargetException() {
        TestClass testObject = new TestClass();
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(testObject, "add", new Object[] { 5 });
        });
    }
}
