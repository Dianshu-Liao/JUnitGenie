package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_61_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Accessing the private static method using reflection
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test case 1: Normal case
            String input = "a,b,c";
            String separator = ",";
            int max = 3;
            boolean preserveAllTokens = false;
            String[] expected = {"a", "b", "c"};
            String[] result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 2: Empty string
            input = "";
            expected = ArrayUtils.EMPTY_STRING_ARRAY;
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 3: Null input
            input = null;
            expected = null;
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 4: Input with whitespace
            input = "   ";
            expected = ArrayUtils.EMPTY_STRING_ARRAY;
            result = (String[]) method.invoke(null, input, null, max, true);
            assertArrayEquals(expected, result);

            // Test case 5: Max limit reached
            input = "a,b,c,d,e";
            expected = new String[]{"a", "b", "c"};
            result = (String[]) method.invoke(null, input, ",", 3, false);
            assertArrayEquals(expected, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}