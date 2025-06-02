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

public class FieldUtils_readDeclaredField_9_0_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";

        protected String protectedField = "protectedValue";
    }

    @Test
    public void testReadDeclaredField_withPrivateField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) FieldUtils.readDeclaredField(testObject, "privateField", true);
        assertEquals("privateValue", result);
    }

    @Test
    public void testReadDeclaredField_withPublicField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) FieldUtils.readDeclaredField(testObject, "publicField", true);
        assertEquals("publicValue", result);
    }

    @Test
    public void testReadDeclaredField_withProtectedField() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        String result = (String) FieldUtils.readDeclaredField(testObject, "protectedField", true);
        assertEquals("protectedValue", result);
    }

    @Test
    public void testReadDeclaredField_fieldNotFound() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FieldUtils.readDeclaredField(testObject, "nonExistentField", true);
        });
        assertEquals("Cannot locate declared field class org.apache.commons.lang3.reflect.FieldUtils_Test$TestClass.nonExistentField", exception.getMessage());
    }

    @Test
    public void testReadDeclaredField_withNullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(null, "fieldName", true);
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    public void testReadDeclaredField_withNullFieldName() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(testObject, null, true);
        });
        assertEquals("fieldName", exception.getMessage());
    }
}
