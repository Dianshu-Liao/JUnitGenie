package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.MethodLookupUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class util_MethodLookupUtils_matchType_Class_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMatchType() {
        try {
            // Access the private static method using reflection
            Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
            method.setAccessible(true);

            // Test case 1: Exact match
            Class<?> expected = String.class; // Use wildcard to allow any class type
            Object object = "test";
            int result = (int) method.invoke(null, expected, object);
            assertEquals(1, result); // Assuming 1 represents EXACT_MATCH

            // Test case 2: Null object
            object = null;
            result = (int) method.invoke(null, expected, object);
            assertEquals(0, result); // Assuming 0 represents APPROXIMATE_MATCH

            // Test case 3: Assignable from
            expected = CharSequence.class; // Use wildcard to allow any class type
            object = "test";
            result = (int) method.invoke(null, expected, object);
            assertEquals(1, result); // Assuming 1 represents EXACT_MATCH

            // Test case 4: No match
            expected = Integer.class; // Use wildcard to allow any class type
            object = "test";
            result = (int) method.invoke(null, expected, object);
            assertEquals(2, result); // Assuming 2 represents NO_MATCH

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}