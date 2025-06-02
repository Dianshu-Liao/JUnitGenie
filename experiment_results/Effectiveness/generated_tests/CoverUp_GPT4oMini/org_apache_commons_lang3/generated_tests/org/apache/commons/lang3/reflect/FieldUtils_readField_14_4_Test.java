package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class FieldUtils_readField_14_4_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";

        protected String protectedField = "protectedValue";
    }

    @Test
    void testReadField_PrivateField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = invokeReadField(testObject, "privateField");
        assertEquals("privateValue", result);
    }

    @Test
    void testReadField_PublicField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = invokeReadField(testObject, "publicField");
        assertEquals("publicValue", result);
    }

    @Test
    void testReadField_ProtectedField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = invokeReadField(testObject, "protectedField");
        assertEquals("protectedValue", result);
    }

    @Test
    void testReadField_NonExistentField() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            invokeReadField(testObject, "nonExistentField");
        });
        assertEquals("Cannot locate field nonExistentField on class org.apache.commons.lang3.reflect.FieldUtils_readField_14_4_Test$TestClass", exception.getMessage());
    }

    @Test
    void testReadField_NullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(null, "fieldName");
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadField_EmptyFieldName() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeReadField(testObject, "");
        });
        assertTrue(exception.getMessage().contains("fieldName must not be empty"));
    }

    private Object invokeReadField(Object target, String fieldName) throws IllegalAccessException {
        if (target == null) {
            throw new NullPointerException("target");
        }
        if (fieldName == null || fieldName.isEmpty()) {
            throw new IllegalArgumentException("fieldName must not be empty");
        }
        Field field;
        try {
            field = target.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new IllegalAccessException("Cannot locate field " + fieldName + " on class " + target.getClass().getName());
        }
        field.setAccessible(true);
        return field.get(target);
    }
}
