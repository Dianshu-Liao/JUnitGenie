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

    private static ClassUtils classUtils;

    @BeforeAll
    public static void setUp() {
        classUtils = new ClassUtils();
    }

    @Test
    public void testPrimitiveToWrapper_int() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(int.class);
        assertEquals(Integer.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_long() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(long.class);
        assertEquals(Long.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_double() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(double.class);
        assertEquals(Double.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_float() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(float.class);
        assertEquals(Float.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_char() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(char.class);
        assertEquals(Character.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_byte() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(byte.class);
        assertEquals(Byte.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_short() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(short.class);
        assertEquals(Short.class, result);
    }

    @Test
    public void testPrimitiveToWrapper_void() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(void.class);
        assertNull(result);
    }

    @Test
    public void testPrimitiveToWrapper_Null() throws Exception {
        Class<?> result = invokePrimitiveToWrapper(null);
        assertNull(result);
    }

    private Class<?> invokePrimitiveToWrapper(Class<?> cls) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("primitiveToWrapper", Class.class);
        method.setAccessible(true);
        return (Class<?>) method.invoke(classUtils, cls);
    }
}
