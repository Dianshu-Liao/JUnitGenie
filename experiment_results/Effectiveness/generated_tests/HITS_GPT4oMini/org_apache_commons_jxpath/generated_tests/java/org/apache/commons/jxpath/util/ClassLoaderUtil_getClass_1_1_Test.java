package org.apache.commons.jxpath.util;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClassLoaderUtil_getClass_1_1_Test {

    private static ClassLoader classLoader;

    // Mock class to represent MyType
    public static class MyType {
    }

    @BeforeAll
    public static void setUp() {
        classLoader = ClassLoader.getSystemClassLoader();
    }

    @BeforeEach
    public void resetAbbreviationMap() throws Exception {
        // Use reflection to clear the abbreviationMap before each test
        Field field = ClassLoaderUtil.class.getDeclaredField("abbreviationMap");
        field.setAccessible(true);
        ((Map) field.get(null)).clear();
    }

    @Test
    public void testGetClassWithValidClassName() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "java.lang.String", false);
        assertEquals(String.class, clazz);
    }

    @Test
    public void testGetClassWithArrayClassName() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "java.lang.String[]", false);
        assertEquals(String[].class, clazz);
    }

    @Test
    public void testGetClassWithAbbreviation() throws Exception {
        Field field = ClassLoaderUtil.class.getDeclaredField("abbreviationMap");
        field.setAccessible(true);
        ((Map) field.get(null)).put("MyType", "Lorg/apache/commons/jxpath/util/ClassLoaderUtil_getClass_1_1_Test$MyType;");
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "MyType[]", false);
        assertEquals(MyType[].class, clazz);
    }

    @Test
    public void testGetClassWithInvalidClassName() {
        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, "invalid.ClassName", false);
        });
        assertEquals("invalid.ClassName", exception.getMessage());
    }

    @Test
    public void testGetClassWithNullClassName() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, null, false);
        });
        assertEquals("className", exception.getMessage());
    }

    @Test
    public void testGetClassWithInitializeTrue() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "java.lang.String", true);
        assertEquals(String.class, clazz);
        // Additional assertions can be added to check if the class was initialized
    }

    @Test
    public void testGetClassWithAbbreviationAndInitialize() throws Exception {
        Field field = ClassLoaderUtil.class.getDeclaredField("abbreviationMap");
        field.setAccessible(true);
        ((Map) field.get(null)).put("MyType", "Lorg/apache/commons/jxpath/util/ClassLoaderUtil_getClass_1_1_Test$MyType;");
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "MyType[]", true);
        assertEquals(MyType[].class, clazz);
        // Additional assertions can be added to check if the class was initialized
    }
}
