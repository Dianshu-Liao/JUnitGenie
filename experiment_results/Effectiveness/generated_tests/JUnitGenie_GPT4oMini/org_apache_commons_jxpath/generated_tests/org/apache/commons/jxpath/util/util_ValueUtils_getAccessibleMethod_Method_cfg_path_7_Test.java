package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethodWithPublicMethod() {
        try {
            // Create a public method for testing
            Method method = SampleClass.class.getDeclaredMethod("publicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNotNull("Expected a non-null result for a public method", result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethodWithNonPublicMethod() {
        try {
            // Create a non-public method for testing
            Method method = SampleClass.class.getDeclaredMethod("privateMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNull("Expected a null result for a non-public method", result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethodWithNullMethod() {
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull("Expected a null result when input method is null", result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethodWithMethodFromNonPublicClass() {
        try {
            // Create a method from a non-public class
            Method method = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNull("Expected a null result for a method from a non-public class", result);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    // Sample classes for testing
    public static class SampleClass {
        public void publicMethod() {}
        private void privateMethod() {}
    }

    public static class NonPublicClass {
        void nonPublicMethod() {}
    }

}