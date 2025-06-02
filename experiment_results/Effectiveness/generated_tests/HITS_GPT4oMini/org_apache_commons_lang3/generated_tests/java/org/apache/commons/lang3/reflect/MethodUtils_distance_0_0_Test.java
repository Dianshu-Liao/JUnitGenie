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

    private Method distanceMethod;

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        distanceMethod = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
        // Allow access to the private method
        distanceMethod.setAccessible(true);
    }

    private int invokeDistance(Class<?>[] fromClasses, Class<?>[] toClasses) throws Exception {
        return (int) distanceMethod.invoke(null, (Object) fromClasses, (Object) toClasses);
    }

    @Test
    public void testDistance_SameClasses() throws Exception {
        Class<?>[] fromClasses = { String.class, Integer.class };
        Class<?>[] toClasses = { String.class, Integer.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(0, result);
    }

    @Test
    public void testDistance_Superclass() throws Exception {
        Class<?>[] fromClasses = { ArrayList.class, Number.class };
        Class<?>[] toClasses = { List.class, Object.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(2, result);
    }

    @Test
    public void testDistance_Subclass() throws Exception {
        Class<?>[] fromClasses = { List.class, Object.class };
        Class<?>[] toClasses = { ArrayList.class, Number.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(2, result);
    }

    @Test
    public void testDistance_NonAssignable() throws Exception {
        Class<?>[] fromClasses = { String.class, Integer.class };
        Class<?>[] toClasses = { Object.class, Double.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(-1, result);
    }

    @Test
    public void testDistance_NullClasses() throws Exception {
        Class<?>[] fromClasses = { null, Integer.class };
        Class<?>[] toClasses = { null, Integer.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(0, result);
    }

    @Test
    public void testDistance_MixedNulls() throws Exception {
        Class<?>[] fromClasses = { String.class, null };
        Class<?>[] toClasses = { String.class, Integer.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(1, result);
    }

    @Test
    public void testDistance_Autoboxing() throws Exception {
        Class<?>[] fromClasses = { int.class, Integer.class };
        Class<?>[] toClasses = { Integer.class, Number.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(1, result);
    }

    @Test
    public void testDistance_DifferentSizes() throws Exception {
        Class<?>[] fromClasses = { String.class };
        Class<?>[] toClasses = { String.class, Integer.class };
        int result = invokeDistance(fromClasses, toClasses);
        assertEquals(-1, result);
    }
}
