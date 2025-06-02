package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Non-null, non-empty string
            String input = "java.lang.String";
            String expectedOutput = "java.lang.String";
            String actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case 2: Array type
            input = "[Ljava.lang.String;";
            expectedOutput = "java.lang.String[]";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case 3: Abbreviated type
            input = "I";
            expectedOutput = "int";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}