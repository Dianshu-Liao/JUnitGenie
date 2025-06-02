package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Test case with normal string
            String str = "one,two,three";
            String separatorChars = ",";
            int max = 3;
            boolean preserveAllTokens = true;
            String[] expected = {"one", "two", "three"};
            String[] result = StringUtils.split(str, separatorChars, max);
            assertArrayEquals(expected, result);
            
            // Test case with empty string
            str = "";
            expected = ArrayUtils.EMPTY_STRING_ARRAY;
            result = StringUtils.split(str, separatorChars, max);
            assertArrayEquals(expected, result);
            
            // Test case with null input
            str = null;
            expected = null;
            result = StringUtils.split(str, separatorChars, max);
            assertArrayEquals(expected, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}