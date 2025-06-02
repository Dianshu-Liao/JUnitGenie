package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils_getPublicMethod_29_0_Test {

    // Test for public method in the same class
    @Test
    public void testGetPublicMethod_SameClass() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(TestClass.class, "publicMethod", String.class);
        assertNotNull(method);
        assertEquals("publicMethod", method.getName());
        assertTrue(Modifier.isPublic(method.getModifiers()));
    }

    // Test for public method in superclass
    @Test
    public void testGetPublicMethod_SuperClass() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(SubClass.class, "superPublicMethod");
        assertNotNull(method);
        assertEquals("superPublicMethod", method.getName());
        assertTrue(Modifier.isPublic(method.getModifiers()));
    }

    // Test for public method in interface
    @Test
    public void testGetPublicMethod_Interface() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(ImplementingClass.class, "interfaceMethod");
        assertNotNull(method);
        assertEquals("interfaceMethod", method.getName());
        assertTrue(Modifier.isPublic(method.getModifiers()));
    }

    // Test for method not found
    @Test
    public void testGetPublicMethod_MethodNotFound() {
        assertThrows(NoSuchMethodException.class, () -> {
            ClassUtils.getPublicMethod(TestClass.class, "nonExistentMethod");
        });
    }

    // Test for private method should not be found
    @Test
    public void testGetPublicMethod_PrivateMethod() {
        assertThrows(NoSuchMethodException.class, () -> {
            ClassUtils.getPublicMethod(TestClass.class, "privateMethod");
        });
    }

    // Test for method with multiple parameters
    @Test
    public void testGetPublicMethod_MultipleParameters() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(TestClass.class, "methodWithParams", String.class, int.class);
        assertNotNull(method);
        assertEquals("methodWithParams", method.getName());
        assertTrue(Modifier.isPublic(method.getModifiers()));
    }

    // Test for method in superclass with parameters
    @Test
    public void testGetPublicMethod_SuperClassWithParams() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(SubClass.class, "superMethodWithParams", int.class);
        assertNotNull(method);
        assertEquals("superMethodWithParams", method.getName());
        assertTrue(Modifier.isPublic(method.getModifiers()));
    }

    // Sample classes for testing
    public static class TestClass {

        public void publicMethod(String input) {
        }

        private void privateMethod() {
        }

        public void methodWithParams(String input, int number) {
        }
    }

    public static class SuperClass {

        public void superPublicMethod() {
        }

        public void superMethodWithParams(int number) {
        }
    }

    public static class SubClass extends SuperClass {
    }

    public interface TestInterface {

        void interfaceMethod();
    }

    public static class ImplementingClass implements TestInterface {

        public void interfaceMethod() {
        }
    }
}
