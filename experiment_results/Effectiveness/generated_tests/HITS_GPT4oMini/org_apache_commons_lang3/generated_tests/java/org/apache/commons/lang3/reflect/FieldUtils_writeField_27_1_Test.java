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
public class FieldUtils_writeField_27_1_Test {

    private static class TestClass {

        private String privateField;
    }

    @Test
    void testWriteField_IllegalAccessException() {
        TestClass testObject = new TestClass();
        assertThrows(IllegalAccessException.class, () -> {
            Field field = TestClass.class.getDeclaredField("privateField");
            FieldUtils.writeField(field, testObject, "newValue", false);
        });
    }
}
