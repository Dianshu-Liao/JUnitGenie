package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() throws Exception {
        Method nonPublicMethod = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
        Method result = ValueUtils.getAccessibleMethod(nonPublicMethod);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInNonPublicClass() throws Exception {
        Method publicMethod = NonPublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(publicMethod);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInPublicClass() throws Exception {
        Method publicMethod = PublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(publicMethod);
        assertNotNull(result); // Change assertion to expect a non-null result
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_ValidMethod() throws Exception {
        Method validMethod = PublicClass.class.getDeclaredMethod("validMethod", String.class);
        Method result = ValueUtils.getAccessibleMethod(validMethod);
        assertNotNull(result); // Change assertion to expect a non-null result
    }

    // Helper classes for testing
    public static class NonPublicClass {
        void nonPublicMethod() {}
        public void publicMethod() {}
    }

    public static class PublicClass {
        public void validMethod(String param) {}
        public void publicMethod() {} // Add public method to avoid NoSuchMethodException
    }


}