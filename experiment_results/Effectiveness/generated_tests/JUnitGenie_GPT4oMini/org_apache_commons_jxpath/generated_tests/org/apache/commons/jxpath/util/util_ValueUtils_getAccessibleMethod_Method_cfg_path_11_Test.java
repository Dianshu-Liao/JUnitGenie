package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethod() {
        try {
            // Create a public method to test
            Method method = SampleClass.class.getMethod("publicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNotNull("Expected a non-null result for a public method", result);
        } catch (NoSuchMethodException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() {
        try {
            // Create a non-public method to test
            Method method = SampleClass.class.getDeclaredMethod("privateMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNull("Expected a null result for a non-public method", result);
        } catch (NoSuchMethodException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull("Expected a null result when input method is null", result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_MethodFromInterface() {
        try {
            // Create a method from an interface
            Method method = InterfaceSample.class.getMethod("interfaceMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNotNull("Expected a non-null result for a method from an interface", result);
        } catch (NoSuchMethodException e) {
            // Handle the exception
        }
    }

    // Sample classes for testing
    public static class SampleClass {
        public void publicMethod() {}
        private void privateMethod() {}
    }

    public interface InterfaceSample {
        void interfaceMethod();
    }

}