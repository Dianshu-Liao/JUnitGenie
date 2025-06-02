package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Accessing the private static method using reflection
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test case 1: Normal case
            String str = "a,b,c";
            String separatorChars = ",";
            int max = 3;
            boolean preserveAllTokens = false;
            String[] expected = {"a", "b", "c"};
            String[] result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 2: Empty string
            str = "";
            expected = ArrayUtils.EMPTY_STRING_ARRAY;
            result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 3: Null string
            str = null;
            expected = null;
            result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(expected, result);

            // Test case 4: Preserve all tokens
            str = "a,,b";
            separatorChars = ",";
            max = 3;
            preserveAllTokens = true;
            expected = new String[]{"a", "", "b"};
            result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(expected, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}