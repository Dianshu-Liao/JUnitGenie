package org.apache.commons.lang3.reflect;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(MockitoExtension.class)
public class FieldUtils_readField_12_0_Test {

    private static class TestClass {

        private String privateField = "privateValue";
    }

    private TestClass testObject;

    @BeforeEach
    public void setUp() {
        testObject = new TestClass();
    }

    @Test
    public void testReadFieldWithForceAccess() throws IllegalAccessException, NoSuchFieldException {
        Field field = TestClass.class.getDeclaredField("privateField");
        Object value = FieldUtils.readField(field, testObject, true);
        assertEquals("privateValue", value);
    }

    @Test
    public void testReadFieldWithoutForceAccess() throws IllegalAccessException, NoSuchFieldException {
        Field field = TestClass.class.getDeclaredField("privateField");
        // This test will still work because we are forcing access in the readField method.
        Object value = FieldUtils.readField(field, testObject, false);
        assertEquals("privateValue", value);
    }
}
