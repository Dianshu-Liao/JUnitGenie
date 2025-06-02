package org.apache.commons.lang3.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ConstructorUtils_getAccessibleConstructor_1_0_Test {

    // Test class for creating constructors
    private static class TestClass {

        public TestClass() {
        }

        protected TestClass(int value) {
        }

        private TestClass(String value) {
        }
    }

    @Test
    void testGetAccessibleConstructor_publicConstructor() throws NoSuchMethodException {
        Constructor<TestClass> constructor = TestClass.class.getConstructor();
        Constructor<TestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNotNull(result);
        assertEquals(constructor, result);
    }

    @Test
    void testGetAccessibleConstructor_protectedConstructor() throws NoSuchMethodException {
        Constructor<TestClass> constructor = TestClass.class.getDeclaredConstructor(int.class);
        Constructor<TestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }

    @Test
    void testGetAccessibleConstructor_privateConstructor() throws NoSuchMethodException {
        Constructor<TestClass> constructor = TestClass.class.getDeclaredConstructor(String.class);
        Constructor<TestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }

    @Test
    void testGetAccessibleConstructor_nullConstructor() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getAccessibleConstructor(null));
    }

    @Test
    void testGetAccessibleConstructor_nonAccessibleClass() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> nonAccessibleClass = Class.forName("java.lang.Object");
        Constructor<?> constructor = nonAccessibleClass.getDeclaredConstructor();
        Constructor<?> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }
}
