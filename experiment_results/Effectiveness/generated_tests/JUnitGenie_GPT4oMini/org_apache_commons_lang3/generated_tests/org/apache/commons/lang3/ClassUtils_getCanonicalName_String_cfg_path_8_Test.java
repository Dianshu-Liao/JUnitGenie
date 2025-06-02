package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Valid input with one dimension
            String input1 = "[Lcom.example.MyClass;";
            String expectedOutput1 = "com.example.MyClass[]";
            String actualOutput1 = (String) method.invoke(null, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Valid input with no dimensions
            String input2 = "String";
            String expectedOutput2 = "String";
            String actualOutput2 = (String) method.invoke(null, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Valid input with multiple dimensions
            String input3 = "[[[Lcom.example.MyClass;";
            String expectedOutput3 = "com.example.MyClass[][][]";
            String actualOutput3 = (String) method.invoke(null, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Input with whitespace
            String input4 = "   String   ";
            String expectedOutput4 = "String";
            String actualOutput4 = (String) method.invoke(null, input4);
            assertEquals(expectedOutput4, actualOutput4);

            // Test case 5: Input that is null
            String input5 = null;
            String actualOutput5 = (String) method.invoke(null, input5);
            assertEquals(null, actualOutput5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}