package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Non-empty class name with no array dimension
            String className1 = "String";
            String expected1 = "String";
            String actual1 = (String) method.invoke(null, className1);
            assertEquals(expected1, actual1);

            // Test case 2: Non-empty class name with one array dimension
            String className2 = "[String";
            String expected2 = "String[]";
            String actual2 = (String) method.invoke(null, className2);
            assertEquals(expected2, actual2);

            // Test case 3: Non-empty class name with two array dimensions
            String className3 = "[[String";
            String expected3 = "String[][]";
            String actual3 = (String) method.invoke(null, className3);
            assertEquals(expected3, actual3);

            // Test case 4: Non-empty class name with a leading 'L' and trailing ';'
            String className4 = "Ljava/lang/String;";
            String expected4 = "java.lang.String";
            String actual4 = (String) method.invoke(null, className4);
            assertEquals(expected4, actual4);

            // Test case 5: Non-empty class name with a leading 'L' but no trailing ';'
            String className5 = "Ljava/lang/String";
            String expected5 = "java.lang.String";
            String actual5 = (String) method.invoke(null, className5);
            assertEquals(expected5, actual5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}