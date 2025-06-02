package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid PeriodType instance
        PeriodType periodType = PeriodType.yearMonthDayTime(); // Example PeriodType

        // Create a valid Period instance with years and months
        Period period = new Period(1, 1, 0, 0, 0, 0, 0, 0); // 1 year, 1 month

        // Call the normalizedStandard method
        Period result = period.normalizedStandard(periodType);

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result.getYears());
        assertEquals(1, result.getMonths());
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardThrowsException() {
        // Create a valid PeriodType instance
        PeriodType periodType = PeriodType.yearMonthDay(); // Corrected PeriodType that supports years and months

        // Create a valid Period instance with years and months
        Period period = new Period(1, 1, 0, 0, 0, 0, 0, 0); // 1 year, 1 month

        try {
            // Call the normalizedStandard method
            period.normalizedStandard(periodType);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        }
    }

}