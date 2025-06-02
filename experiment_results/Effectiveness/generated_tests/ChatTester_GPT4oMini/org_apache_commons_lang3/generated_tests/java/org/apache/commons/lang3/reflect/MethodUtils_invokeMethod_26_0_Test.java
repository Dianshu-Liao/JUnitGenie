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

public class MethodUtils_invokeMethod_26_0_Test {

    private MethodUtils methodUtils;

    @BeforeEach
    public void setUp() {
        methodUtils = new MethodUtils();
    }

    @Test
    public void testInvokeMethod_WithValidMethod() throws Exception {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "sayHello";
        Object[] args = new Object[] { "World" };
        Class<?>[] parameterTypes = new Class<?>[] { String.class };
        // Act
        Object result = MethodUtils.invokeMethod(testObject, methodName, args, parameterTypes);
        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testInvokeMethod_WithNoSuchMethod() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "nonExistentMethod";
        Object[] args = new Object[] {};
        Class<?>[] parameterTypes = new Class<?>[] {};
        // Act & Assert
        assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testObject, methodName, args, parameterTypes);
        });
    }

    @Test
    public void testInvokeMethod_WithIllegalAccess() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "privateMethod";
        Object[] args = new Object[] {};
        Class<?>[] parameterTypes = new Class<?>[] {};
        // Act & Assert
        assertThrows(IllegalAccessException.class, () -> {
            MethodUtils.invokeMethod(testObject, methodName, args, parameterTypes);
        });
    }

    @Test
    public void testInvokeMethod_WithInvocationTargetException() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "methodThrowingException";
        Object[] args = new Object[] {};
        Class<?>[] parameterTypes = new Class<?>[] {};
        // Act & Assert
        assertThrows(InvocationTargetException.class, () -> {
            MethodUtils.invokeMethod(testObject, methodName, args, parameterTypes);
        });
    }

    @Test
    public void testInvokeMethod_WithMultipleParameters() throws Exception {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "add";
        Object[] args = new Object[] { 5, 10 };
        Class<?>[] parameterTypes = new Class<?>[] { int.class, int.class };
        // Act
        Object result = MethodUtils.invokeMethod(testObject, methodName, args, parameterTypes);
        // Assert
        assertEquals(15, result);
    }

    private static class TestClass {

        public String sayHello(String name) {
            return "Hello, " + name + "!";
        }

        private void privateMethod() {
            // This method is private and should not be accessible
        }

        public void methodThrowingException() throws Exception {
            throw new Exception("This is an exception");
        }

        public int add(int a, int b) {
            return a + b;
        }
    }
}
