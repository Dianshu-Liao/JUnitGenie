package org.joda.time.chrono;
import static org.junit.Assert.assertEquals;
import org.joda.time.chrono.IslamicChronology;

public class chrono_IslamicChronology_getDaysInYearMonth_int_int_cfg_path_2_Test {

    @org.junit.Test
    public void testGetDaysInYearMonth_notLeapYear() {
        IslamicChronology islamicChronology = IslamicChronology.getInstance(); // Corrected instantiation

        int year = 1442; // Example year that is not a leap year in the Islamic calendar
        int month = 12; // Testing for the month of December
        
        // Expect the method to return the length of the month as 30 days
        try {
            int days = islamicChronology.getDaysInYearMonth(year, month);
            assertEquals(30, days);
        } catch(Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}