package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_71_Test {

    @Test(timeout = 4000)
    public void testSplitWorkerWithNonEmptyString() throws Exception {
        // Accessing the private static method using reflection
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        
        String str = "abc def ghi";
        String separatorChars = null; // Using whitespace
        int max = 10;
        boolean preserveAllTokens = false;

        String[] expected = {"abc", "def", "ghi"};
        String[] actual = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
        
        assertArrayEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithEmptyString() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        
        String str = "";
        String separatorChars = null; // Using whitespace
        int max = 10;
        boolean preserveAllTokens = false;

        String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;
        String[] actual = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
        
        assertArrayEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithNullString() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        
        String str = null;
        String separatorChars = null; // Using whitespace
        int max = 10;
        boolean preserveAllTokens = false;

        String[] expected = null;
        String[] actual = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
        
        assertArrayEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithSeparator() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        
        String str = "a,b,c";
        String separatorChars = ",";
        int max = 10;
        boolean preserveAllTokens = false;

        String[] expected = {"a", "b", "c"};
        String[] actual = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);
        
        assertArrayEquals(expected, actual);
    }

}