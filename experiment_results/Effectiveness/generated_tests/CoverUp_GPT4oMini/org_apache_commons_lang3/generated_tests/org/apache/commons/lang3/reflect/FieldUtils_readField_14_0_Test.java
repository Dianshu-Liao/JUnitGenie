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

class FieldUtils_readField_14_0_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";
    }

    @Test
    void testReadPrivateField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = invokeReadField(testObject, "privateField");
        assertEquals("privateValue", result);
    }

    @Test
    void testReadPublicField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = invokeReadField(testObject, "publicField");
        assertEquals("publicValue", result);
    }

    @Test
    void testReadNonExistentField() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            invokeReadField(testObject, "nonExistentField");
        });
        assertTrue(exception.getMessage().contains("Cannot locate field nonExistentField on"));
    }

    @Test
    void testReadFieldWithNullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(null, "fieldName");
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadFieldWithNullFieldName() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(testObject, null);
        });
        assertEquals("fieldName", exception.getMessage());
    }

    @Test
    void testReadFieldWithEmptyFieldName() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            invokeReadField(testObject, "");
        });
        assertTrue(exception.getMessage().contains("Cannot locate field  on"));
    }

    private Object invokeReadField(Object target, String fieldName) throws IllegalAccessException {
        try {
            return FieldUtils.class.getDeclaredMethod("readField", Object.class, String.class).invoke(null, target, fieldName);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
