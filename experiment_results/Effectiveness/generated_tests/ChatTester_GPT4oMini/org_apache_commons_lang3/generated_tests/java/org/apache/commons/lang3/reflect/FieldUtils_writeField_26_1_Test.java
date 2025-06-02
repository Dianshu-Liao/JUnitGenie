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

class FieldUtils_writeField_26_1_Test {

    private static class TestClass {

        private String field;

        public String getField() {
            return field;
        }
    }

    private TestClass target;

    @BeforeEach
    void setUp() {
        target = new TestClass();
    }

    @Test
    void testWriteField_Success() throws NoSuchFieldException, IllegalAccessException {
        Field field = TestClass.class.getDeclaredField("field");
        // Allow access to private field
        field.setAccessible(true);
        FieldUtils.writeField(field, target, "New Value");
        assertEquals("New Value", target.getField());
    }

    @Test
    void testWriteField_IllegalAccessException() {
        // Attempting to access a field that does not exist should throw an exception
        assertThrows(NoSuchFieldException.class, () -> {
            Field field = TestClass.class.getDeclaredField("nonExistentField");
            FieldUtils.writeField(field, target, "Value");
        });
    }

    @Test
    void testWriteField_NullValue() throws NoSuchFieldException, IllegalAccessException {
        Field field = TestClass.class.getDeclaredField("field");
        field.setAccessible(true);
        FieldUtils.writeField(field, target, null);
        assertNull(target.getField());
    }

    @Test
    void testWriteField_PrivateField() throws NoSuchFieldException, IllegalAccessException {
        Field field = TestClass.class.getDeclaredField("field");
        field.setAccessible(true);
        FieldUtils.writeField(field, target, "Private Value");
        assertEquals("Private Value", target.getField());
    }

    @Test
    void testWriteField_ChangeValue() throws NoSuchFieldException, IllegalAccessException {
        Field field = TestClass.class.getDeclaredField("field");
        field.setAccessible(true);
        FieldUtils.writeField(field, target, "Initial Value");
        FieldUtils.writeField(field, target, "Updated Value");
        assertEquals("Updated Value", target.getField());
    }
}
