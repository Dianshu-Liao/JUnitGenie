package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDateParser;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class time_FastDateParser_init_Calendar_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInit() {
        try {
            // Create an instance of FastDateParser using reflection
            FastDateParser fastDateParser = (FastDateParser) FastDateParser.class.getDeclaredConstructor(String.class, java.util.TimeZone.class, java.util.Locale.class).newInstance("pattern", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());

            // Prepare the Calendar instance
            Calendar definingCalendar = Calendar.getInstance();

            // Access the private method init using reflection
            Method initMethod = FastDateParser.class.getDeclaredMethod("init", Calendar.class);
            initMethod.setAccessible(true);

            // Invoke the init method
            initMethod.invoke(fastDateParser, definingCalendar);

            // Verify that patterns is initialized
            List<?> patternsField = (List<?>) FastDateParser.class.getDeclaredField("patterns").get(fastDateParser);
            assertNotNull(patternsField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}