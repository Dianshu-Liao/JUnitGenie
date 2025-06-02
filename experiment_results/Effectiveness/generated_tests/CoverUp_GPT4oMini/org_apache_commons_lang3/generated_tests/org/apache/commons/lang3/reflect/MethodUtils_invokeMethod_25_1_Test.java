package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
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
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

class MethodUtils_invokeMethod_25_1_Test {

    private MethodUtils methodUtils;

    @BeforeEach
    void setUp() {
        methodUtils = new MethodUtils();
    }

    @Test
    void testInvokeMethod_WithValidMethodAndArgs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "concat";
        Object[] args = new Object[] { "Hello, ", "World!" };
        // Act
        Object result = MethodUtils.invokeMethod(testObject, methodName, args);
        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethod_WithNoArgs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "getGreeting";
        // Act
        Object result = MethodUtils.invokeMethod(testObject, methodName);
        // Assert
        assertEquals("Hello!", result);
    }

    @Test
    void testInvokeMethod_WithNullArgs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "concat";
        // Act
        Object result = MethodUtils.invokeMethod(testObject, methodName, (Object[]) null);
        // Assert
        assertEquals("nullnull", result);
    }

    @Test
    void testInvokeMethod_WithNonExistentMethod() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "nonExistentMethod";
        // Act & Assert
        assertThrows(NoSuchMethodException.class, () -> MethodUtils.invokeMethod(testObject, methodName, new Object[] {}));
    }

    @Test
    void testInvokeMethod_WithPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "privateMethod";
        // Act
        Method method = TestClass.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        Object result = MethodUtils.invokeMethod(testObject, methodName);
        // Assert
        assertEquals("Private Method Invoked", result);
    }

    // Helper class for testing
    private static class TestClass {

        public String concat(String a, String b) {
            return a + b;
        }

        public String getGreeting() {
            return "Hello!";
        }

        private String privateMethod() {
            return "Private Method Invoked";
        }
    }
}
