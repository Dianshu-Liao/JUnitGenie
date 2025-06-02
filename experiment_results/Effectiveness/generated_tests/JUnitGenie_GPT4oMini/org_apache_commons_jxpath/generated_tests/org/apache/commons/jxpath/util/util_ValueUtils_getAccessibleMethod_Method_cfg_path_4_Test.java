package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethod() {
        try {
            Method method = SampleClass.class.getDeclaredMethod("publicMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNotNull("The accessible method should not be null", accessibleMethod);
        } catch (NoSuchMethodException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() {
        try {
            Method method = SampleClass.class.getDeclaredMethod("privateMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNull("The accessible method should be null for non-public methods", accessibleMethod);
        } catch (NoSuchMethodException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method accessibleMethod = ValueUtils.getAccessibleMethod(null);
        assertNull("The accessible method should be null when input is null", accessibleMethod);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_MethodFromInterface() {
        try {
            Method method = InterfaceSample.class.getDeclaredMethod("interfaceMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNotNull("The accessible method should not be null for public interface methods", accessibleMethod);
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