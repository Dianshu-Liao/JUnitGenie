package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
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

class MethodUtils_invokeMethod_21_2_Test {

    private final MethodUtils methodUtils = new MethodUtils();

    @Test
    void testInvokeMethod_ValidMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "sayHello";
        // Act
        Object result = methodUtils.invokeMethod(testClass, true, methodName);
        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test
    void testInvokeMethod_NoSuchMethod() {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "nonExistentMethod";
        // Act
        Executable executable = () -> methodUtils.invokeMethod(testClass, true, methodName);
        // Assert
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testInvokeMethod_IllegalAccess() {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "privateMethod";
        // Act
        Executable executable = () -> methodUtils.invokeMethod(testClass, false, methodName);
        // Assert
        assertThrows(IllegalAccessException.class, executable);
    }

    @Test
    void testInvokeMethod_ForceAccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        TestClass testClass = new TestClass();
        String methodName = "privateMethod";
        // Act
        Object result = methodUtils.invokeMethod(testClass, true, methodName);
        // Assert
        assertEquals("This is a private method", result);
    }

    private static class TestClass {

        public String sayHello() {
            return "Hello, World!";
        }

        private String privateMethod() {
            return "This is a private method";
        }
    }
}
