package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ClassLoaderUtil_getClass_String_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetClassWithValidClassName() {
        try {
            Class<?> clazz = ClassLoaderUtil.getClass("java.lang.String", true);
            assertNotNull(clazz);
            assertEquals("java.lang.String", clazz.getName());
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not have been thrown for valid class name.");
        }
    }

    @Test(timeout = 4000)
    public void testGetClassWithInvalidClassName() {
        try {
            ClassLoaderUtil.getClass("invalid.ClassName", true);
            fail("ClassNotFoundException was expected but not thrown.");
        } catch (ClassNotFoundException e) {
            // Expected exception
        }
    }

}