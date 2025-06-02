package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.reflect.Method;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_46_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Given
            String inputStr = "abc def ghi";
            String separatorChars = " ";
            int max = 5;
            boolean preserveAllTokens = true;

            // Accessing the private static method using reflection
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // When
            String[] result = (String[]) method.invoke(null, inputStr, separatorChars, max, preserveAllTokens);

            // Then
            String[] expected = {"abc", "def", "ghi"};
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception for the throws clause
        }
    }
    
    @Test(timeout = 4000)
    public void testSplitWorker_NullInput() {
        try {
            // Given
            String inputStr = null;
            String separatorChars = " ";
            int max = 5;
            boolean preserveAllTokens = true;

            // When
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);
            String[] result = (String[]) method.invoke(null, inputStr, separatorChars, max, preserveAllTokens);

            // Then
            assertArrayEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception for the throws clause
        }
    }

    @Test(timeout = 4000)
    public void testSplitWorker_EmptyString() {
        try {
            // Given
            String inputStr = "";
            String separatorChars = " ";
            int max = 5;
            boolean preserveAllTokens = true;

            // When
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);
            String[] result = (String[]) method.invoke(null, inputStr, separatorChars, max, preserveAllTokens);

            // Then
            assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception for the throws clause
        }
    }

}