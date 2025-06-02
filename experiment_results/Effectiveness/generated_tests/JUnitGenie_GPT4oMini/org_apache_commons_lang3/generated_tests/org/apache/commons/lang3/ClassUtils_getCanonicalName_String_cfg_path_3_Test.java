package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Non-empty string with no array dimension
            String input1 = "String";
            String expectedOutput1 = "String";
            String actualOutput1 = (String) method.invoke(null, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Non-empty string with one array dimension
            String input2 = "[String";
            String expectedOutput2 = "String[]";
            String actualOutput2 = (String) method.invoke(null, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Non-empty string with two array dimensions
            String input3 = "[[String";
            String expectedOutput3 = "String[][]";
            String actualOutput3 = (String) method.invoke(null, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Non-empty string with class reference
            String input4 = "Lcom/example/MyClass;";
            String expectedOutput4 = "com.example.MyClass";
            String actualOutput4 = (String) method.invoke(null, input4);
            assertEquals(expectedOutput4, actualOutput4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}