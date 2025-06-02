package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        // Test case for when the method parameter is null
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() throws Exception {
        // Create a non-public method for testing
        Method nonPublicMethod = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
        Method result = ValueUtils.getAccessibleMethod(nonPublicMethod);
        assertNull(result);
    }

    // A sample non-public class for testing purposes
    private static class NonPublicClass {
        void nonPublicMethod() {
            // Non-public method
        }
    }

}