package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid PeriodType that supports all fields
        PeriodType type = PeriodType.yearMonthDayTime();

        // Create a valid Period instance
        Period period = new Period(1, 2, 3, 4, 0, 0, 0, 0, type); // 1 year, 2 months, 3 days, etc.

        try {
            // Call the normalizedStandard method
            Period result = period.normalizedStandard(type);
            assertNotNull(result);
            // Additional assertions can be added here to verify the result
        } catch (UnsupportedOperationException e) {
            // Handle the exception if thrown
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardWithUnsupportedOperation() {
        // Create a PeriodType that does not support years or months
        PeriodType type = PeriodType.hours();

        // Create a valid Period instance
        Period period = new Period(0, 0, 0, 0, 5, 0, 0, 0, type); // 5 hours

        try {
            // Call the normalizedStandard method
            period.normalizedStandard(type);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Expected exception
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        }
    }


}