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

    private class TestClass {

        private String privateField = "testValue";

        public String publicField = "publicValue";
    }

    private TestClass testObject;

    @BeforeEach
    public void setUp() {
        testObject = new TestClass();
    }

    @Test
    public void testReadDeclaredField_PrivateField() throws IllegalAccessException {
        Object value = FieldUtils.readDeclaredField(testObject, "privateField");
        assertEquals("testValue", value);
    }

    @Test
    public void testReadDeclaredField_PublicField() throws IllegalAccessException {
        Object value = FieldUtils.readDeclaredField(testObject, "publicField");
        assertEquals("publicValue", value);
    }

    @Test
    public void testReadDeclaredField_NonExistentField() {
        assertThrows(NoSuchFieldException.class, () -> {
            FieldUtils.readDeclaredField(testObject, "nonExistentField");
        });
    }

    @Test
    public void testReadDeclaredField_IllegalAccess() {
        assertThrows(IllegalAccessException.class, () -> {
            // Attempting to access a private field of a different class
            Field privateField = TestClass.class.getDeclaredField("privateField");
            // Ensure the field is not accessible
            privateField.setAccessible(false);
            FieldUtils.readDeclaredField(testObject, "privateField");
        });
    }
}
