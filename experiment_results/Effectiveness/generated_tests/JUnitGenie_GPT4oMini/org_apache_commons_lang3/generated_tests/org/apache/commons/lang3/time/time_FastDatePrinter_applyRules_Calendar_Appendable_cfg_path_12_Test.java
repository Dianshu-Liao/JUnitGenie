package org.apache.commons.lang3.time;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testApplyRules() {
        try {
            // Create an instance of FastDatePrinter using reflection
            FastDatePrinter printer = (FastDatePrinter) FastDatePrinter.class
                    .getDeclaredConstructor(String.class, TimeZone.class, Locale.class)
                    .newInstance("pattern", TimeZone.getDefault(), Locale.getDefault());

            // Prepare the Calendar and Appendable
            Calendar calendar = Calendar.getInstance();
            StringBuilder buf = new StringBuilder();

            // Invoke the private method applyRules using reflection
            java.lang.reflect.Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true);
            Appendable result = (Appendable) method.invoke(printer, calendar, buf);

            // Verify the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            // Handle any exceptions that may occur
            throw ExceptionUtils.asRuntimeException(e);
        }
    }


}