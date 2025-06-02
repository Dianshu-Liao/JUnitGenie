package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod() {
        try {
            // Test with a public method in a public class
            Method method = ClassUtils.getPublicMethod(String.class, "substring", int.class, int.class);
            assertNotNull(method);
            assertEquals("substring", method.getName());

            // Test with a public method in a superclass
            method = ClassUtils.getPublicMethod(ArrayList.class, "add", Object.class);
            assertNotNull(method);
            assertEquals("add", method.getName());

            // Test with a public method in an interface
            method = ClassUtils.getPublicMethod(List.class, "size");
            assertNotNull(method);
            assertEquals("size", method.getName());

            // Test with a method that does not exist
            Class<?> cls = Class.forName("java.lang.String");
            try {
                ClassUtils.getPublicMethod(cls, "nonExistentMethod");
                fail("Expected NoSuchMethodException to be thrown");
            } catch (NoSuchMethodException e) {
                // Expected exception
            }

        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}