package org.joda.time.format;
import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_ISOPeriodFormat_alternateExtendedWithWeeks__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAlternateExtendedWithWeeks() {
        try {
            // Call the focal method
            PeriodFormatter formatter = ISOPeriodFormat.alternateExtendedWithWeeks();
            
            // Validate that the formatter is not null
            assertNotNull("Formatter should not be null", formatter);
            
            // Create a Period object to format
            Period period = new Period(0, 0, 0, 0, 0, 0, 0, 0);
            String formatted = formatter.print(period);
            assertEquals("P0000-W00-D00T00:00:00", formatted);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}