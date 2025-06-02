package org.apache.commons.lang3.reflect;

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

class MethodUtils_invokeMethod_23_0_Test {

    private MethodUtils methodUtils;

    @BeforeEach
    void setUp() {
        methodUtils = new MethodUtils();
    }

    private class TestClass {

        private String privateMethod(String input) {
            return "Hello, " + input;
        }

        public String publicMethod(String input) {
            return "Hi, " + input;
        }
    }

    @Test
    void testInvokePrivateMethodWithForceAccess() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, true, "privateMethod", new Object[] { "World" }, new Class<?>[] { String.class });
        assertEquals("Hello, World", result);
    }

    @Test
    void testInvokePublicMethod() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, false, "publicMethod", new Object[] { "World" }, new Class<?>[] { String.class });
        assertEquals("Hi, World", result);
    }

    @Test
    void testInvokeMethodWithNoSuchMethodException() {
        TestClass testClass = new TestClass();
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testClass, false, "nonExistentMethod", null, null);
        });
        assertTrue(exception.getMessage().contains("No such accessible method: nonExistentMethod() on object:"));
    }

    @Test
    void testInvokeMethodWithNullObject() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            MethodUtils.invokeMethod(null, false, "publicMethod", null, null);
        });
        assertEquals("object", exception.getMessage());
    }

    @Test
    void testInvokeMethodWithNullParameterTypes() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, false, "publicMethod", new Object[] { "World" }, null);
        assertEquals("Hi, World", result);
    }

    @Test
    void testInvokeMethodWithNullArgs() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, false, "publicMethod", null, new Class<?>[] { String.class });
        assertEquals("Hi, null", result);
    }

    @Test
    void testInvokeMethodWithForceAccessAndNullArgs() throws Exception {
        TestClass testClass = new TestClass();
        String result = (String) MethodUtils.invokeMethod(testClass, true, "privateMethod", null, new Class<?>[] { String.class });
        assertEquals("Hello, null", result);
    }
}
