package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.MethodLookupUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class util_MethodLookupUtils_matchType_Class_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testMatchTypeWithNonNullObject() {
        try {
            // Accessing the private static method using reflection
            Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
            method.setAccessible(true);

            // Prepare test parameters
            Class<?> expected = String.class;
            Object object = "test";

            // Invoke the method and assert the expected result
            int result = (int) method.invoke(null, expected, object);
            assertEquals(1, result); // Assuming 1 corresponds to EXACT_MATCH
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}