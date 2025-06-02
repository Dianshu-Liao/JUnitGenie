package org.joda.time.chrono;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.DateTimeZone;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_GregorianChronology_calculateFirstDayOfYearMillis_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCalculateFirstDayOfYearMillis() {
        DateTimeZone zone = DateTimeZone.UTC; // Set a specific DateTimeZone
        GregorianChronology chronology = GregorianChronology.getInstance(zone);
        int year = 2000; // A leap year that satisfies the constraints

        try {
            long result = chronology.calculateFirstDayOfYearMillis(year);
            long expected = 946684800000L; // Expected result for the year 2000
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}