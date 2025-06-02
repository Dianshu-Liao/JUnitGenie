package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        // Test case 1: Normal case with multiple tokens
        String input = "a,b,c";
        String separator = ",";
        int max = 3;
        boolean preserveAllTokens = false;
        String[] expected = {"a", "b", "c"};
        String[] result = StringUtils.split(input, separator, max);
        assertArrayEquals(expected, result);

        // Test case 2: Input string is null
        input = null;
        expected = null;
        result = StringUtils.split(input, separator, max);
        assertArrayEquals(expected, result);

        // Test case 3: Input string is empty
        input = "";
        expected = ArrayUtils.EMPTY_STRING_ARRAY;
        result = StringUtils.split(input, separator, max);
        assertArrayEquals(expected, result);

        // Test case 4: Separator is null (should treat whitespace as separator)
        input = "   a   b   c   ";
        separator = null;
        expected = new String[]{"", "a", "b", "c", ""};
        result = StringUtils.split(input, separator, max);
        assertArrayEquals(expected, result);
    }


}