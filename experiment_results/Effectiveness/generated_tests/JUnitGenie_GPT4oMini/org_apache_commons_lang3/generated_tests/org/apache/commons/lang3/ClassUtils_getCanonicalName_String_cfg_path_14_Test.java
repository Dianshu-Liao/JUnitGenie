package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Valid class name with no dimensions
            String input1 = "String";
            String expectedOutput1 = "String";
            String actualOutput1 = (String) method.invoke(null, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Valid class name with dimensions
            String input2 = "[[LString;";
            String expectedOutput2 = "String[][]";
            String actualOutput2 = (String) method.invoke(null, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Valid class name with abbreviation
            String input3 = "I";
            String expectedOutput3 = "int";
            String actualOutput3 = (String) method.invoke(null, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Valid class name with whitespace
            String input4 = "   String   ";
            String expectedOutput4 = "String";
            String actualOutput4 = (String) method.invoke(null, input4);
            assertEquals(expectedOutput4, actualOutput4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}