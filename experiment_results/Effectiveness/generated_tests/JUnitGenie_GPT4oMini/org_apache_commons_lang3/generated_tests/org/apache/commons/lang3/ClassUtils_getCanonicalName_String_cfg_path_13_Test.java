package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case: Non-null string with array dimension
            String input = "[[Lcom.example.MyClass;";
            String expectedOutput = "com.example.MyClass[][]";
            String actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case: Non-null string without array dimension
            input = "Lcom.example.MyClass;";
            expectedOutput = "com.example.MyClass";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case: Non-null string with abbreviation
            input = "[I";
            expectedOutput = "int[]";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case: Non-null string with no valid input
            input = "InvalidInput";
            expectedOutput = "InvalidInput"; // Assuming it returns the same string if not matched
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case: Null input (should return null)
            input = null;
            actualOutput = (String) method.invoke(null, input);
            assertEquals(null, actualOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}