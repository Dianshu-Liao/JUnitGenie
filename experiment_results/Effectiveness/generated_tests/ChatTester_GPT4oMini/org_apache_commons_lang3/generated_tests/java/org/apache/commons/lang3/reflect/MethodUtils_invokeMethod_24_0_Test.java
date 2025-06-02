package org.apache.commons.lang3.reflect;

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

public class MethodUtils_invokeMethod_24_0_Test {

    // Test for invoking a method with a valid name
    @Test
    public void testInvokeMethod_ValidMethod() throws Exception {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "sayHello";
        // Act
        Object result = MethodUtils.invokeMethod(testObject, methodName);
        // Assert
        assertEquals("Hello, World!", result);
    }

    // Test for invoking a method that does not exist
    @Test
    public void testInvokeMethod_NonExistentMethod() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "nonExistentMethod";
        // Act
        Executable executable = () -> MethodUtils.invokeMethod(testObject, methodName);
        // Assert
        assertThrows(NoSuchMethodException.class, executable);
    }

    // Test for invoking a method with illegal access
    @Test
    public void testInvokeMethod_IllegalAccess() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "privateMethod";
        // Act
        Executable executable = () -> MethodUtils.invokeMethod(testObject, methodName);
        // Assert
        assertThrows(IllegalAccessException.class, executable);
    }

    // Test for invoking a method that throws an exception
    @Test
    public void testInvokeMethod_MethodThrowsException() {
        // Arrange
        TestClass testObject = new TestClass();
        String methodName = "methodThatThrows";
        // Act
        Executable executable = () -> MethodUtils.invokeMethod(testObject, methodName);
        // Assert
        assertThrows(InvocationTargetException.class, executable);
    }

    // Test class with methods to be invoked
    private static class TestClass {

        public String sayHello() {
            return "Hello, World!";
        }

        private void privateMethod() {
            // This method is private and should not be accessible
        }

        public void methodThatThrows() throws Exception {
            throw new Exception("This is an exception");
        }
    }
}
