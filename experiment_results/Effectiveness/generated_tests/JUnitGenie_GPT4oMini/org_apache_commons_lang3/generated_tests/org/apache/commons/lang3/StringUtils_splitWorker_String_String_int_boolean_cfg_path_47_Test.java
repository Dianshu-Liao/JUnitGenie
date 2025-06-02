package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.reflect.Method;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_47_Test {

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

            // Test case 2: Input string is null
            input = null;
            expected = null;
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 3: Input string is empty
            input = "";
            expected = ArrayUtils.EMPTY_STRING_ARRAY;
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 4: Separator is null (should treat whitespace as separator)
            input = "   a   b   ";
            separator = null;
            expected = new String[]{"", "a", "b", ""};
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 5: Max is less than the number of tokens
            input = "a,b,c,d,e";
            separator = ",";
            max = 3;
            preserveAllTokens = false;
            expected = new String[]{"a", "b", "c"};
            result = (String[]) method.invoke(null, input, separator, max, preserveAllTokens);
            assertArrayEquals(expected, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}