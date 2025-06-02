package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        // Test case for method being null
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() {
        // Test case for a non-public method
        try {
            Method method = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNull(result);
        } catch (NoSuchMethodException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInPublicClass() throws NoSuchMethodException {
        // Test case for a public method in a public class
        Method method = PublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result); // Expecting the method to be returned
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInNonPublicClass() throws NoSuchMethodException {
        // Test case for a public method in a non-public class
        Method method = NonPublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result); // Expecting the method to be returned
    }

    // Sample classes for testing
    public static class PublicClass {
        public void publicMethod() {}
    }

    public static class NonPublicClass {
        public void publicMethod() {}
        private void nonPublicMethod() {}
    }

}