package org.joda.time.format;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodParser;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class format_PeriodFormatter_checkParser__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCheckParserThrowsUnsupportedOperationException() {
        try {
            // Create an instance of PeriodFormatter with null iParser
            PeriodFormatter formatter = new PeriodFormatter(null, null);
            
            // Access the private method checkParser using reflection
            Method method = PeriodFormatter.class.getDeclaredMethod("checkParser");
            method.setAccessible(true);
            
            // Invoke the method, which should throw an exception
            method.invoke(formatter);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}