package org.joda.time.format;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodParser;
import org.junit.Test;
import java.lang.reflect.Method;

public class format_PeriodFormatter_checkParser__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckParser() {
        try {
            // Create an instance of PeriodFormatter with a null iParser
            PeriodFormatter formatter = new PeriodFormatter(null, null);
            
            // Access the private method checkParser using reflection
            Method method = PeriodFormatter.class.getDeclaredMethod("checkParser");
            method.setAccessible(true);
            
            // Invoke the method to test the exception throwing
            method.invoke(formatter);
        } catch (UnsupportedOperationException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            // If any other exception occurs, fail the test
            e.printStackTrace();
            assert false : "Unexpected exception thrown: " + e.getMessage();
        }
    }

}