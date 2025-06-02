package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ClassLoaderUtil;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class ClassLoaderUtil_getClass_1_0_Test {

    private ClassLoader classLoader;

    @BeforeEach
    public void setUp() {
        classLoader = ClassLoader.getSystemClassLoader();
        // Prepare the abbreviation map for testing
        setAbbreviationMap();
    }

    private void setAbbreviationMap() {
        try {
            // Use reflection to access the private abbreviationMap field
            Class<?> clazz = ClassLoaderUtil.class;
            Map<String, String> abbreviationMap = (Map<String, String>) clazz.getDeclaredField("abbreviationMap").get(null);
            abbreviationMap.clear();
            abbreviationMap.put("String", "java.lang.String");
            abbreviationMap.put("int", "I");
            abbreviationMap.put("boolean", "Z");
        } catch (Exception e) {
            fail("Failed to set up abbreviation map: " + e.getMessage());
        }
    }

    @Test
    public void testGetClassWithAbbreviation() throws ClassNotFoundException {
        Class<?> result = ClassLoaderUtil.getClass(classLoader, "String", false);
        assertEquals(String.class, result);
    }

    @Test
    public void testGetClassWithArrayAbbreviation() throws ClassNotFoundException {
        Class<?> result = ClassLoaderUtil.getClass(classLoader, "String[]", false);
        assertEquals(String[].class, result);
    }

    @Test
    public void testGetClassWithoutAbbreviation() throws ClassNotFoundException {
        Class<?> result = ClassLoaderUtil.getClass(classLoader, "java.lang.Integer", false);
        assertEquals(Integer.class, result);
    }

    @Test
    public void testGetClassWithArrayWithoutAbbreviation() throws ClassNotFoundException {
        Class<?> result = ClassLoaderUtil.getClass(classLoader, "java.lang.Integer[]", false);
        assertEquals(Integer[].class, result);
    }

    @Test
    public void testGetClassThrowsExceptionForInvalidClass() {
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, "InvalidClassName", false);
        });
    }

    @Test
    public void testGetClassWithInitialization() throws ClassNotFoundException {
        Class<?> result = ClassLoaderUtil.getClass(classLoader, "String", true);
        assertEquals(String.class, result);
    }
}
