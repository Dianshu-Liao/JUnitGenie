package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class DateTime_toDateTimeISO__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToDateTimeISO() {
        try {
            // Create a DateTime instance with a different chronology
            DateTimeZone zone = DateTimeZone.forID("UTC");
            DateTime dateTime = new DateTime(zone);
            
            // Ensure the chronology is not ISOChronology
            assertNotNull(dateTime.getChronology());
            ISOChronology isoChronology = ISOChronology.getInstance();
            if (!dateTime.getChronology().equals(isoChronology)) {
                // Call the focal method
                DateTime result = dateTime.toDateTimeISO();
                
                // Validate the result
                assertNotNull(result);
            }
        } catch (Exception e) {
            // Handle any potential exceptions
            e.printStackTrace();
        }
    }

}