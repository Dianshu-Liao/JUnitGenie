package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.ConstructorUtils;
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

class ConstructorUtils_getAccessibleConstructor_0_0_Test {

    // A sample class for testing
    public static class TestClass {

        private TestClass(String name) {
            // private constructor
        }
    }

    @Test
    void testGetAccessibleConstructor_WithValidParameters() throws Exception {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, String.class);
        assertNotNull(constructor);
        assertTrue(constructor.isAccessible());
    }

    @Test
    void testGetAccessibleConstructor_WithNoParameters() throws Exception {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class);
        assertNotNull(constructor);
        assertTrue(constructor.isAccessible());
    }

    @Test
    void testGetAccessibleConstructor_WithInvalidParameter() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, Integer.class);
        assertNull(constructor);
    }

    @Test
    void testGetAccessibleConstructor_WithNullClass() {
        assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getAccessibleConstructor(null, String.class);
        });
    }

    @Test
    void testGetAccessibleConstructor_WithMultipleParameters() {
        // Test with a class that has a constructor with multiple parameters
        class AnotherTestClass {

            private AnotherTestClass(String name, int age) {
                // private constructor
            }
        }
        Constructor<AnotherTestClass> constructor = ConstructorUtils.getAccessibleConstructor(AnotherTestClass.class, String.class, int.class);
        assertNotNull(constructor);
        assertTrue(constructor.isAccessible());
    }

    @Test
    void testGetAccessibleConstructor_WithNonExistentConstructor() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, Double.class);
        assertNull(constructor);
    }
}
