package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ClassUtils_toCanonicalName_String_cfg_path_3_Test {

    // Mocking the private static final Map abbreviationMap for testing
    static {
        try {
            // Accessing the private static field abbreviationMap using reflection
            Field field = ClassUtils.class.getDeclaredField("abbreviationMap");
            field.setAccessible(true);
            Map<String, String> abbreviationMap = new HashMap<>();
            abbreviationMap.put("java.lang.String", "S");
            field.set(null, abbreviationMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToCanonicalName() {
        try {
            // Accessing the private static method toCanonicalName using reflection
            Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
            method.setAccessible(true);

            // Test case 1: Valid input
            String input = "java.lang.String";
            String expectedOutput = "LS;";
            String actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case 2: Input with array marker
            input = "java.lang.String[]";
            expectedOutput = "[LS;";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case 3: Input with multiple array markers
            input = "java.lang.String[][]";
            expectedOutput = "[[LS;";
            actualOutput = (String) method.invoke(null, input);
            assertEquals(expectedOutput, actualOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}