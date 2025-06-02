package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Non-null, non-empty string
            String input1 = "java.lang.String";
            String expectedOutput1 = "java.lang.String";
            String actualOutput1 = (String) method.invoke(null, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Array type
            String input2 = "[Ljava.lang.String;";
            String expectedOutput2 = "java.lang.String[]";
            String actualOutput2 = (String) method.invoke(null, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Abbreviated type
            String input3 = "S";
            String expectedOutput3 = "java.lang.String[]";
            String actualOutput3 = (String) method.invoke(null, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Null input
            String input4 = null;
            String actualOutput4 = (String) method.invoke(null, input4);
            assertEquals(null, actualOutput4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}