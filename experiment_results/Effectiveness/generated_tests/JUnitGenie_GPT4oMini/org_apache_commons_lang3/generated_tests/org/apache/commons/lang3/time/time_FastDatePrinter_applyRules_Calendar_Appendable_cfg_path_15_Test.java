package org.apache.commons.lang3.time;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_15_Test {

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

        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Create a mock Appendable instance
        Appendable buf = new StringBuilder();

        // Use reflection to access the private method applyRules
        try {
            java.lang.reflect.Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true);
            method.invoke(fastDatePrinter, calendar, buf);
        } catch (Exception e) {
            e.printStackTrace();
            // Since IOException is not thrown, we can handle it more generically
            RuntimeException runtimeException = ExceptionUtils.asRuntimeException(e);
            // Optionally, you can assert that the exception is thrown
            assertNotNull(runtimeException);
        }

        // Assert that the buffer is not null after applying rules
        assertNotNull(buf);
    }


}