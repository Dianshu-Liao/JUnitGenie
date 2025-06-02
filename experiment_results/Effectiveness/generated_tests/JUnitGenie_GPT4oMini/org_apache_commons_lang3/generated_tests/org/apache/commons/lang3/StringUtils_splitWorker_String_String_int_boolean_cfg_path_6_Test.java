package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() throws Exception {
        Method splitWorkerMethod = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        splitWorkerMethod.setAccessible(true);

        // Test case parameters
        String str = "a,b,c,d";
        String separatorChars = ",";
        int max = 5;
        boolean preserveAllTokens = true;

        // Expected result
        String[] expected = {"a", "b", "c", "d"};
        
        // Invoke the method
        String[] result = (String[]) splitWorkerMethod.invoke(null, str, separatorChars, max, preserveAllTokens);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithNullStr() throws Exception {
        Method splitWorkerMethod = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        splitWorkerMethod.setAccessible(true);

        String str = null;
        String separatorChars = ",";
        int max = 5;
        boolean preserveAllTokens = true;

        // Expected result
        String[] expected = null;

        // Invoke the method
        String[] result = (String[]) splitWorkerMethod.invoke(null, str, separatorChars, max, preserveAllTokens);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithEmptyString() throws Exception {
        Method splitWorkerMethod = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        splitWorkerMethod.setAccessible(true);

        String str = "";
        String separatorChars = ",";
        int max = 5;
        boolean preserveAllTokens = true;

        // Expected result
        String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;

        // Invoke the method
        String[] result = (String[]) splitWorkerMethod.invoke(null, str, separatorChars, max, preserveAllTokens);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    // Additional test cases can be added below to cover more scenarios

}