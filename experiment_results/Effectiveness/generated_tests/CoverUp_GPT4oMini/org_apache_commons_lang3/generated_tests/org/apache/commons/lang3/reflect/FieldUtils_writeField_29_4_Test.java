package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.lang.reflect.AccessibleObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

class FieldUtils_writeField_29_4_Test {

    private static class TestClass {

        private String field;

        public String getField() {
            return field;
        }
    }

    @Test
    void testWriteField_Success() throws Exception {
        TestClass target = new TestClass();
        invokeWriteField(target, "field", "newValue", true);
        assertEquals("newValue", target.getField());
    }

    @Test
    void testWriteField_NullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeWriteField(null, "field", "value", true);
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testWriteField_FieldNotFound() {
        TestClass target = new TestClass();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeWriteField(target, "nonExistentField", "value", true);
        });
        assertTrue(exception.getMessage().contains("Cannot locate declared field"));
    }

    @Test
    void testWriteField_ForceAccess() throws Exception {
        TestClass target = new TestClass();
        invokeWriteField(target, "field", "anotherValue", true);
        assertEquals("anotherValue", target.getField());
    }

    @Test
    void testWriteField_NoForceAccess() throws Exception {
        TestClass target = new TestClass();
        invokeWriteField(target, "field", "valueWithoutForce", false);
        assertEquals("valueWithoutForce", target.getField());
    }

    @Test
    void testWriteField_WithNullValue() throws Exception {
        TestClass target = new TestClass();
        invokeWriteField(target, "field", null, true);
        assertNull(target.getField());
    }

    private void invokeWriteField(Object target, String fieldName, Object value, boolean forceAccess) throws Exception {
        Method method = FieldUtils.class.getDeclaredMethod("writeField", Object.class, String.class, Object.class, boolean.class);
        method.setAccessible(true);
        method.invoke(null, target, fieldName, value, forceAccess);
    }
}
