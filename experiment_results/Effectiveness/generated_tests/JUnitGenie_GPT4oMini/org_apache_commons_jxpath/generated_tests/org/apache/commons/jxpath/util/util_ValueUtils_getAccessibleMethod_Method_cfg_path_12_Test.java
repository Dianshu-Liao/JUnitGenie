package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method method = null;

        Method result = ValueUtils.getAccessibleMethod(method);

        assertNull(result); // Expecting null when input is null
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() {
        try {
            Method method = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");

            Method result = ValueUtils.getAccessibleMethod(method);

            assertNull(result); // Expecting null for non-public method
        } catch (NoSuchMethodException e) {
            // Handle exception if method is not found
        }
    }

    private static class NonPublicClass {
        void nonPublicMethod() {
            // Non-public method for testing
        }
    }

}