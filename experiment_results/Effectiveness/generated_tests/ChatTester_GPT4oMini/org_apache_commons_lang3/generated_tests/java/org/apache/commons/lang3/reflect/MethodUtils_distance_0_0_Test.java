package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

public class MethodUtils_distance_0_0_Test {

    @Test
    public void testDistance_SameClasses() throws Exception {
        Class<?>[] fromClassArray = { String.class, Integer.class };
        Class<?>[] toClassArray = { String.class, Integer.class };
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(0, result);
    }

    @Test
    public void testDistance_Assignables() throws Exception {
        Class<?>[] fromClassArray = { Number.class, Integer.class };
        Class<?>[] toClassArray = { Object.class, Number.class };
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(2, result);
    }

    @Test
    public void testDistance_NonAssignable() throws Exception {
        Class<?>[] fromClassArray = { String.class, Integer.class };
        Class<?>[] toClassArray = { Object.class, Double.class };
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(4, result);
    }

    @Test
    public void testDistance_NullClass() throws Exception {
        Class<?>[] fromClassArray = { null, Integer.class };
        Class<?>[] toClassArray = { String.class, Integer.class };
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(2, result);
    }

    @Test
    public void testDistance_NotAssignable() throws Exception {
        Class<?>[] fromClassArray = { String.class };
        Class<?>[] toClassArray = { Integer.class };
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(-1, result);
    }

    @Test
    public void testDistance_EmptyArrays() throws Exception {
        Class<?>[] fromClassArray = {};
        Class<?>[] toClassArray = {};
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(0, result);
    }

    @Test
    public void testDistance_DifferentLengthArrays() throws Exception {
        Class<?>[] fromClassArray = { String.class };
        Class<?>[] toClassArray = { String.class, Integer.class };
        Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        assertEquals(-1, result);
    }
}
