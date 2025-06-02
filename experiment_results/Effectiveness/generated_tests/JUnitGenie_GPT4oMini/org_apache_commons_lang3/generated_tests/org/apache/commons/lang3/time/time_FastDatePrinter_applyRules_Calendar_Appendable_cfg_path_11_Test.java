package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.io.StringWriter;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testApplyRules() {
        try {
            // Instantiate the class using reflection
            FastDatePrinter fastDatePrinter = (FastDatePrinter) FastDatePrinter.class
                    .getDeclaredConstructor(String.class, TimeZone.class, Locale.class)
                    .newInstance("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
            
            // Prepare parameters
            Calendar calendar = Calendar.getInstance();
            StringWriter stringWriter = new StringWriter();

            // Access the private method using reflection
            Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true); // Make the method accessible

            // Invoke the applyRules method
            method.invoke(fastDatePrinter, calendar, stringWriter);

            // Validate results
            assertNotNull(stringWriter.toString()); // Ensure the result is not null
        } catch (Exception e) {
            // Handle potential exceptions
            throw new RuntimeException(e);
        }
    }


}