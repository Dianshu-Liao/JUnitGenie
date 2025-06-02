package org.apache.commons.lang3;

import org.apache.commons.lang3.ClassUtils;
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

public class ClassUtils_getCanonicalName_12_0_Test {

    @Test
    public void testGetCanonicalName_WithArray() throws Exception {
        String input = "[[Lcom.example.MyClass;";
        String expected = "com.example.MyClass[][]";
        String actual = invokeGetCanonicalName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithSingleClass() throws Exception {
        String input = "Lcom.example.MyClass;";
        String expected = "com.example.MyClass";
        String actual = invokeGetCanonicalName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithPrimitiveArray() throws Exception {
        String input = "[I";
        String expected = "int[]";
        String actual = invokeGetCanonicalName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithPrimitive() throws Exception {
        String input = "I";
        String expected = "int";
        String actual = invokeGetCanonicalName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithAbbreviation() throws Exception {
        String input = "Z";
        String expected = "boolean";
        String actual = invokeGetCanonicalName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithWhitespace() throws Exception {
        String input = "  Lcom.example.MyClass;  ";
        String expected = "com.example.MyClass";
        String actual = invokeGetCanonicalName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithNull() throws Exception {
        String input = null;
        String actual = invokeGetCanonicalName(input);
        Assertions.assertNull(actual);
    }

    private String invokeGetCanonicalName(String className) throws Exception {
        Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, className);
    }
}
