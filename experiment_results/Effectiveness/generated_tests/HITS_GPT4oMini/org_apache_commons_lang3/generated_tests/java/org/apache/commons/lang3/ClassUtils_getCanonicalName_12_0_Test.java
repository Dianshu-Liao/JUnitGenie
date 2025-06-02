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

public class ClassUtils_getCanonicalName_12_0_Test {

    @Test
    public void testGetCanonicalName_NullInput() {
        // Test with null input
        String result = ClassUtils.getCanonicalName(null);
        assertNull(result, "Expected null for null input");
    }

    @Test
    public void testGetCanonicalName_EmptyString() {
        // Test with empty string
        String result = ClassUtils.getCanonicalName("");
        assertEquals("", result, "Expected empty string for empty input");
    }

    @Test
    public void testGetCanonicalName_SimpleClassName() {
        // Test with a simple class name
        String result = ClassUtils.getCanonicalName("MyClass");
        assertEquals("MyClass", result, "Expected canonical name to be 'MyClass'");
    }

    @Test
    public void testGetCanonicalName_PrimitiveType() {
        // Test with a primitive type
        String result = ClassUtils.getCanonicalName("int");
        assertEquals("int", result, "Expected canonical name to be 'int'");
    }

    @Test
    public void testGetCanonicalName_ArrayType() {
        // Test with an array type
        String result = ClassUtils.getCanonicalName("[I");
        assertEquals("int[]", result, "Expected canonical name for int array to be 'int[]'");
    }

    @Test
    public void testGetCanonicalName_ObjectArrayType() {
        // Test with an object array type
        String result = ClassUtils.getCanonicalName("[Ljava.lang.String;");
        assertEquals("java.lang.String[]", result, "Expected canonical name for String array to be 'java.lang.String[]'");
    }

    @Test
    public void testGetCanonicalName_InnerClass() {
        // Test with an inner class
        String result = ClassUtils.getCanonicalName("MyClass$InnerClass");
        assertEquals("MyClass.InnerClass", result, "Expected canonical name for inner class to be 'MyClass.InnerClass'");
    }

    @Test
    public void testGetCanonicalName_ClassWithWhitespace() {
        // Test with class name containing whitespace
        String result = ClassUtils.getCanonicalName(" My Class ");
        assertEquals("MyClass", result, "Expected canonical name to be 'MyClass' after whitespace removal");
    }

    @Test
    public void testGetCanonicalName_ComplexArrayType() {
        // Test with a complex array type
        String result = ClassUtils.getCanonicalName("[[Ljava.lang.String;");
        assertEquals("java.lang.String[][]", result, "Expected canonical name for String array of arrays to be 'java.lang.String[][]'");
    }

    @Test
    public void testGetCanonicalName_ReverseAbbreviation() {
        // Test with reverse abbreviation
        String result = ClassUtils.getCanonicalName("L");
        assertEquals("java.lang.Object", result, "Expected canonical name for 'L' to be 'java.lang.Object'");
    }
}
