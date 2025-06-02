package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ClassLoaderUtil_getClass_String_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetClassWithValidParameters() {
        String className = "java.lang.String"; // valid class name
        boolean initialize = true; // boolean value

        try {
            Class<?> result = ClassLoaderUtil.getClass(className, initialize);
            assertNotNull(result);
            assertEquals("java.lang.String", result.getName());
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not be thrown for valid class name");
        }
    }

    @Test(timeout = 4000)
    public void testGetClassWithInvalidClassName() {
        String className = "invalid.ClassName"; // invalid class name
        boolean initialize = true; // boolean value

        try {
            ClassLoaderUtil.getClass(className, initialize);
            fail("ClassNotFoundException expected for invalid class name");
        } catch (ClassNotFoundException e) {
            // Expected exception
        }
    }

}