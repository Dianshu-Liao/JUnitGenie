package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod() {
        try {
            // Test with a public method in a public class
            Method method = ClassUtils.getPublicMethod(String.class, "substring", int.class, int.class);
            assertNotNull(method);
            assertEquals("substring", method.getName());

            // Test with a public method in a superclass
            method = ClassUtils.getPublicMethod(java.util.ArrayList.class, "add", Object.class);
            assertNotNull(method);
            assertEquals("add", method.getName());

            // Test with a public method in an interface
            method = ClassUtils.getPublicMethod(java.util.List.class, "size");
            assertNotNull(method);
            assertEquals("size", method.getName());

            // Test with a method that does not exist
            try {
                ClassUtils.getPublicMethod(String.class, "nonExistentMethod");
                fail("Expected NoSuchMethodException to be thrown");
            } catch (NoSuchMethodException e) {
                // Expected exception
            }

        } catch (NoSuchMethodException e) {
            fail("NoSuchMethodException should not have been thrown");
        }
    }

}