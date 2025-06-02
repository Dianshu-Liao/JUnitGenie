package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid instance of Period
        Period period = new Period(1, 0, 0, 0); // 1 year, 0 months, 0 days, 0 hours, 0 minutes, 0 seconds
        PeriodType type = PeriodType.yearMonthDay(); // Changed to a valid PeriodType

        // Call the method under test
        Period result = null;
        try {
            result = period.normalizedStandard(type);
        } catch (UnsupportedOperationException e) {
            fail("Method threw an exception: " + e.getMessage());
        }

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result.getYears());
        assertEquals(0, result.getMonths());
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardWithUnsupportedOperation() {
        // Create a valid instance of Period
        Period period = new Period(0, 5, 0, 0); // 0 years, 5 months, 0 days, 0 hours, 0 minutes, 0 seconds
        PeriodType type = PeriodType.yearMonthDay(); // Changed to a valid PeriodType that supports months

        // Call the method under test and expect an exception
        try {
            period.normalizedStandard(type);
            fail("Expected UnsupportedOperationException was not thrown.");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }

}