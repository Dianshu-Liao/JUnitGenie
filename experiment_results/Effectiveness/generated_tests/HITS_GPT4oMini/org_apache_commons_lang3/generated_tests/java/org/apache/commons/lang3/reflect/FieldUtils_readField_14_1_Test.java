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

public class FieldUtils_readField_14_1_Test {

    @Test
    public void testReadField_NonNullTarget() throws IllegalAccessException {
        // Arrange
        TestClass target = new TestClass();
        String fieldName = "privateField";
        target.setPrivateField("testValue");
        // Act
        Object result = FieldUtils.readField(target, fieldName);
        // Assert
        assertEquals("testValue", result);
    }

    @Test
    public void testReadField_NullTarget() {
        // Arrange
        Object target = null;
        String fieldName = "someField";
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FieldUtils.readField(target, fieldName);
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    public void testReadField_InvalidFieldName() {
        // Arrange
        TestClass target = new TestClass();
        String fieldName = "nonExistentField";
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FieldUtils.readField(target, fieldName);
        });
        assertEquals("Cannot locate field nonExistentField on class org.apache.commons.lang3.reflect.FieldUtils_Test$TestClass", exception.getMessage());
    }

    private static class TestClass {

        private String privateField;

        public String getPrivateField() {
            return privateField;
        }

        public void setPrivateField(String privateField) {
            this.privateField = privateField;
        }
    }
}
