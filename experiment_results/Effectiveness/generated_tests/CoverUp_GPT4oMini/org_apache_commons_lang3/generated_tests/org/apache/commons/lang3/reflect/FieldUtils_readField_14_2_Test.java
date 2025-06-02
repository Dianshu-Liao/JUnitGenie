package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Method;
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

class FieldUtils_readField_14_2_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        public String publicField = "publicValue";
    }

    @Test
    void testReadFieldPrivateField() {
        TestClass testObject = new TestClass();
        try {
            Object result = invokeReadField(testObject, "privateField");
            assertEquals("privateValue", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    void testReadFieldPublicField() {
        TestClass testObject = new TestClass();
        try {
            Object result = invokeReadField(testObject, "publicField");
            assertEquals("publicValue", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    void testReadFieldFieldNotFound() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            invokeReadField(testObject, "nonExistentField");
        });
        assertEquals("Cannot locate field nonExistentField on class org.apache.commons.lang3.reflect.FieldUtils_readField_14_2_Test$TestClass", exception.getMessage());
    }

    @Test
    void testReadFieldNullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeReadField(null, "fieldName");
        });
        assertEquals("target", exception.getMessage());
    }

    private Object invokeReadField(Object target, String fieldName) throws Exception {
        Method method = FieldUtils.class.getDeclaredMethod("readField", Object.class, String.class);
        method.setAccessible(true);
        return method.invoke(null, target, fieldName);
    }
}
