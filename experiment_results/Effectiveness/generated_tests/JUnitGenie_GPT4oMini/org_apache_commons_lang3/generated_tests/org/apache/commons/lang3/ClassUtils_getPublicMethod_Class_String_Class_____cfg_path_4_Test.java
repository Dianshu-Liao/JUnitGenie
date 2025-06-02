package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod() {
        try {
            // Test with a public method in a public class
            Method method = ClassUtils.getPublicMethod(PublicClass.class, "publicMethod");
            assertNotNull(method);
            assertTrue(method.getDeclaringClass().equals(PublicClass.class));

            // Test with a public method in a superclass
            method = ClassUtils.getPublicMethod(SubClass.class, "publicMethod");
            assertNotNull(method);
            assertTrue(method.getDeclaringClass().equals(SuperClass.class));

            // Test with a public method in an interface
            method = ClassUtils.getPublicMethod(ImplementingClass.class, "interfaceMethod");
            assertNotNull(method);
            assertTrue(method.getDeclaringClass().equals(InterfaceClass.class));

            // Test with a method that does not exist
            try {
                ClassUtils.getPublicMethod(PublicClass.class, "nonExistentMethod");
                fail("Expected NoSuchMethodException");
            } catch (NoSuchMethodException e) {
                // Expected exception
            }

        } catch (NoSuchMethodException e) {
            fail("NoSuchMethodException should not have been thrown");
        }
    }

    // Sample classes for testing
    public static class PublicClass {
        public void publicMethod() {}
    }

    public static class SuperClass {
        public void publicMethod() {}
    }

    public static class SubClass extends SuperClass {}

    public interface InterfaceClass {
        void interfaceMethod();
    }

    public static class ImplementingClass implements InterfaceClass {
        public void interfaceMethod() {}
    }

}