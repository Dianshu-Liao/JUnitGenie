package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FieldUtils_readField_15_2_Test {

    private TestClass testObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass();
    }

    @Test
    void testReadFieldWithValidField() {
        String fieldName = "privateField";
        try {
            Object value = invokeReadField(testObject, fieldName, true);
            assertEquals("Hello", value);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    void testReadFieldWithInvalidField() {
        String fieldName = "nonExistentField";
        IllegalAccessException exception = assertThrows(IllegalAccessException.class, () -> {
            invokeReadField(testObject, fieldName, true);
        });
        assertEquals("Cannot locate field nonExistentField on class FieldUtilsTest$TestClass", exception.getMessage());
    }

    @Test
    void testReadFieldWithNullTarget() {
        String fieldName = "privateField";
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(null, fieldName, true);
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadFieldWithNullFieldName() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(testObject, null, true);
        });
        assertEquals("fieldName", exception.getMessage());
    }

    @Test
    void testReadFieldWithoutForceAccess() {
        String fieldName = "privateField";
        try {
            Object value = invokeReadField(testObject, fieldName, false);
            assertEquals("Hello", value);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    void testReadFieldWithForceAccess() {
        String fieldName = "privateField";
        try {
            Object value = invokeReadField(testObject, fieldName, true);
            assertEquals("Hello", value);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    // Helper method to invoke the private method using reflection
    private Object invokeReadField(Object target, String fieldName, boolean forceAccess) throws Exception {
        return FieldUtils.class.getDeclaredMethod("readField", Object.class, String.class, boolean.class).invoke(null, target, fieldName, forceAccess);
    }

    // Test class with a private field
    private static class TestClass {

        private String privateField = "Hello";
    }
}
