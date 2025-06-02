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

class FieldUtils_writeField_27_1_Test {

    private static class TestClass {

        private String privateField = "initialValue";
    }

    @Test
    void testWriteField_ForceAccess() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        // Act
        FieldUtils.writeField(field, target, "newValue", true);
        // Assert
        assertEquals("newValue", target.privateField);
    }

    @Test
    void testWriteField_NoForceAccess() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        // Act
        FieldUtils.writeField(field, target, "anotherValue", false);
        // Assert
        assertEquals("anotherValue", target.privateField);
    }

    @Test
    void testWriteField_NullField() {
        // Arrange
        TestClass target = new TestClass();
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            FieldUtils.writeField(null, target, "value", true);
        });
    }

    @Test
    void testWriteField_IllegalAccessException() {
        // Arrange
        TestClass target = new TestClass();
        Field field;
        try {
            field = TestClass.class.getDeclaredField("privateField");
            // Ensure the field is not accessible
            field.setAccessible(false);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        // Act & Assert
        assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.writeField(field, target, "value", false);
        });
    }
}
