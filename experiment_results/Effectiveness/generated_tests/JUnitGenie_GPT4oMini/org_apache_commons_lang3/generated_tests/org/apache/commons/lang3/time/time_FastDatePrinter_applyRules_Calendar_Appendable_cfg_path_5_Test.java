package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testApplyRules() {
        try {
            // Create an instance of FastDatePrinter using reflection
            FastDatePrinter printer = (FastDatePrinter) FastDatePrinter.class
                    .getDeclaredConstructor(String.class, TimeZone.class, Locale.class)
                    .newInstance("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());

            // Prepare the Calendar and Appendable
            Calendar calendar = Calendar.getInstance();
            StringWriter buf = new StringWriter();

            // Access the private method applyRules using reflection
            Method applyRulesMethod = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            applyRulesMethod.setAccessible(true);

            // Invoke the method
            Appendable result = (Appendable) applyRulesMethod.invoke(printer, calendar, buf);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}