package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_68_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        try {
            // Accessing the private static splitWorker method via reflection
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);

            // Test inputs
            String str = "Hello World";
            String separatorChars = " ";
            int max = 2;
            boolean preserveAllTokens = true;

            // Expected output
            String[] expectedResult = {"Hello", "World"};

            // Invoke the method
            String[] result = (String[]) method.invoke(null, str, separatorChars, max, preserveAllTokens);

            // Assert results
            assertArrayEquals(expectedResult, result);

        } catch (Exception e) {
            // Handle exception
            fail("Exception thrown: " + e.getMessage());
        }
    }

}