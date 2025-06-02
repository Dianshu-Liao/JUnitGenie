package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        // Prepare the parameters for the method
        String str = "a,b,c";
        String separatorChars = ",";
        int max = 3;
        boolean preserveAllTokens = false;

        // Use reflection to access the private static method
        try {
            java.lang.reflect.Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);
            String[] result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);

            // Expected result
            String[] expected = {"a", "b", "c"};
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}