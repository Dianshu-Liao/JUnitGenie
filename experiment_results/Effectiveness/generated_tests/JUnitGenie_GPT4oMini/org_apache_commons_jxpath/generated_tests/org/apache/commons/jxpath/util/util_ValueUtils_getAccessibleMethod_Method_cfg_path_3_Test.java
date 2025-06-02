package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_withPublicMethod_shouldReturnMethod() {
        try {
            // Prepare
            Method method = SampleInterface.class.getMethod("publicMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);

            // Verify
            assertNotNull(accessibleMethod);
            // Further assert here if necessary
        } catch (NoSuchMethodException e) {
            // Handle expected exception for test setup
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_withNonPublicMethod_shouldReturnNull() {
        try {
            // Prepare
            Method method = SampleClass.class.getDeclaredMethod("privateMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);

            // Verify
            assertNull(accessibleMethod);
        } catch (NoSuchMethodException e) {
            // Handle expected exception for test setup
        }
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_withNullMethod_shouldReturnNull() {
        Method accessibleMethod = ValueUtils.getAccessibleMethod(null);
        // Verify
        assertNull(accessibleMethod);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_withMethodFromNonPublicClass_shouldReturnNull() {
        try {
            // Prepare
            Method method = SampleNonPublicClass.class.getDeclaredMethod("nonPublicMethod");
            Method accessibleMethod = ValueUtils.getAccessibleMethod(method);

            // Verify
            assertNull(accessibleMethod);
        } catch (NoSuchMethodException e) {
            // Handle expected exception for test setup
        }
    }

    interface SampleInterface {
        public void publicMethod();
    }

    public class SampleClass {
        private void privateMethod() {}
    }

    class SampleNonPublicClass {
        void nonPublicMethod() {}
    }

}