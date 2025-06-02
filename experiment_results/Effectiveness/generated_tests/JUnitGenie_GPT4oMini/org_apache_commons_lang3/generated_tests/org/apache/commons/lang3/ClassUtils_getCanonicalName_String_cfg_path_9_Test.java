package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalName() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);

            // Test input that meets the constraints
            String input = "  [Lcom.example.MyClass;  ";
            String expectedOutput = "com.example.MyClass[]";
            String actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}