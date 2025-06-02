package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod() {
        try {
            // Test with a public class and a public method
            Method method = ClassUtils.getPublicMethod(PublicClass.class, "publicMethod");
            assertNotNull(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetPublicMethodWithInterface() {
        try {
            // Test with a public interface and a public method
            Method method = ClassUtils.getPublicMethod(ImplementingClass.class, "interfaceMethod");
            assertNotNull(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetPublicMethodThrowsException() {
        try {
            // Test with a class that does not have the specified public method
            ClassUtils.getPublicMethod(NonExistentClass.class, "nonExistentMethod");
        } catch (NoSuchMethodException e) {
            // Expected exception
        }
    }

    // Sample public class for testing
    public static class PublicClass {
        public void publicMethod() {}
    }

    // Sample interface for testing
    public interface SampleInterface {
        void interfaceMethod();
    }

    // Class implementing the interface
    public static class ImplementingClass implements SampleInterface {
        public void interfaceMethod() {}
    }

    // Class that does not have the method
    public static class NonExistentClass {}

}