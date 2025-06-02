package org.apache.commons.lang3.time;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.Assert.assertNotNull;

public class time_FastDatePrinter_applyRules_Calendar_Appendable_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testApplyRulesWithExceptionHandling() {
        // Arrange
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        FastDatePrinter printer = new FastDatePrinter(pattern, timeZone, locale);
        
        Calendar calendar = Calendar.getInstance();
        Appendable buffer = new StringBuilder();

        // Use reflection to access the private method
        try {
            Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, Appendable.class);
            method.setAccessible(true);
            
            // Act
            Appendable result = (Appendable) method.invoke(printer, calendar, buffer);
            
            // Assert
            assertNotNull(result); // Verify that the result is not null
        } catch (Exception e) {
            // Handle the reflection exceptions
            throw ExceptionUtils.asRuntimeException(e);
        }
    }


}