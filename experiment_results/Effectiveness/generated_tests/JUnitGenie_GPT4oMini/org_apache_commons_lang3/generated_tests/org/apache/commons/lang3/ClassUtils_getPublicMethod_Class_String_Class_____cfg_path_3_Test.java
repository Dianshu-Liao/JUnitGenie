package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod() {
        try {
            // Test with a public class and method
            Method method = ClassUtils.getPublicMethod(PublicClass.class, "publicMethod");
            assertNotNull(method);
            assertTrue(method.getDeclaringClass().equals(PublicClass.class));
        } catch (NoSuchMethodException e) {
            fail("NoSuchMethodException should not be thrown for public method.");
        }
    }

    @Test(timeout = 4000)
    public void testGetPublicMethodWithInterface() {
        try {
            // Test with an interface that has a public method
            Method method = ClassUtils.getPublicMethod(ImplementingClass.class, "interfaceMethod");
            assertNotNull(method);
            assertTrue(method.getDeclaringClass().equals(InterfaceClass.class));
        } catch (NoSuchMethodException e) {
            fail("NoSuchMethodException should not be thrown for public method in interface.");
        }
    }

    @Test(timeout = 4000)
    public void testGetPublicMethodThrowsException() {
        try {
            // Test with a class that does not have the specified public method
            ClassUtils.getPublicMethod(PublicClass.class, "nonExistentMethod");
            fail("Expected NoSuchMethodException to be thrown.");
        } catch (NoSuchMethodException e) {
            // Expected exception
        }
    }

    // Sample public class for testing
    public static class PublicClass {
        public void publicMethod() {}
    }

    // Sample interface for testing
    public interface InterfaceClass {
        void interfaceMethod();
    }

    // Class implementing the interface
    public static class ImplementingClass implements InterfaceClass {
        public void interfaceMethod() {}
    }

}