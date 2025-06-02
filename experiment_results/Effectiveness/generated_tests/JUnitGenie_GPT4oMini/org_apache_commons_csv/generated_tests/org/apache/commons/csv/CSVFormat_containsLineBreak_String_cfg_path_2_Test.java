package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CSVFormat_containsLineBreak_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsLineBreakWithCR() {
        String testString = "Hello World" + Constants.CR; // Contains Carriage Return
        boolean result = invokeContainsLineBreak(testString);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsLineBreakWithLF() {
        String testString = "Hello World" + Constants.LF; // Contains Line Feed
        boolean result = invokeContainsLineBreak(testString);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsLineBreakWithoutLineBreak() {
        String testString = "Hello World"; // No Line Breaks
        boolean result = invokeContainsLineBreak(testString);
        assertFalse(result);
    }

    private boolean invokeContainsLineBreak(String source) {
        try {
            Method method = CSVFormat.class.getDeclaredMethod("containsLineBreak", String.class);
            method.setAccessible(true);
            return (boolean) method.invoke(null, source);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Handle the exception as needed
        }
    }

}