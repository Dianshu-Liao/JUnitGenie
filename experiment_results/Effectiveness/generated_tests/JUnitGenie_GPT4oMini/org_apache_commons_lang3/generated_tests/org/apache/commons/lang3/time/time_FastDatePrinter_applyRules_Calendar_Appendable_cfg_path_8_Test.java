package org.apache.commons.lang3.time;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testApplyRules() {
        try {
            // Create an instance of FastDatePrinter using reflection
            FastDatePrinter printer = (FastDatePrinter) FastDatePrinter.class
                    .getDeclaredConstructor(String.class, TimeZone.class, Locale.class)
                    .newInstance("pattern", TimeZone.getDefault(), Locale.getDefault());

            // Prepare the Calendar and Appendable objects
            Calendar calendar = Calendar.getInstance();
            StringWriter buf = new StringWriter();

            // Access the private method applyRules using reflection
            java.lang.reflect.Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true);

            // Invoke the method
            Appendable result = (Appendable) method.invoke(printer, calendar, buf);

            // Validate the result
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception as per the focal method's logic
            ExceptionUtils.asRuntimeException(e);
        }
    }

}