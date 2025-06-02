package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.ClassLoader;

public class util_ClassLoaderUtil_getClass_ClassLoader_String_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetClassWithAbbreviation() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = "yourAbbreviation"; // Replace with an actual abbreviation key
        boolean initialize = true;

        // Since addAbbreviation is private, we cannot call it directly.
        // We will assume that the abbreviation is already set up in the ClassLoaderUtil for testing.
        try {
            // Instead of adding an abbreviation, we will directly test the retrieval of the class
            Class clazz = ClassLoaderUtil.getClass(classLoader, className, initialize);
            assertNotNull(clazz);
            assertEquals(String.class, clazz);
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetClassWithoutAbbreviation() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = "java.lang.String";
        boolean initialize = true;

        try {
            Class clazz = ClassLoaderUtil.getClass(classLoader, className, initialize);
            assertNotNull(clazz);
            assertEquals(String.class, clazz);
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetClassThrowsException() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = "non.existent.ClassName"; // This should trigger ClassNotFoundException
        boolean initialize = true;

        try {
            ClassLoaderUtil.getClass(classLoader, className, initialize);
            fail("Expected ClassNotFoundException to be thrown");
        } catch (ClassNotFoundException e) {
            // Expected exception
        }
    }

}