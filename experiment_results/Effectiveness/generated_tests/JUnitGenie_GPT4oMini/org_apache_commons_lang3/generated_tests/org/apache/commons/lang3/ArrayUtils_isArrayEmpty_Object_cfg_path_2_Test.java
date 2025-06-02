package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isArrayEmpty_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsArrayEmpty() {
        try {
            // Accessing the private static method using reflection
            Method method = ArrayUtils.class.getDeclaredMethod("isArrayEmpty", Object.class);
            method.setAccessible(true);

            // Test case: passing an empty array
            Object emptyArray = new Object[0];
            boolean result = (boolean) method.invoke(null, emptyArray);
            assertTrue(result); // Expecting true for an empty array

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}