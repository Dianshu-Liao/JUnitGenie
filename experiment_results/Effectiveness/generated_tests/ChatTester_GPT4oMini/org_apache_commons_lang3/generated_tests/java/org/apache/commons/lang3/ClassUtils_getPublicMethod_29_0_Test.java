package org.apache.commons.lang3;

import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class ClassUtils_getPublicMethod_29_0_Test {

    // A sample class to test getPublicMethod
    public static class TestClass {

        public void publicMethod() {
        }

        protected void protectedMethod() {
        }

        private void privateMethod() {
        }
    }

    public static class SuperClass {

        public void superPublicMethod() {
        }
    }

    public interface TestInterface {

        void interfaceMethod();
    }

    public static class SubClass extends SuperClass implements TestInterface {

        public void interfaceMethod() {
        }
    }

    @Test
    void testGetPublicMethodWithPublicMethod() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(TestClass.class, "publicMethod");
        assertNotNull(method);
        assertTrue(Modifier.isPublic(method.getModifiers()));
        assertEquals("publicMethod", method.getName());
    }

    @Test
    void testGetPublicMethodWithProtectedMethod() {
        Executable executable = () -> ClassUtils.getPublicMethod(TestClass.class, "protectedMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testGetPublicMethodWithPrivateMethod() {
        Executable executable = () -> ClassUtils.getPublicMethod(TestClass.class, "privateMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testGetPublicMethodFromSuperClass() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(SubClass.class, "superPublicMethod");
        assertNotNull(method);
        assertTrue(Modifier.isPublic(method.getModifiers()));
        assertEquals("superPublicMethod", method.getName());
    }

    @Test
    void testGetPublicMethodFromInterface() throws NoSuchMethodException {
        Method method = ClassUtils.getPublicMethod(SubClass.class, "interfaceMethod");
        assertNotNull(method);
        assertTrue(Modifier.isPublic(method.getModifiers()));
        assertEquals("interfaceMethod", method.getName());
    }

    @Test
    void testGetPublicMethodNotFound() {
        Executable executable = () -> ClassUtils.getPublicMethod(TestClass.class, "nonExistentMethod");
        assertThrows(NoSuchMethodException.class, executable);
    }

    @Test
    void testGetPublicMethodWithParameterTypes() throws NoSuchMethodException {
        class ParameterClass {

            public void methodWithParams(String param) {
            }
        }
        Method method = ClassUtils.getPublicMethod(ParameterClass.class, "methodWithParams", String.class);
        assertNotNull(method);
        assertTrue(Modifier.isPublic(method.getModifiers()));
        assertEquals("methodWithParams", method.getName());
        assertArrayEquals(new Class<?>[] { String.class }, method.getParameterTypes());
    }

    @Test
    void testGetPublicMethodWithDifferentParameterTypes() throws NoSuchMethodException {
        class ParameterClass {

            public void methodWithParams(String param, int number) {
            }
        }
        Method method = ClassUtils.getPublicMethod(ParameterClass.class, "methodWithParams", String.class, int.class);
        assertNotNull(method);
        assertTrue(Modifier.isPublic(method.getModifiers()));
        assertEquals("methodWithParams", method.getName());
        assertArrayEquals(new Class<?>[] { String.class, int.class }, method.getParameterTypes());
    }
}
