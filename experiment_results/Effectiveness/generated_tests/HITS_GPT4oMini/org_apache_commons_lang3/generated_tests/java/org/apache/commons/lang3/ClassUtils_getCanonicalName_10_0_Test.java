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

public class ClassUtils_getCanonicalName_10_0_Test {

    // Define the OuterClass with an InnerClass for testing
    public static class OuterClass {

        public static class InnerClass {
            // Inner class can be empty for this test
        }
    }

    @Test
    public void testGetCanonicalName_NestedClass() {
        // Test with a nested class
        String result = ClassUtils.getCanonicalName(new OuterClass.InnerClass());
        assertEquals("org.apache.commons.lang3.ClassUtils_getCanonicalName_10_0_Test$OuterClass$InnerClass", result, "Expected canonical name for nested class");
    }

    @Test
    public void testGetCanonicalName_Null() {
        // Test with null object
        String result = ClassUtils.getCanonicalName(null);
        assertEquals("", result, "Expected empty string for null object");
    }

    @Test
    public void testGetCanonicalName_Primitive() {
        // Test with a primitive wrapper class
        String result = ClassUtils.getCanonicalName(Integer.valueOf(5));
        assertEquals("java.lang.Integer", result, "Expected canonical name for Integer class");
    }

    @Test
    public void testGetCanonicalName_String() {
        // Test with a String object
        String result = ClassUtils.getCanonicalName("Test");
        assertEquals("java.lang.String", result, "Expected canonical name for String class");
    }
}
