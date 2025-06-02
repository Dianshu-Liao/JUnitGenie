package org.apache.commons.lang3.reflect;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
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

class FieldUtils_writeField_28_0_Test {

    private TestClass target;

    @BeforeEach
    void setUp() {
        target = new TestClass();
    }

    @Test
    void testWriteField_Success() throws IllegalAccessException {
        // Arrange
        String fieldName = "name";
        String value = "New Name";
        // Act
        FieldUtils.writeField(target, fieldName, value);
        // Assert
        assertEquals(value, target.getName());
    }

    @Test
    void testWriteField_FieldDoesNotExist() {
        // Arrange
        String fieldName = "nonExistentField";
        String value = "Some Value";
        // Act & Assert
        Exception exception = assertThrows(NoSuchFieldException.class, () -> {
            FieldUtils.writeField(target, fieldName, value);
        });
        assertEquals("Field nonExistentField not found", exception.getMessage());
    }

    @Test
    void testWriteField_FieldNotAccessible() {
        // Arrange
        String fieldName = "privateField";
        String value = "New Value";
        // Act & Assert
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.writeField(target, fieldName, value);
        });
        assertEquals("Field privateField is not accessible", exception.getMessage());
    }

    // Test class to be used as a target for reflection
    private static class TestClass {

        private String name = "Initial Name";

        private String privateField = "Private Value";

        public String getName() {
            return name;
        }
    }
}
