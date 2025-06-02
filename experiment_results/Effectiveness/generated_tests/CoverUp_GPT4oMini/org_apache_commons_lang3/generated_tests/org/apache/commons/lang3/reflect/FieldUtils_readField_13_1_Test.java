package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

class FieldUtils_readField_13_1_Test {

    private TestClass testObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass();
    }

    @Test
    void testReadFieldAccessible() throws Exception {
        Field field = TestClass.class.getDeclaredField("accessibleField");
        Object value = invokeReadField(field, testObject, false);
        assertEquals("accessibleValue", value);
    }

    @Test
    void testReadFieldNonAccessibleWithForceAccess() throws Exception {
        Field field = TestClass.class.getDeclaredField("nonAccessibleField");
        Object value = invokeReadField(field, testObject, true);
        assertEquals("nonAccessibleValue", value);
    }

    @Test
    void testReadFieldNonAccessibleWithoutForceAccess() throws Exception {
        Field field = TestClass.class.getDeclaredField("nonAccessibleField");
        assertThrows(IllegalAccessException.class, () -> {
            invokeReadField(field, testObject, false);
        });
    }

    @Test
    void testReadFieldNullField() {
        assertThrows(NullPointerException.class, () -> {
            invokeReadField(null, testObject, false);
        });
    }

    @Test
    void testReadFieldNullTarget() throws Exception {
        Field field = TestClass.class.getDeclaredField("accessibleField");
        assertThrows(NullPointerException.class, () -> {
            invokeReadField(field, null, false);
        });
    }

    private Object invokeReadField(Field field, Object target, boolean forceAccess) throws Exception {
        return FieldUtils.class.getDeclaredMethod("readField", Field.class, Object.class, boolean.class).invoke(null, field, target, forceAccess);
    }

    private static class TestClass {

        public String accessibleField = "accessibleValue";

        private String nonAccessibleField = "nonAccessibleValue";
    }
}
