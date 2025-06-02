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

public class ClassLoaderUtil_getClass_1_0_Test {

    private ClassLoader classLoader;

    @BeforeEach
    public void setUp() {
        classLoader = ClassLoader.getSystemClassLoader();
    }

    private void addAbbreviation(String className, String abbreviation) throws Exception {
        Method method = ClassLoaderUtil.class.getDeclaredMethod("addAbbreviation", String.class, String.class);
        method.setAccessible(true);
        method.invoke(null, className, abbreviation);
    }

    @Test
    public void testGetClassWithAbbreviation() throws Exception {
        // Arrange
        String className = "MyClass";
        addAbbreviation(className, "Lcom/example/MyClass;");
        // Act
        Class<?> result = ClassLoaderUtil.getClass(classLoader, className, false);
        // Assert
        assertNotNull(result);
        assertEquals("class com.example.MyClass", result.toString());
    }

    @Test
    public void testGetClassWithoutAbbreviation() throws Exception {
        // Arrange
        String className = "java.lang.String";
        // Act
        Class<?> result = ClassLoaderUtil.getClass(classLoader, className, false);
        // Assert
        assertNotNull(result);
        assertEquals("class java.lang.String", result.toString());
    }

    @Test
    public void testGetClassWithArrayAbbreviation() throws Exception {
        // Arrange
        String className = "MyArrayClass[]";
        addAbbreviation("MyArrayClass", "Lcom/example/MyArrayClass;");
        // Act
        Class<?> result = ClassLoaderUtil.getClass(classLoader, className, false);
        // Assert
        assertNotNull(result);
        assertTrue(result.isArray());
        assertEquals("class [Lcom.example.MyArrayClass;", result.toString());
    }

    @Test
    public void testGetClassWithNullClassName() {
        // Arrange
        String className = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, className, false);
        });
    }

    @Test
    public void testGetClassWithNonExistentClass() {
        // Arrange
        String className = "com.example.NonExistentClass";
        // Act & Assert
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, className, false);
        });
    }
}
