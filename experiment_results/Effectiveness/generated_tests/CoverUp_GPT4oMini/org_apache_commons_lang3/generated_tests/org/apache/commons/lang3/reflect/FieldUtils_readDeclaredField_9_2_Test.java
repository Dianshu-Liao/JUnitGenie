package org.apache.commons.lang3.reflect;

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

class FieldUtils_readDeclaredField_9_2_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";
    }

    private TestClass testObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass();
    }

    @Test
    void testReadDeclaredFieldPrivateField() throws IllegalAccessException {
        Object result = FieldUtils.readDeclaredField(testObject, "privateField", true);
        assertEquals("privateValue", result);
    }

    @Test
    void testReadDeclaredFieldPublicField() throws IllegalAccessException {
        Object result = FieldUtils.readDeclaredField(testObject, "publicField", true);
        assertEquals("publicValue", result);
    }

    @Test
    void testReadDeclaredFieldFieldNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FieldUtils.readDeclaredField(testObject, "nonExistentField", true);
        });
        assertEquals("Cannot locate declared field class FieldUtilsTest$TestClass.nonExistentField", exception.getMessage());
    }

    @Test
    void testReadDeclaredFieldNullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(null, "privateField", true);
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadDeclaredFieldNullFieldName() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(testObject, null, true);
        });
        assertEquals("fieldName", exception.getMessage());
    }

    @Test
    void testReadDeclaredFieldForceAccessFalse() throws IllegalAccessException {
        Object result = FieldUtils.readDeclaredField(testObject, "privateField", false);
        assertEquals("privateValue", result);
    }
}
