package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_toCanonicalName_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
            method.setAccessible(true);

            // Test case with a valid string
            String input = "java.lang.String";
            String expectedOutput = "Ljava.lang.String;";
            String actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case with an array type
            input = "java.lang.String[]";
            expectedOutput = "[Ljava.lang.String;";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case with an empty string
            input = "";
            expectedOutput = "L;";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}