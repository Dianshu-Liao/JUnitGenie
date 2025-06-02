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

class MethodUtils_invokeMethod_26_1_Test {

    private TestClass testObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass();
    }

    @Test
    void testInvokeMethod_WithValidMethod() throws Exception {
        String methodName = "sayHello";
        Object result = MethodUtils.invokeMethod(testObject, methodName, null, null);
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethod_WithValidMethodAndArgs() throws Exception {
        String methodName = "greet";
        Object[] args = new Object[] { "JUnit" };
        Class<?>[] paramTypes = new Class<?>[] { String.class };
        Object result = MethodUtils.invokeMethod(testObject, methodName, args, paramTypes);
        assertEquals("Hello, JUnit!", result);
    }

    @Test
    void testInvokeMethod_WithNoSuchMethod() {
        String methodName = "nonExistentMethod";
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, methodName, null, null);
        });
    }

    @Test
    void testInvokeMethod_WithPrivateMethod() throws Exception {
        String methodName = "privateMethod";
        Object result = MethodUtils.invokeMethod(testObject, methodName, null, null);
        assertEquals("This is a private method", result);
    }

    @Test
    void testInvokeMethod_WithForceAccess() throws Exception {
        String methodName = "privateMethod";
        Object result = MethodUtils.invokeMethod(testObject, true, methodName, null, null);
        assertEquals("This is a private method", result);
    }

    @Test
    void testInvokeMethod_WithInvalidAccess() {
        String methodName = "privateMethod";
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, false, methodName, null, null);
        });
    }

    // Test class with methods to invoke
    private static class TestClass {

        public String sayHello() {
            return "Hello, World!";
        }

        public String greet(String name) {
            return "Hello, " + name + "!";
        }

        private String privateMethod() {
            return "This is a private method";
        }
    }
}
