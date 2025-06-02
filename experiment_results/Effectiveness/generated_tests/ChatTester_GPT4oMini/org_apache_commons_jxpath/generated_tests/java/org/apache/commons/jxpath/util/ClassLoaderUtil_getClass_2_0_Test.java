package org.apache.commons.jxpath.util;

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

public class ClassLoaderUtil_getClass_2_0_Test {

    @Test
    public void testGetClassWithValidClassName() throws Exception {
        // Arrange
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // A valid class name
        String className = "java.lang.String";
        // Act
        Class<?> result = invokeGetClass(classLoader, className);
        // Assert
        assertNotNull(result);
        assertEquals(String.class, result);
    }

    @Test
    public void testGetClassWithInvalidClassName() {
        // Arrange
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // An invalid class name
        String className = "com.nonexistent.ClassName";
        // Act & Assert
        assertThrows(ClassNotFoundException.class, () -> {
            invokeGetClass(classLoader, className);
        });
    }

    @Test
    public void testGetClassWithNullClassLoader() {
        // Arrange
        // A valid class name
        String className = "java.lang.String";
        // Act & Assert
        assertThrows(ClassNotFoundException.class, () -> {
            invokeGetClass(null, className);
        });
    }

    @Test
    public void testGetClassWithNullClassName() {
        // Arrange
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // Act & Assert
        assertThrows(ClassNotFoundException.class, () -> {
            invokeGetClass(classLoader, null);
        });
    }

    private Class<?> invokeGetClass(ClassLoader classLoader, String className) throws Exception {
        Method method = ClassLoaderUtil.class.getDeclaredMethod("getClass", ClassLoader.class, String.class);
        // Make the private method accessible
        method.setAccessible(true);
        return (Class<?>) method.invoke(null, classLoader, className);
    }
}
