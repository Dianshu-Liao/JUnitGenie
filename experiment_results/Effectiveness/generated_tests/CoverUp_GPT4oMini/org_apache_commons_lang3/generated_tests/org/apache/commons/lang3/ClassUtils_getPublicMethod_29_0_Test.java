package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
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

class ClassUtils_getPublicMethod_29_0_Test {

    // Test class with public method
    public static class TestClass {

        public void publicMethod() {
        }

        protected void protectedMethod() {
        }

        private void privateMethod() {
        }
    }

    // Test class with a public method in a superclass
    public static class SuperClass {

        public void superPublicMethod() {
        }
    }

    public static class SubClass extends SuperClass {

        // Overriding method to test inheritance
        @Override
        public void superPublicMethod() {
        }
    }

    // Test class with an interface
    public interface TestInterface {

        void interfaceMethod();
    }

    public static class TestImplementation implements TestInterface {

        @Override
        public void interfaceMethod() {
        }
    }

    @Test
    void testGetPublicMethod_foundInClass() throws Exception {
        Method method = ClassUtils.getPublicMethod(TestClass.class, "publicMethod");
        assertNotNull(method);
        assertEquals("publicMethod", method.getName());
    }

    @Test
    void testGetPublicMethod_foundInSuperClass() throws Exception {
        Method method = ClassUtils.getPublicMethod(SubClass.class, "superPublicMethod");
        assertNotNull(method);
        assertEquals("superPublicMethod", method.getName());
    }

    @Test
    void testGetPublicMethod_foundInInterface() throws Exception {
        Method method = ClassUtils.getPublicMethod(TestImplementation.class, "interfaceMethod");
        assertNotNull(method);
        assertEquals("interfaceMethod", method.getName());
    }

    @Test
    void testGetPublicMethod_notFoundInClass() {
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            ClassUtils.getPublicMethod(TestClass.class, "protectedMethod");
        });
        assertEquals("Can't find a public method for protectedMethod []", exception.getMessage());
    }

    @Test
    void testGetPublicMethod_notFoundInSuperClass() {
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            ClassUtils.getPublicMethod(SubClass.class, "privateMethod");
        });
        assertEquals("Can't find a public method for privateMethod []", exception.getMessage());
    }

    @Test
    void testGetPublicMethod_withParameters() throws Exception {
        Method method = ClassUtils.getPublicMethod(TestClass.class, "publicMethod");
        assertNotNull(method);
        assertEquals("publicMethod", method.getName());
    }

    @Test
    void testGetPublicMethod_withDifferentParameterTypes() throws Exception {
        Method method = ClassUtils.getPublicMethod(TestClass.class, "publicMethod");
        assertNotNull(method);
        assertEquals("publicMethod", method.getName());
    }
}
