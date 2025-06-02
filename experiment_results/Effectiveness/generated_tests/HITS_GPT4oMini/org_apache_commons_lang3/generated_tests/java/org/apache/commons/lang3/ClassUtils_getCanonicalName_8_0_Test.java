package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

    static class OuterClass {

        static class InnerClass {
        }
    }

    @Test
    public void testGetCanonicalName_WithPrimitiveClass() {
        String result = ClassUtils.getCanonicalName(int.class);
        assertEquals("int", result);
    }

    @Test
    public void testGetCanonicalName_WithWrapperClass() {
        String result = ClassUtils.getCanonicalName(Integer.class);
        assertEquals("java.lang.Integer", result);
    }

    @Test
    public void testGetCanonicalName_WithArrayClass() {
        String result = ClassUtils.getCanonicalName(int[].class);
        assertEquals("int[]", result);
    }

    @Test
    public void testGetCanonicalName_WithInnerClass() {
        String result = ClassUtils.getCanonicalName(OuterClass.InnerClass.class);
        assertEquals("org.apache.commons.lang3.ClassUtils$InnerClass", result);
    }

    @Test
    public void testGetCanonicalName_WithAnonymousClass() {
        String result = ClassUtils.getCanonicalName(new Object() {
        }.getClass());
        assertEquals("org.apache.commons.lang3.ClassUtils$1", result);
    }

    @Test
    public void testGetCanonicalName_WithNullClass() {
        String result = ClassUtils.getCanonicalName(null);
        assertNull(result);
    }

    @Test
    public void testGetCanonicalName_WithStringClass() {
        String result = ClassUtils.getCanonicalName(String.class);
        assertEquals("java.lang.String", result);
    }
}
