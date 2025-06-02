package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MemberUtils;
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

class ConstructorUtils_getAccessibleConstructor_1_0_Test {

    // Test for a public constructor
    @Test
    void testGetAccessibleConstructor_PublicConstructor() throws NoSuchMethodException {
        Constructor<TestClass> constructor = TestClass.class.getConstructor();
        Constructor<TestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNotNull(result);
        assertEquals(constructor, result);
    }

    // Test for a protected constructor
    @Test
    void testGetAccessibleConstructor_ProtectedConstructor() throws NoSuchMethodException {
        Constructor<ProtectedTestClass> constructor = ProtectedTestClass.class.getDeclaredConstructor();
        Constructor<ProtectedTestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }

    // Test for a private constructor
    @Test
    void testGetAccessibleConstructor_PrivateConstructor() throws NoSuchMethodException {
        Constructor<PrivateTestClass> constructor = PrivateTestClass.class.getDeclaredConstructor();
        Constructor<PrivateTestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }

    // Test for a constructor in a non-accessible class
    @Test
    void testGetAccessibleConstructor_NonAccessibleClass() throws NoSuchMethodException {
        Constructor<NonAccessibleClass> constructor = NonAccessibleClass.class.getDeclaredConstructor();
        Constructor<NonAccessibleClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }

    // Test for null constructor input
    @Test
    void testGetAccessibleConstructor_NullConstructor() {
        assertThrows(NullPointerException.class, () -> ConstructorUtils.getAccessibleConstructor(null));
    }

    // Test for synthetic constructor
    @Test
    void testGetAccessibleConstructor_SyntheticConstructor() throws NoSuchMethodException {
        Constructor<SyntheticTestClass> constructor = SyntheticTestClass.class.getDeclaredConstructor();
        Constructor<SyntheticTestClass> result = ConstructorUtils.getAccessibleConstructor(constructor);
        assertNull(result);
    }

    // Helper classes for testing
    public static class TestClass {

        public TestClass() {
        }
    }

    protected static class ProtectedTestClass {

        protected ProtectedTestClass() {
        }
    }

    private static class PrivateTestClass {

        private PrivateTestClass() {
        }
    }

    public static class NonAccessibleClass {

        NonAccessibleClass() {
        }
    }

    public static class SyntheticTestClass {

        public SyntheticTestClass() {
            // synthetic constructor
        }
    }
}
