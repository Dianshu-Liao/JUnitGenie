package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethod() {
        try {
            // Create a public method to test
            Method method = SampleClass.class.getDeclaredMethod("publicMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNotNull("Expected to find the accessible method", accessibleMethod);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() {
        try {
            // Create a non-public method to test
            Method method = SampleClass.class.getDeclaredMethod("privateMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNull("Expected to find no accessible method", accessibleMethod);
        } catch (Exception e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method accessibleMethod = ValueUtils.getAccessibleMethod(null);
        assertNull("Expected to find no accessible method for null input", accessibleMethod);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_MethodFromInterface() {
        try {
            // Create a method from an interface
            Method method = InterfaceSample.class.getDeclaredMethod("interfaceMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNotNull("Expected to find the accessible method from interface", accessibleMethod);
        } catch (Exception e) {
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