package org.apache.commons.jxpath.util;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
// Import the missing ArrayList class
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClassLoaderUtil_getClass_4_0_Test {

    @Test
    public void testGetClassWithValidClassNameAndInitialize() throws Exception {
        // Arrange
        // A class that exists
        String className = "java.lang.String";
        boolean initialize = true;
        // Act
        Class<?> result = ClassLoaderUtil.getClass(className, initialize);
        // Assert
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void testGetClassWithValidClassNameAndNoInitialize() throws Exception {
        // Arrange
        // A class that exists
        String className = "java.lang.Integer";
        boolean initialize = false;
        // Act
        Class<?> result = ClassLoaderUtil.getClass(className, initialize);
        // Assert
        Assertions.assertEquals(Integer.class, result);
    }

    @Test
    public void testGetClassThrowsClassNotFoundExceptionForInvalidClass() {
        // Arrange
        // A class that does not exist
        String className = "com.nonexistent.Class";
        boolean initialize = true;
        // Act & Assert
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(className, initialize);
        });
    }

    @Test
    public void testGetClassWithNullClassName() {
        // Arrange
        // Null class name
        String className = null;
        boolean initialize = true;
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            ClassLoaderUtil.getClass(className, initialize);
        });
    }

    @Test
    public void testGetClassWithEmptyClassName() {
        // Arrange
        // Empty class name
        String className = "";
        boolean initialize = true;
        // Act & Assert
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(className, initialize);
        });
    }

    @Test
    public void testGetClassWithValidClassNameUsingContextClassLoader() throws Exception {
        // Arrange
        // A class that exists
        String className = "java.util.ArrayList";
        boolean initialize = true;
        // Act
        Class<?> result = ClassLoaderUtil.getClass(className, initialize);
        // Assert
        Assertions.assertEquals(ArrayList.class, result);
    }

    @Test
    public void testGetClassWithValidClassNameUsingFallback() throws Exception {
        // Arrange
        // A class that exists
        String className = "java.util.HashMap";
        boolean initialize = false;
        // Act
        Class<?> result = ClassLoaderUtil.getClass(className, initialize);
        // Assert
        Assertions.assertEquals(HashMap.class, result);
    }
}
