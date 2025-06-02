package org.apache.commons.lang3.reflect;

import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
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

public class MethodUtils_invokeMethod_22_0_Test {

    // Sample class with methods for testing
    private static class TestClass {

        private String greet(String name) {
            return "Hello, " + name;
        }

        private int add(int a, int b) {
            return a + b;
        }

        private void doNothing() {
            // This method does nothing
        }
    }

    @Test
    public void testInvokeMethod_withValidMethod() throws Exception {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "greet";
        String expected = "Hello, John";
        // Act
        Object result = MethodUtils.invokeMethod(testClass, true, methodName, "John");
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInvokeMethod_withValidMethodAndMultipleArgs() throws Exception {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "add";
        int expected = 5;
        // Act
        Object result = MethodUtils.invokeMethod(testClass, true, methodName, 2, 3);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInvokeMethod_withVoidMethod() throws Exception {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "doNothing";
        // Act
        Assertions.assertDoesNotThrow(() -> {
            MethodUtils.invokeMethod(testClass, true, methodName);
        });
    }

    @Test
    public void testInvokeMethod_withInvalidMethod() {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "nonExistentMethod";
        // Act & Assert
        Assertions.assertThrows(NoSuchMethodException.class, () -> {
            MethodUtils.invokeMethod(testClass, true, methodName);
        });
    }

    @Test
    public void testInvokeMethod_withAccessControl() throws Exception {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "greet";
        String expected = "Hello, Alice";
        // Act
        Object result = MethodUtils.invokeMethod(testClass, true, methodName, "Alice");
        // Assert
        Assertions.assertEquals(expected, result);
    }
}
