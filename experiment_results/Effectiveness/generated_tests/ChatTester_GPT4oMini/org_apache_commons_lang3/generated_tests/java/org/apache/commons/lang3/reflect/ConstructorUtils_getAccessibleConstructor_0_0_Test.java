package org.apache.commons.lang3.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

class ConstructorUtils_getAccessibleConstructor_0_0_Test {

    // A sample class for testing
    public static class TestClass {

        public TestClass() {
        }

        public TestClass(String param) {
        }

        private TestClass(int param) {
        }
    }

    @Test
    void testGetAccessibleConstructor_withValidConstructor() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, String.class);
        assertNotNull(constructor);
        assertEquals(TestClass.class, constructor.getDeclaringClass());
        assertArrayEquals(new Class<?>[] { String.class }, constructor.getParameterTypes());
    }

    @Test
    void testGetAccessibleConstructor_withPrivateConstructor() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, int.class);
        assertNotNull(constructor);
        assertEquals(TestClass.class, constructor.getDeclaringClass());
        assertArrayEquals(new Class<?>[] { int.class }, constructor.getParameterTypes());
        // Make the constructor accessible
        constructor.setAccessible(true);
        assertDoesNotThrow(() -> constructor.newInstance(5));
    }

    @Test
    void testGetAccessibleConstructor_withNoSuchMethod() {
        Constructor<TestClass> constructor = ConstructorUtils.getAccessibleConstructor(TestClass.class, double.class);
        assertNull(constructor);
    }

    @Test
    void testGetAccessibleConstructor_withNullClass() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getAccessibleConstructor(null);
        });
        assertEquals("cls", exception.getMessage());
    }
}
