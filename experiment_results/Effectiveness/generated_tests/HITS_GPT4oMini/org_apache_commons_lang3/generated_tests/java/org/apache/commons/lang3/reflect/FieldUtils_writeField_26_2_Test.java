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

public class FieldUtils_writeField_26_2_Test {

    private TestClass testObject;

    private Field field;

    @BeforeEach
    public void setUp() throws NoSuchFieldException {
        testObject = new TestClass();
        field = TestClass.class.getDeclaredField("value");
    }

    @Test
    public void testWriteField_ValidField_SetsValue() throws IllegalAccessException {
        FieldUtils.writeField(field, testObject, "New Value");
        assertEquals("New Value", testObject.getValue());
    }

    @Test
    public void testWriteField_NullValue_SetsValueToNull() throws IllegalAccessException {
        FieldUtils.writeField(field, testObject, null);
        assertNull(testObject.getValue());
    }

    @Test
    public void testWriteField_ForceAccess_SetsValue() throws IllegalAccessException {
        field.setAccessible(false);
        FieldUtils.writeField(field, testObject, "Forced Access Value", true);
        assertEquals("Forced Access Value", testObject.getValue());
    }

    @Test
    public void testWriteField_FieldNotAccessible_ThrowsException() {
        field.setAccessible(false);
        assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.writeField(field, testObject, "Some Value");
        });
    }

    @Test
    public void testWriteField_InvalidField_ThrowsException() {
        assertThrows(IllegalAccessException.class, () -> {
            Field invalidField = TestClass.class.getDeclaredField("nonExistentField");
            FieldUtils.writeField(invalidField, testObject, "Value");
        });
    }

    private static class TestClass {

        private String value;

        public String getValue() {
            return value;
        }
    }
}
