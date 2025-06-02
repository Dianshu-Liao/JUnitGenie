package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isArrayEmpty_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsArrayEmpty() {
        try {
            // Prepare the input for the test
            Object nonEmptyArray = new Object[] { new Object() }; // Non-null array with length > 0

            // Access the private static method using reflection
            Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
            method.setAccessible(true);

            // Invoke the method and check the result
            boolean result = (boolean) method.invoke(null, nonEmptyArray);
            assertTrue("The array should not be empty", !result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}