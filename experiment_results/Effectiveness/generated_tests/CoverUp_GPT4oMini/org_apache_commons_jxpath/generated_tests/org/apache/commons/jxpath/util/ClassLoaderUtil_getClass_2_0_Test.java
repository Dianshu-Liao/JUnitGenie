package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ClassLoaderUtil;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class ClassLoaderUtil_getClass_2_0_Test {

    @Test
    void testGetClassWithAbbreviation() throws Exception {
        // Setup
        ClassLoader classLoader = getClass().getClassLoader();
        // Assuming this is a key in abbreviationMap
        String className = "myAbbreviation";
        // Assuming this is the mapped class name
        String expectedClassName = "java.lang.String";
        // Use reflection to set the abbreviationMap for testing
        Method setAbbreviationMapMethod = ClassLoaderUtil.class.getDeclaredMethod("setAbbreviationMap", String.class, String.class);
        setAbbreviationMapMethod.setAccessible(true);
        setAbbreviationMapMethod.invoke(null, className, expectedClassName);
        // Execute
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, className);
        // Verify
        assertEquals(String.class, clazz);
    }

    @Test
    void testGetClassWithoutAbbreviation() throws Exception {
        // Setup
        ClassLoader classLoader = getClass().getClassLoader();
        String className = "java.lang.Integer";
        // Execute
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, className);
        // Verify
        assertEquals(Integer.class, clazz);
    }

    @Test
    void testGetClassThrowsException() {
        // Setup
        ClassLoader classLoader = getClass().getClassLoader();
        String invalidClassName = "com.nonexistent.Class";
        // Execute & Verify
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, invalidClassName);
        });
    }

    // Helper method to set abbreviationMap (Reflection)
    private static void setAbbreviationMap(String key, String value) throws Exception {
        Method method = ClassLoaderUtil.class.getDeclaredMethod("setAbbreviationMap", String.class, String.class);
        method.setAccessible(true);
        method.invoke(null, key, value);
    }
}
