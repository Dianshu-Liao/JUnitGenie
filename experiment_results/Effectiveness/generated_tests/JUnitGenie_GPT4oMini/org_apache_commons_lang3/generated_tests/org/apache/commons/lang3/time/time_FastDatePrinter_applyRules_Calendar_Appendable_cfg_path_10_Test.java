package org.apache.commons.lang3.time;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testApplyRules() {
        // Create an instance of FastDatePrinter using reflection
        FastDatePrinter fastDatePrinter = null;
        try {
            fastDatePrinter = FastDatePrinter.class.getDeclaredConstructor(String.class, TimeZone.class, Locale.class)
                    .newInstance("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Prepare the Calendar and Appendable instances
        Calendar calendar = Calendar.getInstance();
        StringBuilder buf = new StringBuilder();

        // Access the private method applyRules using reflection
        try {
            Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true);
            Appendable result = (Appendable) method.invoke(fastDatePrinter, calendar, buf);
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}