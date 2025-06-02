package org.joda.time.tz;
import org.joda.time.tz.FixedDateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class tz_FixedDateTimeZone_toTimeZone__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToTimeZone_NormalCase() {
        // Setup: Create an instance of FixedDateTimeZone with valid parameters
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "+02:00", 7200000, 7200000);
        
        // Execution: Call the toTimeZone() method
        java.util.TimeZone timeZone = null;
        try {
            timeZone = fixedDateTimeZone.toTimeZone();
        } catch (Exception e) {
            // Handle exception if any
            e.printStackTrace();
        }

        // Assertion: Verify that the returned TimeZone is not null
        assertNotNull(timeZone);
    }

}