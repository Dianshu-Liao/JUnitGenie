package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.AccessibleObject;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
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

class FieldUtils_writeField_26_0_Test {

    private static class TestClass {

        private String privateField = "initialValue";
    }

    @Test
    void testWriteField_ValidField_Success() throws Exception {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        String newValue = "newValue";
        // Act
        invokeWriteField(field, target, newValue);
        // Assert
        assertEquals(newValue, field.get(target));
    }

    @Test
    void testWriteField_NullField_ThrowsException() {
        // Arrange
        TestClass target = new TestClass();
        Object value = "someValue";
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            invokeWriteField(null, target, value);
        });
    }

    @Test
    void testWriteField_NullTarget_ThrowsException() throws Exception {
        // Arrange
        Field field = TestClass.class.getDeclaredField("privateField");
        Object value = "someValue";
        // Act & Assert
        assertThrows(IllegalAccessException.class, () -> {
            invokeWriteField(field, null, value);
        });
    }

    @Test
    void testWriteField_NullValue_Success() throws Exception {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        // Act
        invokeWriteField(field, target, null);
        // Assert
        assertNull(field.get(target));
    }

    @Test
    void testWriteField_ForceAccess_Success() throws Exception {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        String newValue = "newValue";
        // Act
        invokeWriteField(field, target, newValue, true);
        // Assert
        assertEquals(newValue, field.get(target));
    }

    @Test
    void testWriteField_FieldNotAccessible_ForceAccess_Success() throws Exception {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        String newValue = "newValue";
        // Act
        invokeWriteField(field, target, newValue, true);
        // Assert
        assertEquals(newValue, field.get(target));
    }

    @Test
    void testWriteField_FieldNotAccessible_NoForceAccess_Success() throws Exception {
        // Arrange
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        String newValue = "newValue";
        // Act
        invokeWriteField(field, target, newValue, false);
        // Assert
        assertEquals(newValue, field.get(target));
    }

    private void invokeWriteField(Field field, Object target, Object value) throws Exception {
        Method method = FieldUtils.class.getDeclaredMethod("writeField", Field.class, Object.class, Object.class);
        method.setAccessible(true);
        method.invoke(null, field, target, value);
    }

    private void invokeWriteField(Field field, Object target, Object value, boolean force) throws Exception {
        Method method = FieldUtils.class.getDeclaredMethod("writeField", Field.class, Object.class, Object.class, boolean.class);
        method.setAccessible(true);
        method.invoke(null, field, target, value, force);
    }
}
