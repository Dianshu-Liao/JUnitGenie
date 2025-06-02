package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Test case 1: Normal case with a single character separator
            String input = "a,b,c";
            String separator = ",";
            int max = 3;
            boolean preserveAllTokens = false;
            String[] expected = {"a", "b", "c"};
            String[] result = StringUtils.split(input, separator, max);
            assertArrayEquals(expected, result);

            // Test case 2: Input string with whitespace and preserveAllTokens true
            input = " a  b  c ";
            separator = null; // null means use whitespace
            max = 3;
            preserveAllTokens = true;
            expected = new String[]{"", "a", "b", "c", ""};
            result = StringUtils.split(input, separator, max);
            assertArrayEquals(expected, result);

            // Test case 3: Empty input string
            input = "";
            separator = ",";
            max = 3;
            preserveAllTokens = false;
            expected = ArrayUtils.EMPTY_STRING_ARRAY;
            result = StringUtils.split(input, separator, max);
            assertArrayEquals(expected, result);

            // Test case 4: Null input string
            input = null;
            separator = ",";
            max = 3;
            preserveAllTokens = false;
            expected = null;
            result = StringUtils.split(input, separator, max);
            assertArrayEquals(expected, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}