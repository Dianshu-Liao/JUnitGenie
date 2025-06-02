package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class FieldUtils_readDeclaredField_9_1_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";
    }

    @Test
    void testReadDeclaredField_WithPrivateField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) FieldUtils.readDeclaredField(testObject, "privateField", true);
        assertEquals("privateValue", result);
    }

    @Test
    void testReadDeclaredField_WithPublicField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) FieldUtils.readDeclaredField(testObject, "publicField", true);
        assertEquals("publicValue", result);
    }

    @Test
    void testReadDeclaredField_FieldNotFound() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FieldUtils.readDeclaredField(testObject, "nonExistentField", true);
        });
        assertEquals("Cannot locate declared field class org.apache.commons.lang3.reflect.FieldUtils_readDeclaredField_9_1_Test$TestClass.nonExistentField", exception.getMessage());
    }

    @Test
    void testReadDeclaredField_NullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(null, "fieldName", true);
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadDeclaredField_NullFieldName() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(testObject, null, true);
        });
        assertEquals("fieldName", exception.getMessage());
    }

    @Test
    void testReadDeclaredField_WithForceAccessFalse() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) FieldUtils.readDeclaredField(testObject, "privateField", false);
        assertEquals("privateValue", result);
    }
}
