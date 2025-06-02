package org.apache.commons.lang3;
import static org.junit.Assert.*;
import org.apache.commons.lang3.ClassUtils;
import java.lang.reflect.Method;
import org.junit.Test;

public class ClassUtils_getPublicMethod_Class_String_Class_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetPublicMethod_WithPublicMethod() {
        try {
            // The class we are testing
            Class<MyClass> cls = MyClass.class; // MyClass is a public class with a public method
            String methodName = "myPublicMethod";
            Class<?>[] parameterTypes = new Class<?>[]{};

            // Call the focal method
            Method method = ClassUtils.getPublicMethod(cls, methodName, parameterTypes);
            assertNotNull(method);
            assertEquals("myPublicMethod", method.getName());

        } catch (NoSuchMethodException e) {
            fail("Expected NoSuchMethodException was not thrown.");
        }
    }

    @Test(timeout = 4000)
    public void testGetPublicMethod_WithNoPublicMethod() {
        try {
            // The class we are testing
            Class<AnotherClass> cls = AnotherClass.class; // AnotherClass is a public class with no public methods
            String methodName = "privateMethod";  // Method not public
            Class<?>[] parameterTypes = new Class<?>[]{};

            // Call the focal method and expect an exception
            ClassUtils.getPublicMethod(cls, methodName, parameterTypes);
            fail("Expected NoSuchMethodException was not thrown.");
        } catch (NoSuchMethodException e) {
            // Expected behavior
        }
    }

    // Dummy classes for testing purposes
    public static class MyClass {
        public void myPublicMethod() {}
    }

    public static class AnotherClass {
        private void privateMethod() {}
    }

}