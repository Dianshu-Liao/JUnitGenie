package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_74_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test case 1: normal case with separators
            String str = "a,b,c";
            String separatorChars = ",";
            int max = 3;
            boolean preserveAllTokens = false;

            String[] result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(new String[]{"a", "b", "c"}, result);

            // Test case 2: empty string
            str = "";
            String[] resultEmpty = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, resultEmpty);

            // Test case 3: null string
            str = null;
            String[] resultNull = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertNull(resultNull);

            // Test case 4: preserveAllTokens with empty string
            str = "";
            preserveAllTokens = true;
            String[] resultPreserve = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
            assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, resultPreserve);

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}