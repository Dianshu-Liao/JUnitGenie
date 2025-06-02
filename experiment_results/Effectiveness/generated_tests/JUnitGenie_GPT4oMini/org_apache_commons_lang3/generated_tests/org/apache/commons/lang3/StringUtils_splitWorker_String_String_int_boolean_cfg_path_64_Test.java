package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_64_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Accessing the private static method using reflection
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test case 1: Basic Split
            String input = "a,b,c";
            String separator = ",";
            int max = 3;
            boolean preserveAllTokens = false;
            String[] expectedOutput = {"a", "b", "c"};
            String[] result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expectedOutput, result);

            // Test case 2: Empty String
            input = "";
            separator = ",";
            max = 3;
            preserveAllTokens = false;
            expectedOutput = ArrayUtils.EMPTY_STRING_ARRAY;
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expectedOutput, result);

            // Test case 3: Null Input
            input = null;
            separator = ",";
            max = 3;
            preserveAllTokens = false;
            expectedOutput = null; // Expected output is null
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expectedOutput, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}