package org.apache.commons.jxpath.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class ClassLoaderUtil_getClass_2_0_Test {

    private ClassLoader classLoader;

    @BeforeEach
    public void setUp() throws Exception {
        classLoader = ClassLoader.getSystemClassLoader();
        // Use reflection to set the abbreviationMap for testing
        Field field = ClassLoaderUtil.class.getDeclaredField("abbreviationMap");
        field.setAccessible(true);
        Map<String, String> abbreviationMap = (Map<String, String>) field.get(null);
        // Clear existing mappings
        abbreviationMap.clear();
        abbreviationMap.put("List", "java.util.List");
        abbreviationMap.put("Map", "java.util.Map");
    }

    @Test
    public void testGetClassWithAbbreviation() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "List");
        assertEquals(List.class, clazz);
    }

    @Test
    public void testGetClassWithAnotherAbbreviation() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "Map");
        assertEquals(Map.class, clazz);
    }

    @Test
    public void testGetClassWithNonExistentAbbreviation() throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderUtil.getClass(classLoader, "Set");
        assertEquals(Class.forName("java.util.Set"), clazz);
    }

    @Test
    public void testGetClassWithInvalidClassName() {
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, "InvalidClassName");
        });
    }

    @Test
    public void testGetClassWithNullClassName() {
        assertThrows(NullPointerException.class, () -> {
            ClassLoaderUtil.getClass(classLoader, null);
        });
    }
}
