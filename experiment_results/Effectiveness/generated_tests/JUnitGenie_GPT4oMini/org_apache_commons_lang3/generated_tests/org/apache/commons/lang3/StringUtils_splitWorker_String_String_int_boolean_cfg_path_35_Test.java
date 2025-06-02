package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Accessing the private static method using reflection
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test case 1: Normal case
            String str1 = "a,b,c";
            String separator1 = ",";
            int max1 = 3;
            boolean preserveAllTokens1 = false;
            String[] expected1 = {"a", "b", "c"};
            String[] result1 = (String[]) method.invoke(null, str1, separator1, max1, preserveAllTokens1);
            assertArrayEquals(expected1, result1);

            // Test case 2: Empty string
            String str2 = "";
            String separator2 = ",";
            int max2 = 3;
            boolean preserveAllTokens2 = false;
            String[] expected2 = ArrayUtils.EMPTY_STRING_ARRAY;
            String[] result2 = (String[]) method.invoke(null, str2, separator2, max2, preserveAllTokens2);
            assertArrayEquals(expected2, result2);

            // Test case 3: Null string
            String str3 = null;
            String separator3 = ",";
            int max3 = 3;
            boolean preserveAllTokens3 = false;
            String[] expected3 = null;
            String[] result3 = (String[]) method.invoke(null, str3, separator3, max3, preserveAllTokens3);
            assertArrayEquals(expected3, result3);

            // Test case 4: Separator is null (whitespace)
            String str4 = "a b c";
            String separator4 = null;
            int max4 = 3;
            boolean preserveAllTokens4 = false;
            String[] expected4 = {"a", "b", "c"};
            String[] result4 = (String[]) method.invoke(null, str4, separator4, max4, preserveAllTokens4);
            assertArrayEquals(expected4, result4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}