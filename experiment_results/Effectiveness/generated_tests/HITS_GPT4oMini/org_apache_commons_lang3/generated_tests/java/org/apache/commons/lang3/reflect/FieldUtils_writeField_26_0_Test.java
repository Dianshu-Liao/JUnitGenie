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

public class FieldUtils_writeField_26_0_Test {

    // Test case for a null field
    @Test
    public void testWriteField_NullField() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            FieldUtils.writeField(null, new TestClass(), "value");
        });
        String expectedMessage = "field";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test case for writing to a private field
    @Test
    public void testWriteField_PrivateField() throws Exception {
        TestClass target = new TestClass();
        Field field = TestClass.class.getDeclaredField("privateField");
        // Make the field accessible
        field.setAccessible(true);
        FieldUtils.writeField(field, target, "newValue");
        assertEquals("newValue", target.getPrivateField());
    }

    // Test case for writing to a public field
    @Test
    public void testWriteField_PublicField() throws Exception {
        TestClass target = new TestClass();
        Field field = TestClass.class.getField("publicField");
        FieldUtils.writeField(field, target, "newPublicValue");
        assertEquals("newPublicValue", target.publicField);
    }

    // Test class for testing purposes
    public static class TestClass {

        private String privateField = "initialValue";

        public String publicField = "initialPublicValue";

        public String getPrivateField() {
            return privateField;
        }
    }
}
