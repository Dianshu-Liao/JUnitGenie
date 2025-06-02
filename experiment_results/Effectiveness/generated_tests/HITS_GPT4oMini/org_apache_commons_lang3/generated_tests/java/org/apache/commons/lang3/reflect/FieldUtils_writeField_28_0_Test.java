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

public class FieldUtils_writeField_28_0_Test {

    @Test
    public void testWriteField_NullTarget() {
        // Arrange
        String fieldName = "someField";
        Object value = "someValue";
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            FieldUtils.writeField((Object) null, fieldName, value);
        }, "Expected writeField to throw, but it didn't");
    }

    @Test
    public void testWriteField_NonExistentField() {
        // Arrange
        TestClass target = new TestClass();
        String fieldName = "nonExistentField";
        Object value = "someValue";
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            FieldUtils.writeField(target, fieldName, value);
        }, "Expected writeField to throw, but it didn't");
    }

    @Test
    public void testWriteField_ValidField() throws IllegalAccessException {
        // Arrange
        TestClass target = new TestClass();
        String fieldName = "someField";
        Object value = "newValue";
        // Act
        FieldUtils.writeField(target, fieldName, value);
        // Assert
        assertEquals(value, target.getSomeField(), "Field value should be updated");
    }

    private static class TestClass {

        private String someField = "initialValue";

        public String getSomeField() {
            return someField;
        }
    }
}
