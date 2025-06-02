package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.reflect.Method;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_14_Test {
    
    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Use reflection to access the private static method
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test input
            String input = "a,b,c";
            String separator = ",";
            int max = 3;
            boolean preserveAllTokens = true;

            // Expected output
            String[] expected = {"a", "b", "c"};

            // Invoke the method and check output
            String[] result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

}