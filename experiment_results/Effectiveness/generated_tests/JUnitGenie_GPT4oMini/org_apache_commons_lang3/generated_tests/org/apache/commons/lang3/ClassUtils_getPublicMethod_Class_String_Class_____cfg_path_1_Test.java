package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod() {
        try {
            // Test with a public method
            Method method = ClassUtils.getPublicMethod(String.class, "substring", int.class, int.class);
            assertNotNull(method);
            assertEquals("substring", method.getName());

            // Test with a method that does not exist
            Class<?> cls = ClassUtils.class;
            try {
                ClassUtils.getPublicMethod(cls, "nonExistentMethod");
                fail("Expected NoSuchMethodException to be thrown");
            } catch (NoSuchMethodException e) {
                // Expected exception
            }

        } catch (NoSuchMethodException e) {
            fail("NoSuchMethodException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testGetPublicMethodThrowsException() {
        try {
            // Test with a class that has no public methods
            Class<?> cls = PrivateClass.class; // Assuming PrivateClass is a class with no public methods
            ClassUtils.getPublicMethod(cls, "someMethod");
            fail("Expected NoSuchMethodException to be thrown");
        } catch (NoSuchMethodException e) {
            // Expected exception
        }
    }

    // A private class for testing purposes
    private static class PrivateClass {
        private void someMethod() {}
    }

}