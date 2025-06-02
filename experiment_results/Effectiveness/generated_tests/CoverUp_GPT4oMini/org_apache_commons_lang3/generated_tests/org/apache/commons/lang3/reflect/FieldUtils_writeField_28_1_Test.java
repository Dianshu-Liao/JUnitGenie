package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class FieldUtils_writeField_28_1_Test {

    private static class TestClass {

        private String privateField = "initialValue";
    }

    @Test
    void testWriteField_Success() throws Exception {
        TestClass testObject = new TestClass();
        // Invoke the writeField method using reflection
        Method writeFieldMethod = FieldUtils.class.getDeclaredMethod("writeField", Object.class, String.class, Object.class);
        writeFieldMethod.setAccessible(true);
        writeFieldMethod.invoke(null, testObject, "privateField", "newValue");
        // Access the private field using reflection to verify the value
        Field field = TestClass.class.getDeclaredField("privateField");
        field.setAccessible(true);
        String fieldValue = (String) field.get(testObject);
        assertEquals("newValue", fieldValue);
    }

    @Test
    void testWriteField_FieldNotFound() {
        TestClass testObject = new TestClass();
        Executable executable = () -> {
            Method writeFieldMethod = FieldUtils.class.getDeclaredMethod("writeField", Object.class, String.class, Object.class);
            writeFieldMethod.setAccessible(true);
            writeFieldMethod.invoke(null, testObject, "nonExistentField", "value");
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Cannot locate declared field " + TestClass.class.getName() + ".nonExistentField", exception.getMessage());
    }

    @Test
    void testWriteField_NullTarget() {
        Executable executable = () -> {
            Method writeFieldMethod = FieldUtils.class.getDeclaredMethod("writeField", Object.class, String.class, Object.class);
            writeFieldMethod.setAccessible(true);
            writeFieldMethod.invoke(null, null, "privateField", "value");
        };
        NullPointerException exception = assertThrows(NullPointerException.class, executable);
        assertEquals("target", exception.getMessage());
    }

    @Test
    void testWriteField_NullFieldName() {
        TestClass testObject = new TestClass();
        Executable executable = () -> {
            Method writeFieldMethod = FieldUtils.class.getDeclaredMethod("writeField", Object.class, String.class, Object.class);
            writeFieldMethod.setAccessible(true);
            writeFieldMethod.invoke(null, testObject, null, "value");
        };
        NullPointerException exception = assertThrows(NullPointerException.class, executable);
        assertEquals("fieldName", exception.getMessage());
    }

    @Test
    void testWriteField_NullValue() throws Exception {
        TestClass testObject = new TestClass();
        // Invoke the writeField method with null value
        Method writeFieldMethod = FieldUtils.class.getDeclaredMethod("writeField", Object.class, String.class, Object.class);
        writeFieldMethod.setAccessible(true);
        writeFieldMethod.invoke(null, testObject, "privateField", null);
        // Access the private field using reflection to verify the value
        Field field = TestClass.class.getDeclaredField("privateField");
        field.setAccessible(true);
        String fieldValue = (String) field.get(testObject);
        assertNull(fieldValue);
    }
}
