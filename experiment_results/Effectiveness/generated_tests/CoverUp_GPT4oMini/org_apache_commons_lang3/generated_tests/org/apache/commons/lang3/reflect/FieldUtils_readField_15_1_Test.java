package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
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

class FieldUtils_readField_15_1_Test {

    private static class TestClass {

        private String privateField = "testValue";

        public String publicField = "publicValue";
    }

    @Test
    void testReadFieldWithPrivateField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String fieldName = "privateField";
        Object result = invokeReadField(testObject, fieldName, true);
        assertEquals("testValue", result);
    }

    @Test
    void testReadFieldWithPublicField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String fieldName = "publicField";
        Object result = invokeReadField(testObject, fieldName, true);
        assertEquals("publicValue", result);
    }

    @Test
    void testReadFieldWithNonExistentField() {
        TestClass testObject = new TestClass();
        String fieldName = "nonExistentField";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeReadField(testObject, fieldName, true);
        });
        assertEquals("Cannot locate field nonExistentField on class FieldUtils_readField_15_1_Test$TestClass", exception.getMessage());
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
        TestClass testObject = new TestClass();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(testObject, null, true);
        });
        assertEquals("fieldName", exception.getMessage());
    }

    @Test
    void testReadFieldWithForceAccessFalse() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String fieldName = "privateField";
        Object result = invokeReadField(testObject, fieldName, false);
        assertEquals("testValue", result);
    }

    private Object invokeReadField(Object target, String fieldName, boolean forceAccess) throws IllegalAccessException {
        try {
            return FieldUtils.readField(target, fieldName, forceAccess);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
