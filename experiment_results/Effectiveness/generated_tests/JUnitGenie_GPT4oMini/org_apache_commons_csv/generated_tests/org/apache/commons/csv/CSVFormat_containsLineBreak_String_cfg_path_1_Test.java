package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CSVFormat_containsLineBreak_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsLineBreak() {
        // Accessing the private static method using reflection
        try {
            // Prepare the input string that meets the constraints
            String input = "This is a test string without line breaks.";

            // Invoke the private static method containsLineBreak
            java.lang.reflect.Method method = CSVFormat.class.getDeclaredMethod("containsLineBreak", String.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, input);

            // Assert that the result is false, as there are no line breaks
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}