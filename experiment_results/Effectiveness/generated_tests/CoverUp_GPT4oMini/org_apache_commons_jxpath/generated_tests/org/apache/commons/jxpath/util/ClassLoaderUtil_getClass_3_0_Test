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

public class ClassLoaderUtil_getClass_3_0_Test {

    @Test
    public void testGetClass_ValidClassName() throws Exception {
        // Arrange
        String className = "java.lang.String";
        // Act
        Class<?> result = invokeGetClass(className);
        // Assert
        assert result != null;
        assert result.getName().equals(className);
    }

    @Test
    public void testGetClass_InvalidClassName() {
        // Arrange
        String invalidClassName = "invalid.ClassName";
        // Act & Assert
        assertThrows(ClassNotFoundException.class, () -> invokeGetClass(invalidClassName));
    }

    private Class<?> invokeGetClass(String className) throws Exception {
        Method method = ClassLoaderUtil.class.getDeclaredMethod("getClass", String.class);
        method.setAccessible(true);
        return (Class<?>) method.invoke(null, className);
    }
}
