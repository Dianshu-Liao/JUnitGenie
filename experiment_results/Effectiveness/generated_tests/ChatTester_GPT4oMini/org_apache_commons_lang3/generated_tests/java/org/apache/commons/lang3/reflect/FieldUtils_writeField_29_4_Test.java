package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Field;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FieldUtils_writeField_29_4_Test {

    private TestClass target;

    @BeforeEach
    void setUp() {
        target = new TestClass();
    }

    @Test
    void testWriteField_Success() throws IllegalAccessException {
        FieldUtils.writeField(target, "privateField", "newValue", true);
        assertEquals("newValue", target.getPrivateField());
    }

    @Test
    void testWriteField_NullTarget() {
        Executable executable = () -> FieldUtils.writeField((Object) null, "privateField", "value", true);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void testWriteField_NonExistentField() {
        Executable executable = () -> FieldUtils.writeField(target, "nonExistentField", "value", true);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void testWriteField_ForceAccessFalse() throws IllegalAccessException {
        FieldUtils.writeField(target, "privateField", "newValue", false);
        assertEquals("newValue", target.getPrivateField());
    }

    @Test
    void testWriteField_FieldNotAccessible() {
        Executable executable = () -> FieldUtils.writeField(target, "privateField", "value", false);
        assertThrows(IllegalAccessException.class, executable);
    }

    private static class TestClass {

        private String privateField = "initialValue";

        public String getPrivateField() {
            return privateField;
        }
    }
}
