package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod_ReturnsNull() {
        try {
            Method method = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNull("Expected null for non-public method", result);
        } catch (Exception e) {
            // Handle the potential exception for Reflection API
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInNonPublicClass_ReturnsNull() {
        try {
            Method method = NonPublicClass.class.getDeclaredMethod("publicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNull("Expected null for public method in non-public class", result);
        } catch (Exception e) {
            // Handle the potential exception for Reflection API
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInPublicClass_ReturnsMethod() {
        try {
            Method method = PublicClass.class.getDeclaredMethod("publicMethod");
            Method result = ValueUtils.getAccessibleMethod(method);
            assertNotNull("Expected to get the method since it's public", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod_ReturnsNull() {
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull("Expected null when input method is null", result);
    }

    static class NonPublicClass {
        void nonPublicMethod() {
        }

        public void publicMethod() {
        }
    }

    public static class PublicClass {
        public void publicMethod() {
        }
    }

}