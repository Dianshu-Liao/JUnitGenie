package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Test case 1: Normal case with a single character separator
            String str1 = "a,b,c";
            String separator1 = ",";
            int max1 = 3;
            boolean preserveAllTokens1 = false;
            String[] expected1 = {"a", "b", "c"};
            String[] result1 = StringUtils.split(str1, separator1, max1);
            assertArrayEquals(expected1, result1);

            // Test case 2: Empty string
            String str2 = "";
            String separator2 = ",";
            int max2 = 3;
            boolean preserveAllTokens2 = false;
            String[] expected2 = ArrayUtils.EMPTY_STRING_ARRAY;
            String[] result2 = StringUtils.split(str2, separator2, max2);
            assertArrayEquals(expected2, result2);

            // Test case 3: Null string
            String str3 = null;
            String separator3 = ",";
            int max3 = 3;
            boolean preserveAllTokens3 = false;
            String[] expected3 = null;
            String[] result3 = StringUtils.split(str3, separator3, max3);
            assertArrayEquals(expected3, result3);

            // Test case 4: Separator is null (should treat as whitespace)
            String str4 = "a b c";
            String separator4 = null;
            int max4 = 3;
            boolean preserveAllTokens4 = false;
            String[] expected4 = {"a", "b", "c"};
            String[] result4 = StringUtils.split(str4, separator4, max4);
            assertArrayEquals(expected4, result4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}