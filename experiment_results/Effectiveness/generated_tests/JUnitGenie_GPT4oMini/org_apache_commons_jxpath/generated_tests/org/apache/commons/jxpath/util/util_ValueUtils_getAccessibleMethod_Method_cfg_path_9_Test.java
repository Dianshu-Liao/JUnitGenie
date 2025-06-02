package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod() {
        try {
            // Create a method reference for a public method in a class
            Method method = SampleClass.class.getDeclaredMethod("publicMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);
            assertNotNull("The accessible method should not be null", accessibleMethod);
        } catch (NoSuchMethodException e) {
            // Handle the exception for the test case
            e.printStackTrace();
        }
    }

    // Sample class with a public method for testing
    public static class SampleClass {
        public void publicMethod() {
            // Sample method
        }
    }

}