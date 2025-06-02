package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        String str = "foo,bar,,baz";
        String separatorChars = ",";
        int max = 3;
        boolean preserveAllTokens = true;

        // Using reflection to access the private static method
        try {
            java.lang.reflect.Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);
            String[] result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);

            String[] expected = {"foo", "bar", "", "baz"};
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}