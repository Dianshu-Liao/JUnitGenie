package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_84_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test with valid inputs
            String str = "one,two,three";
            String separator = ",";
            int max = 3;
            boolean preserveAllTokens = false;
            String[] result = (String[]) method.invoke(null, str, separator, max, preserveAllTokens);
            assertArrayEquals(new String[]{"one", "two", "three"}, result);

            // Test with a string that has fewer tokens than max
            str = "one|two";
            separator = "|";
            result = (String[]) method.invoke(null, str, separator, 5, false);
            assertArrayEquals(new String[]{"one", "two"}, result);

            // Test with a null string
            result = (String[]) method.invoke(null, null, separator, max, preserveAllTokens);
            assertNull(result);

            // Test with an empty string
            str = "";
            result = (String[]) method.invoke(null, str, separator, max, preserveAllTokens);
            assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);

            // Test with whitespace and preserveAllTokens set to true
            str = "   ";
            separator = null;
            preserveAllTokens = true;
            result = (String[]) method.invoke(null, str, separator, max, preserveAllTokens);
            assertArrayEquals(new String[]{"", "", "", ""}, result);

        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception occurred: " + e.getMessage());
        }
    }

}