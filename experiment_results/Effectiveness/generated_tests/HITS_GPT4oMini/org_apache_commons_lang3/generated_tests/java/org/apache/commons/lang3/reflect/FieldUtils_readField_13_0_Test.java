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

public class FieldUtils_readField_13_0_Test {

    private class TestClass {

        private String privateField = "value";
    }

    @Test
    public void testReadField_WithNullField_ShouldThrowException() {
        TestClass target = new TestClass();
        assertThrows(NullPointerException.class, () -> {
            FieldUtils.readField(null, target, true);
        });
    }

    @Test
    public void testReadField_WithValidField_ShouldReturnFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Field field = TestClass.class.getDeclaredField("privateField");
        TestClass target = new TestClass();
        Object result = FieldUtils.readField(field, target, true);
        assertEquals("value", result);
    }

    @Test
    public void testReadField_WithNonAccessibleField_ShouldAccessFieldWhenForceAccessTrue() throws NoSuchFieldException, IllegalAccessException {
        Field field = TestClass.class.getDeclaredField("privateField");
        TestClass target = new TestClass();
        Object result = FieldUtils.readField(field, target, true);
        assertEquals("value", result);
    }

    @Test
    public void testReadField_WithNonAccessibleFieldAndForceAccessFalse_ShouldThrowException() throws NoSuchFieldException {
        Field field = TestClass.class.getDeclaredField("privateField");
        TestClass target = new TestClass();
        assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.readField(field, target, false);
        });
    }
}
