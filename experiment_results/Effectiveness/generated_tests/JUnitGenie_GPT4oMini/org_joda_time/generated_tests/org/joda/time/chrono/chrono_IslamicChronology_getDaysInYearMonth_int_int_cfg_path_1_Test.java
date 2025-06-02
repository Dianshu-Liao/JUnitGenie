package org.joda.time.chrono;
import org.joda.time.chrono.IslamicChronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_IslamicChronology_getDaysInYearMonth_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetDaysInYearMonth_NonLeapYearDecember() {
        IslamicChronology chronology = IslamicChronology.getInstance(); // Use the default instance
        int year = 2021; // Non-leap year
        int month = 12; // December
        try {
            int days = chronology.getDaysInYearMonth(year, month);
            assertEquals(29, days); // December should return 29 days in a non-leap year
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetDaysInYearMonth_NonLeapYearOtherMonths() {
        IslamicChronology chronology = IslamicChronology.getInstance(); // Use the default instance
        int year = 2021; // Non-leap year
        int month = 10; // October
        try {
            int days = chronology.getDaysInYearMonth(year, month);
            assertEquals(30, days); // October should return 30 days
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }


}