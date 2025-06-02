package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
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

class FieldUtils_readDeclaredField_9_0_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        protected int protectedField = 42;

        public double publicField = 3.14;

        private String getPrivateField() {
            return privateField;
        }
    }

    @Test
    void testReadDeclaredFieldWithValidPrivateField() throws IllegalAccessException {
        TestClass target = new TestClass();
        Object result = FieldUtils.readDeclaredField(target, "privateField", true);
        assertEquals("privateValue", result);
    }

    @Test
    void testReadDeclaredFieldWithValidProtectedField() throws IllegalAccessException {
        TestClass target = new TestClass();
        Object result = FieldUtils.readDeclaredField(target, "protectedField", true);
        assertEquals(42, result);
    }

    @Test
    void testReadDeclaredFieldWithValidPublicField() throws IllegalAccessException {
        TestClass target = new TestClass();
        Object result = FieldUtils.readDeclaredField(target, "publicField", true);
        assertEquals(3.14, result);
    }

    @Test
    void testReadDeclaredFieldWithInvalidField() {
        TestClass target = new TestClass();
        Executable executable = () -> FieldUtils.readDeclaredField(target, "invalidField", true);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertTrue(exception.getMessage().contains("Cannot locate declared field"));
    }

    @Test
    void testReadDeclaredFieldWithNullTarget() {
        Executable executable = () -> FieldUtils.readDeclaredField(null, "privateField", true);
        Exception exception = assertThrows(NullPointerException.class, executable);
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadDeclaredFieldWithNullFieldName() {
        TestClass target = new TestClass();
        Executable executable = () -> FieldUtils.readDeclaredField(target, null, true);
        Exception exception = assertThrows(NullPointerException.class, executable);
        assertEquals("fieldName", exception.getMessage());
    }
}
