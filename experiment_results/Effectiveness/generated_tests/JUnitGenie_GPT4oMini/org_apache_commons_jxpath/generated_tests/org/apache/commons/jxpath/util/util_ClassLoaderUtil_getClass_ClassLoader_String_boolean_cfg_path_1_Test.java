package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.ClassLoader;
import java.util.HashMap;
import java.util.Map;

public class util_ClassLoaderUtil_getClass_ClassLoader_String_boolean_cfg_path_1_Test {

    // Setting up a mock for the abbreviationMap to control its behavior
    static {
        try {
            Map<String, String> abbreviationMap = new HashMap<>();
            abbreviationMap.put("myArray", "java.lang.String[]");
            // Use reflection to set the private static field
            java.lang.reflect.Field field = ClassLoaderUtil.class.getDeclaredField("abbreviationMap");
            field.setAccessible(true);
            field.set(null, abbreviationMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetClassWithAbbreviation() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = "myArray"; // This should match the key in abbreviationMap
        boolean initialize = true;

        try {
            Class result = ClassLoaderUtil.getClass(classLoader, className, initialize);
            assertNotNull(result);
            assertEquals("class java.lang.String", result.getName());
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetClassWithoutAbbreviation() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = "java.lang.String"; // Direct class name
        boolean initialize = true;

        try {
            Class result = ClassLoaderUtil.getClass(classLoader, className, initialize);
            assertNotNull(result);
            assertEquals("class java.lang.String", result.getName());
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetClassThrowsException() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = "invalid.ClassName"; // Invalid class name
        boolean initialize = true;

        try {
            ClassLoaderUtil.getClass(classLoader, className, initialize);
            fail("Expected ClassNotFoundException to be thrown");
        } catch (ClassNotFoundException e) {
            // Expected exception
        }
    }

}