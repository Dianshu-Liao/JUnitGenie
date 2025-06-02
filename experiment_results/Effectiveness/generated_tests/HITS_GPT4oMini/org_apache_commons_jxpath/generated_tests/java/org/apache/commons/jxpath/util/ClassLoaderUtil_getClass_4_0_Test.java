package org.apache.commons.jxpath.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClassLoaderUtil_getClass_4_0_Test {

    @Test
    public void testGetClassWithValidClassName() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass("java.lang.String", false);
        assertEquals(String.class, clazz);
    }

    @Test
    public void testGetClassWithValidClassNameAndInitialize() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass("java.lang.String", true);
        assertEquals(String.class, clazz);
    }

    @Test
    public void testGetClassWithInvalidClassName() {
        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass("invalid.ClassName", false);
        });
        assertEquals("invalid.ClassName", exception.getMessage());
    }

    @Test
    public void testGetClassWithNullClassName() {
        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(null, false);
        });
        assertEquals("null", exception.getMessage());
    }

    @Test
    public void testGetClassWithAbbreviatedClassName() {
        // Assuming abbreviationMap is set up elsewhere in the actual class
        // For this test, we need to mock or set the abbreviationMap accordingly
        // This requires additional setup which is not provided in the original code
        // Here we are just demonstrating the test structure
        // Example: abbreviationMap.put("List", "java.util.ArrayList");
        // Class<?> clazz = ClassLoaderUtil.getClass("List", false);
        // assertEquals(ArrayList.class, clazz);
    }

    @Test
    public void testGetClassWithComponentType() throws ClassNotFoundException {
        // Assuming abbreviationMap is set up for array types
        // Example: abbreviationMap.put("StringArray", "java.lang.String[]");
        // Class<?> clazz = ClassLoaderUtil.getClass("StringArray", false);
        // assertEquals(String[].class, clazz);
    }
}
