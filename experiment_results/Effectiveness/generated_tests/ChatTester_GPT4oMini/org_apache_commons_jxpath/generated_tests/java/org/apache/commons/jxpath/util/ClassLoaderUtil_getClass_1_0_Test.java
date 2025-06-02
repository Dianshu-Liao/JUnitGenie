package org.apache.commons.jxpath.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class ClassLoaderUtil_getClass_1_0_Test {

    private ClassLoader classLoader;

    @BeforeEach
    void setUp() {
        classLoader = ClassLoader.getSystemClassLoader();
        // Setup abbreviation map for testing
        Map<String, String> abbreviationMap = new HashMap<>();
        abbreviationMap.put("int", "I");
        abbreviationMap.put("java.lang.String", "Ljava/lang/String;");
        // Use reflection to set the private static abbreviationMap
        try {
            Field field = ClassLoaderUtil.class.getDeclaredField("abbreviationMap");
            field.setAccessible(true);
            field.set(null, abbreviationMap);
        } catch (Exception e) {
            fail("Failed to set up abbreviation map: " + e.getMessage());
        }
    }

    @Test
    void testGetClassWithAbbreviation() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "int", false);
        assertEquals(int.class, clazz);
    }

    @Test
    void testGetClassWithFullName() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "java.lang.String", false);
        assertEquals(String.class, clazz);
    }

    @Test
    void testGetClassWithArrayType() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "int[]", false);
        assertEquals(int[].class, clazz);
    }

    @Test
    void testGetClassNotFound() {
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, "non.existent.ClassName", false);
        });
    }

    @Test
    void testGetClassWithInitializeTrue() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "java.lang.String", true);
        assertEquals(String.class, clazz);
        // Verify that the class was initialized (not much to check here, but we can assert no exceptions)
    }
}
