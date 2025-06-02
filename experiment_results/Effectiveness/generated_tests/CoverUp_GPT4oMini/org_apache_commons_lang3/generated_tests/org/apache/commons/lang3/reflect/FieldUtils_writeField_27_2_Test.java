package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MemberUtils;
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

class FieldUtils_writeField_27_2_Test {

    private TestClass target;

    @BeforeEach
    void setUp() {
        target = new TestClass();
    }

    @Test
    void testWriteField_withAccessibleField() throws Exception {
        Field field = TestClass.class.getDeclaredField("accessibleField");
        FieldUtils.writeField(field, target, "newValue", false);
        assertEquals("newValue", target.getAccessibleField());
    }

    @Test
    void testWriteField_withNonAccessibleField_andForceAccessTrue() throws Exception {
        Field field = TestClass.class.getDeclaredField("nonAccessibleField");
        FieldUtils.writeField(field, target, "newValue", true);
        assertEquals("newValue", target.getNonAccessibleField());
    }

    @Test
    void testWriteField_withNonAccessibleField_andForceAccessFalse() throws Exception {
        Field field = TestClass.class.getDeclaredField("nonAccessibleField");
        assertThrows(IllegalAccessException.class, () -> {
            FieldUtils.writeField(field, target, "newValue", false);
        });
    }

    @Test
    void testWriteField_withNullField() {
        assertThrows(NullPointerException.class, () -> {
            FieldUtils.writeField(null, target, "value", true);
        });
    }

    private static class TestClass {

        public String accessibleField = "initialValue";

        private String nonAccessibleField = "initialValue";

        public String getAccessibleField() {
            return accessibleField;
        }

        public String getNonAccessibleField() {
            return nonAccessibleField;
        }
    }
}
