package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.ClassUtils;
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
import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.apache.commons.lang3.Validate;

public class MethodUtils_distance_0_0_Test {

    @Test
    public void testDistance_WhenClassesAreNull_ReturnsZero() {
        Class<?>[] fromClasses = { null, null };
        Class<?>[] toClasses = { null, null };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(0, result);
    }

    @Test
    public void testDistance_WhenClassesAreAssignable_ReturnsZero() {
        Class<?>[] fromClasses = { Number.class, Integer.class };
        Class<?>[] toClasses = { Number.class, Integer.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(0, result);
    }

    @Test
    public void testDistance_WhenClassesAreNotAssignable_ReturnsNegativeOne() {
        Class<?>[] fromClasses = { String.class };
        Class<?>[] toClasses = { Integer.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(-1, result);
    }

    @Test
    public void testDistance_WhenClassesAreDifferentButAssignable_ReturnsOne() {
        Class<?>[] fromClasses = { Integer.class };
        Class<?>[] toClasses = { Number.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(1, result);
    }

    @Test
    public void testDistance_WhenClassesAreDifferentAndNotAssignable_ReturnsTwo() {
        Class<?>[] fromClasses = { String.class };
        Class<?>[] toClasses = { Object.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(2, result);
    }

    private int invokeDistance(Class<?>[] fromClassArray, Class<?>[] toClassArray) {
        try {
            Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
            method.setAccessible(true);
            return (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
