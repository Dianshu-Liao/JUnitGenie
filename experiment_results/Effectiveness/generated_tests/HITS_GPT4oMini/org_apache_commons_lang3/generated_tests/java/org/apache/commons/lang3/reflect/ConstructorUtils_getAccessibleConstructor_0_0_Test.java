package org.apache.commons.lang3.reflect;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

public class ConstructorUtils_getAccessibleConstructor_0_0_Test {

    // Test case for a valid constructor with no parameters
    @Test
    public void testGetAccessibleConstructor_NoParameters() throws NoSuchMethodException {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class);
        assertNotNull(constructor);
        assertTrue(constructor.isAccessible());
    }

    // Test case for a valid constructor with parameters
    @Test
    public void testGetAccessibleConstructor_WithParameters() throws NoSuchMethodException {
        Constructor<AnotherTestClass> constructor = ConstructorUtils.getAccessibleConstructor(AnotherTestClass.class, String.class);
        assertNotNull(constructor);
        assertTrue(constructor.isAccessible());
    }

    // Test case for a constructor that does not exist
    @Test
    public void testGetAccessibleConstructor_NonExistentConstructor() {
        Constructor<?> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, int.class);
        assertNull(constructor);
    }

    // Test case for null class argument
    @Test
    public void testGetAccessibleConstructor_NullClass() {
        assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getAccessibleConstructor(null);
        });
    }

    // Test class with a no-argument constructor
    public static class TestClass {

        public TestClass() {
        }
    }

    // Test class with a constructor that takes a String parameter
    public static class AnotherTestClass {

        public AnotherTestClass(String name) {
        }
    }
}
