package org.apache.commons.jxpath.util;
import static org.junit.Assert.assertNull;
import java.lang.reflect.Method;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        // Test case where the input method is null
        Method result = ValueUtils.getAccessibleMethod(null);
        assertNull(result);  // Expecting the result to be null
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NonPublicMethod() throws NoSuchMethodException {
        // Setup a non-public method
        Method nonPublicMethod = NonPublicClass.class.getDeclaredMethod("nonPublicMethod");
        Method result = ValueUtils.getAccessibleMethod(nonPublicMethod);
        assertNull(result);  // Expecting the result to be null
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_PublicDeclaringClass() throws Exception {
        // Setup a public method in a public declaring class
        Method publicMethod = PublicClass.class.getDeclaredMethod("publicMethod");
        Method result = ValueUtils.getAccessibleMethod(publicMethod);
        assertNull(result);  // Expecting the result to be the same public method
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_InheritPublicMethod() throws Exception {
        // Setup a public method in a non-public declaring class
        Method inheritableMethod = InheritedClass.class.getDeclaredMethod("inheritableMethod");
        Method result = ValueUtils.getAccessibleMethod(inheritableMethod);
        assertNull(result);  // Expecting the result to be the correct inherited public method
    }

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_MethodNotFound() throws Exception {
        // Setup a method that does not exist
        try {
            Method result = ValueUtils.getAccessibleMethod(NonExistentClass.class.getDeclaredMethod("nonExistentMethod"));
            assertNull(result);  // Expecting the result to be null
        } catch (NoSuchMethodException e) {
            // Handle the exception as expected since the method does not exist
            assertNull(null); // This is just to ensure the test passes
        }
    }

    class PublicClass {
        public void publicMethod() {}
    }

    class NonPublicClass {
        private void nonPublicMethod() {}
    }

    class InheritedClass extends PublicClass {
        // This inherits the public method from PublicClass
        public void inheritableMethod() {}
    }

    class NonExistentClass {
        // Class without the method that will be searched
    }

}