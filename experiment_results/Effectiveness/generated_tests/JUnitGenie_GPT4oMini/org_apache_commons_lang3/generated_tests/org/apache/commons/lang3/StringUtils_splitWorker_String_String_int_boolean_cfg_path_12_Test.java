package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() throws Exception {
        // Prepare reflection to access the private static method
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        
        // Test case where str is null
        String[] result = (String[]) method.invoke(null, null, " ", 0, false);
        assertNull(result);
        
        // Test case where str is empty
        result = (String[]) method.invoke(null, "", " ", 0, false);
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
        
        // Test case for normal splitting
        result = (String[]) method.invoke(null, "a,b,c", ",", 2, false);
        assertArrayEquals(new String[] {"a", "b"}, result);
        
        // Test case where preserveAllTokens is true
        result = (String[]) method.invoke(null, "a,b,c", ",", 5, true);
        assertArrayEquals(new String[] {"a", "b", "c"}, result);
        
        // Test case where max is reached
        result = (String[]) method.invoke(null, "a,b,c,d", ",", 3, false);
        assertArrayEquals(new String[] {"a", "b", "c"}, result);
        
        // Test case with whitespace as separator
        result = (String[]) method.invoke(null, "a b c", null, 5, false);
        assertArrayEquals(new String[] {"a", "b", "c"}, result);
    }

}