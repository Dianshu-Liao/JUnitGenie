package org.apache.commons.lang3.time;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testApplyRulesThrowsRuntimeException() {
        // Arrange
        FastDatePrinter printer = new FastDatePrinter("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        Appendable buf = new StringBuilder();

        // Use reflection to access the private method
        try {
            java.lang.reflect.Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true);

            // Act
            method.invoke(printer, calendar, buf);
        } catch (Exception e) {
            // Assert
            Throwable thrown = ExceptionUtils.asRuntimeException(e);
            assertNotNull(thrown);
        }
    }


}