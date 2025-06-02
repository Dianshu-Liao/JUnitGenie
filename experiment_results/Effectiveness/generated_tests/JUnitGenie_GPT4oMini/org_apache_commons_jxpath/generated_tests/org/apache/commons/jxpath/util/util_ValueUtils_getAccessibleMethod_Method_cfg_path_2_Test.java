package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() throws NoSuchMethodException {
        Method nonPublicMethod = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
        Method result = ValueUtils.getAccessibleMethod(nonPublicMethod);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInNonPublicClass() throws NoSuchMethodException {
        Method publicMethod = NonPublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(publicMethod);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicMethodInPublicClass() throws NoSuchMethodException {
        Method publicMethod = PublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(publicMethod);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_ValidMethod() throws NoSuchMethodException {
        Method validMethod = PublicClass.class.getDeclaredMethod("validMethod");
        Method result = ValueUtils.getAccessibleMethod(validMethod);
        assertNotNull(result); // Change assertion to check for non-null
    }

    // Helper classes for testing
    public static class NonPublicClass {
        void nonPublicMethod() {}
        public void publicMethod() {}
    }

    public static class PublicClass {
        public void validMethod() {}
    }


}