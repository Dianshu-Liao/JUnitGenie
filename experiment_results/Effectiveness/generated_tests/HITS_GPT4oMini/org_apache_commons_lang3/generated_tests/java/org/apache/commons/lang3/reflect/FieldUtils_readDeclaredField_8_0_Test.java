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

public class FieldUtils_readDeclaredField_8_0_Test {

    private static class TestClass {

        private String privateField = "privateValue";

        protected int protectedField = 42;

        public boolean publicField = true;
    }

    @Test
    public void testReadDeclaredFieldPrivate() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = FieldUtils.readDeclaredField(testObject, "privateField");
        assertEquals("privateValue", result);
    }

    @Test
    public void testReadDeclaredFieldProtected() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = FieldUtils.readDeclaredField(testObject, "protectedField");
        assertEquals(42, result);
    }

    @Test
    public void testReadDeclaredFieldPublic() throws IllegalAccessException {
        TestClass testObject = new TestClass();
        Object result = FieldUtils.readDeclaredField(testObject, "publicField");
        assertEquals(true, result);
    }

    @Test
    public void testReadDeclaredFieldNonExistent() {
        TestClass testObject = new TestClass();
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.readDeclaredField(testObject, "nonExistentField");
        });
        assertEquals("Cannot locate declared field " + TestClass.class.getName() + ".nonExistentField", exception.getMessage());
    }

    @Test
    public void testReadDeclaredFieldNullTarget() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.readDeclaredField(null, "fieldName");
        });
        assertEquals("target", exception.getMessage());
    }

    @Test
    public void testReadDeclaredFieldWithAccessCheck() {
        TestClass testObject = new TestClass();
        try {
            Field field = TestClass.class.getDeclaredField("privateField");
            field.setAccessible(true);
            Object result = FieldUtils.readDeclaredField(testObject, "privateField", true);
            assertEquals("privateValue", result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }
}
