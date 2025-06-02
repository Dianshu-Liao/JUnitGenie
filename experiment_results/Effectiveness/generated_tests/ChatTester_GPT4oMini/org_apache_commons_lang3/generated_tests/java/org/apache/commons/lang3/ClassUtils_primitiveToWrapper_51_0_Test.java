package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils_primitiveToWrapper_51_0_Test {

    private static Class<?> integerClass;

    private static Class<?> intClass;

    private static Class<?> stringClass;

    private static Class<?> booleanClass;

    @BeforeAll
    public static void setUp() {
        integerClass = Integer.class;
        intClass = int.class;
        stringClass = String.class;
        booleanClass = boolean.class;
        // Initialize the primitiveWrapperMap for testing purposes
        try {
            Method method = ClassUtils.class.getDeclaredMethod("initializePrimitiveWrapperMap");
            method.setAccessible(true);
            method.invoke(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPrimitiveToWrapper_withPrimitiveInt() {
        Class<?> result = ClassUtils.primitiveToWrapper(intClass);
        Assertions.assertEquals(integerClass, result);
    }

    @Test
    public void testPrimitiveToWrapper_withWrapperInteger() {
        Class<?> result = ClassUtils.primitiveToWrapper(integerClass);
        Assertions.assertEquals(integerClass, result);
    }

    @Test
    public void testPrimitiveToWrapper_withNull() {
        Class<?> result = ClassUtils.primitiveToWrapper(null);
        Assertions.assertNull(result);
    }

    @Test
    public void testPrimitiveToWrapper_withNonPrimitive() {
        Class<?> result = ClassUtils.primitiveToWrapper(stringClass);
        Assertions.assertEquals(stringClass, result);
    }

    @Test
    public void testPrimitiveToWrapper_withPrimitiveBoolean() {
        Class<?> result = ClassUtils.primitiveToWrapper(booleanClass);
        Assertions.assertEquals(Boolean.class, result);
    }
}
