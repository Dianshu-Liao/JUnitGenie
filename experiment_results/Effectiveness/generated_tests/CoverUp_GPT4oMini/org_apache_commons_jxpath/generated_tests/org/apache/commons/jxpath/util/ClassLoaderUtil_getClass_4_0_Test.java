package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.junit.jupiter.api.function.Executable;
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

class ClassLoaderUtil_getClass_4_0_Test {

    @Test
    void testGetClassWithValidClassName() throws Exception {
        String className = "java.lang.String";
        boolean initialize = true;
        Class<?> clazz = ClassLoaderUtil.getClass(className, initialize);
        assertEquals(String.class, clazz);
    }

    @Test
    void testGetClassWithInvalidClassName() {
        String className = "invalid.ClassName";
        boolean initialize = true;
        Executable executable = () -> ClassLoaderUtil.getClass(className, initialize);
        assertThrows(ClassNotFoundException.class, executable);
    }

    @Test
    void testGetClassWithAbbreviation() throws Exception {
        // Assuming abbreviationMap is populated with a valid mapping
        // You would need to use reflection to set the private static map
        setAbbreviationMap("str", "java.lang.String");
        String className = "str";
        boolean initialize = true;
        Class<?> clazz = ClassLoaderUtil.getClass(className, initialize);
        assertEquals(String.class, clazz);
    }

    @Test
    void testGetClassWithEmptyClassName() {
        String className = "";
        boolean initialize = true;
        Executable executable = () -> ClassLoaderUtil.getClass(className, initialize);
        assertThrows(ClassNotFoundException.class, executable);
    }

    @Test
    void testGetClassWithNullClassName() {
        String className = null;
        boolean initialize = true;
        Executable executable = () -> ClassLoaderUtil.getClass(className, initialize);
        assertThrows(ClassNotFoundException.class, executable);
    }

    private void setAbbreviationMap(String key, String value) throws Exception {
        // Use reflection to set the private static abbreviationMap
        Class<?> clazz = ClassLoaderUtil.class;
        Method method = clazz.getDeclaredMethod("getClass", ClassLoader.class, String.class, boolean.class);
        method.setAccessible(true);
        // Assuming we can access the static abbreviationMap field
        java.lang.reflect.Field field = clazz.getDeclaredField("abbreviationMap");
        field.setAccessible(true);
        Map<String, String> map = (Map<String, String>) field.get(null);
        map.put(key, value);
    }
}
