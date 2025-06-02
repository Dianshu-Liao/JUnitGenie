package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class CSVFormat_containsLineBreak_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContainsLineBreak() {
        try {
            // Access the private static method using reflection
            Method method = CSVFormat.class.getDeclaredMethod("containsLineBreak", String.class);
            method.setAccessible(true);

            // Test case 1: String containing CR
            String testString1 = "Hello\rWorld";
            boolean result1 = (boolean) method.invoke(null, testString1);
            assertTrue(result1); // Expecting true since it contains CR

            // Test case 2: String containing LF
            String testString2 = "Hello\nWorld";
            boolean result2 = (boolean) method.invoke(null, testString2);
            assertTrue(result2); // Expecting true since it contains LF

            // Test case 3: String without line breaks
            String testString3 = "Hello World";
            boolean result3 = (boolean) method.invoke(null, testString3);
            assertTrue(!result3); // Expecting false since it does not contain CR or LF

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}