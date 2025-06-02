package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DurationFieldType;
import org.joda.time.field.FieldUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid PeriodType
        PeriodType type = PeriodType.yearMonthDayTime(); // Changed to a valid PeriodType that supports all fields

        // Create a valid Period instance
        Period period = new Period(1, 2, 3, 4, 5, 6, 7, 0, type); // 1 year, 2 months, etc. (last parameter is for weeks)

        // Call the focal method
        Period result = period.normalizedStandard(type);

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result.getYears());
        assertEquals(2, result.getMonths());
        assertEquals(3, result.getDays());
        assertEquals(4, result.getHours());
        assertEquals(5, result.getMinutes());
        assertEquals(6, result.getSeconds());
        assertEquals(0, result.getMillis()); // Adjusted to match the period created
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardThrowsException() {
        // Create a valid PeriodType that does not support years or months
        PeriodType type = PeriodType.time(); // Example of a PeriodType that does not support years or months

        // Create a valid Period instance with non-zero years and months
        Period period = new Period(1, 1, 0, 0); // 1 year, 1 month

        try {
            // Call the focal method
            period.normalizedStandard(type);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        }
    }


}