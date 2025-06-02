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

public class ClassLoaderUtil_getClass_3_0_Test {

    @Test
    public void testGetClass_ValidClassName() throws ClassNotFoundException {
        // Test with a valid class name
        Class<?> clazz = ClassLoaderUtil.getClass("java.lang.String");
        assertNotNull(clazz);
        assertEquals("class java.lang.String", clazz.toString());
    }

    @Test
    public void testGetClass_InvalidClassName() {
        // Test with an invalid class name
        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass("invalid.ClassName");
        });
        assertEquals("invalid.ClassName", exception.getMessage());
    }

    @Test
    public void testGetClass_NullClassName() {
        // Test with a null class name
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ClassLoaderUtil.getClass(null);
        });
        assertEquals("className cannot be null", exception.getMessage());
    }

    @Test
    public void testGetClass_EmptyClassName() {
        // Test with an empty class name
        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass("");
        });
        assertEquals("", exception.getMessage());
    }

    @Test
    public void testGetClass_ClassNotFoundExceptionHandling() {
        // Test that ClassNotFoundException is handled and not thrown for context class loader
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                throw new ClassNotFoundException("Class not found in context class loader");
            }
        });
        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass("java.lang.String");
        });
        assertEquals("java.lang.String", exception.getMessage());
        // Restore the original context class loader
        Thread.currentThread().setContextClassLoader(contextClassLoader);
    }
}
