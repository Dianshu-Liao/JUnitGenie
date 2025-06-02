package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FieldUtils_readField_14_3_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";
    }

    @Test
    void testReadPrivateField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = FieldUtils.readField(testObject, "privateField");
        assertEquals("privateValue", result);
    }

    @Test
    void testReadPublicField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = FieldUtils.readField(testObject, "publicField");
        assertEquals("publicValue", result);
    }

    @Test
    void testReadNonExistentField() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.class.getDeclaredMethod("readField", Object.class, String.class).invoke(null, testObject, "nonExistentField");
        });
        assertTrue(exception.getMessage().contains("Cannot locate field nonExistentField"));
    }

    @Test
    void testReadFieldWithNullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.class.getDeclaredMethod("readField", Object.class, String.class).invoke(null, null, "fieldName");
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testReadFieldWithNullFieldName() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.class.getDeclaredMethod("readField", Object.class, String.class).invoke(null, testObject, null);
        });
        assertEquals("fieldName", exception.getMessage());
    }
}
