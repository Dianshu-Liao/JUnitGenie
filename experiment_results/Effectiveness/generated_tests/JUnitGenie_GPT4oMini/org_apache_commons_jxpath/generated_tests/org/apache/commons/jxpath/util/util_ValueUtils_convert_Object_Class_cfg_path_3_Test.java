package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class util_ValueUtils_convert_Object_Class_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConvert() {
        try {
            // Accessing the private static method using reflection
            Method method = ValueUtils.class.getDeclaredMethod("convert", Object.class, Class.class);
            method.setAccessible(true);

            // Test case 1: Convert Integer to String
            Object result1 = method.invoke(null, 123, String.class);
            assertEquals("123", result1);

            // Test case 2: Convert String to Integer
            Object result2 = method.invoke(null, "456", Integer.class);
            assertEquals(456, result2);

            // Test case 3: Handle conversion failure
            try {
                method.invoke(null, new Object(), String.class);
            } catch (JXPathException e) {
                // Expected exception
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}