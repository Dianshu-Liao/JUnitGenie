package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_50_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Setup parameters for the splitWorker method
            String str = "a,b,c";
            String separatorChars = ",";
            int max = 3;
            boolean preserveAllTokens = false;

            // Access the private static method using reflection
            Method splitWorkerMethod = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            splitWorkerMethod.setAccessible(true);

            // Call the method and get the result
            String[] result = (String[]) splitWorkerMethod.invoke(null, str, separatorChars, max, preserveAllTokens);

            // Expected output
            String[] expected = {"a", "b", "c"};
            
            // Validate the result
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle potential exceptions thrown by reflection or method execution
            e.printStackTrace();
        }
    }

}