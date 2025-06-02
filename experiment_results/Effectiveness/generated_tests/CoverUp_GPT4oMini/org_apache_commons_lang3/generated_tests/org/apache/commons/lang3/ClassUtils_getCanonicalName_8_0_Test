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

public class ClassUtils_getCanonicalName_8_0_Test {

    @Test
    public void testGetCanonicalName_withNullClass() throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Class.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, (Class<?>) null);
        assertEquals("", result);
    }

    @Test
    public void testGetCanonicalName_withPrimitiveClass() throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Class.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, int.class);
        assertEquals("int", result);
    }

    @Test
    public void testGetCanonicalName_withWrapperClass() throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Class.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, Integer.class);
        assertEquals("java.lang.Integer", result);
    }

    @Test
    public void testGetCanonicalName_withArrayClass() throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Class.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, String[].class);
        assertEquals("java.lang.String[]", result);
    }

    @Test
    public void testGetCanonicalName_withInnerClass() throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", Class.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, InnerClass.class);
        assertEquals("org.apache.commons.lang3.ClassUtils_getCanonicalName_8_0_Test$InnerClass", result);
    }

    static class InnerClass {
        // Inner class for testing
    }
}
