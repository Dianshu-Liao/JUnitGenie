package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_57_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        String input = "a b c";
        String separator = " "; // Changed from null to a space character
        int max = 3;
        boolean preserveAllTokens = true;

        try {
            String[] result = StringUtils.split(input, separator, max);
            String[] expected = {"a", "b", "c"};
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception if needed
        }
    }

    @Test(timeout = 4000)
    public void testSplitWorkerEmptyString() {
        String input = "";
        String separator = " "; // Changed from null to a space character
        int max = 3;
        boolean preserveAllTokens = true;

        try {
            String[] result = StringUtils.split(input, separator, max);
            String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception if needed
        }
    }
    
    @Test(timeout = 4000)
    public void testSplitWorkerNullInput() {
        String input = null;
        String separator = " "; // Changed from null to a space character
        int max = 3;
        boolean preserveAllTokens = true;

        try {
            String[] result = StringUtils.split(input, separator, max);
            String[] expected = null;
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception if needed
        }
    }

}