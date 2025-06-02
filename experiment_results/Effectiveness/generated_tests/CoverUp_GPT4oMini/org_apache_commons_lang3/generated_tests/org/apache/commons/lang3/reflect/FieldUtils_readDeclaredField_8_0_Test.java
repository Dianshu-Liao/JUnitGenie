package org.apache.commons.lang3.reflect;

import java.lang.reflect.Field;
import org.apache.commons.lang3.reflect.FieldUtils;
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

class FieldUtils_readDeclaredField_8_0_Test {

    private TestClass testObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass();
    }

    @Test
    void testReadDeclaredField_ValidField() throws IllegalAccessException {
        Object result = FieldUtils.readDeclaredField(testObject, "privateField");
        assertEquals("privateValue", result);
    }

    @Test
    void testReadDeclaredField_NonExistentField() {
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.readDeclaredField(testObject, "nonExistentField");
        });
        assertTrue(exception.getMessage().contains("Cannot locate declared field"));
    }

    @Test
    void testReadDeclaredField_NullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(null, "privateField");
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadDeclaredField_NullFieldName() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(testObject, null);
        });
        assertEquals("fieldName", exception.getMessage());
    }

    private static class TestClass {

        private String privateField = "privateValue";
    }
}
