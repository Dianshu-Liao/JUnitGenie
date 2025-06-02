package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethod() {
        try {
            // Prepare a public method to test
            Method method = SampleClass.class.getMethod("publicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertEquals(method, result);
        } catch (NoSuchMethodException e) {
            // Handle the exception if the method is not found
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() {
        try {
            // Prepare a non-public method to test
            Method method = SampleClass.class.getDeclaredMethod("privateMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertEquals(null, result);
        } catch (NoSuchMethodException e) {
            // Handle the exception if the method is not found
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method result = ValueUtils.getAccessibleMethod(null);
        assertEquals(null, result);
    }

    // Sample class for testing purposes
    public static class SampleClass {
        public void publicMethod() {}
        private void privateMethod() {}
    }

}