package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid PeriodType instance
        PeriodType type = PeriodType.yearMonthDay(); // Example of a valid PeriodType

        // Create a valid Period instance without weeks
        Period period = new Period(1, 2, 3, 0, 0, 0, 0, 0, type); // 1 year, 2 months, 3 days

        try {
            Period result = period.normalizedStandard(type);
            assertNotNull(result);
            // Additional assertions can be added here to verify the properties of the result
        } catch (UnsupportedOperationException e) {
            fail("Expected normalization to succeed, but got an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardWithUnsupportedOperation() {
        // Create a valid PeriodType instance that does not support years or months
        PeriodType type = PeriodType.hours(); // Example of a PeriodType that does not support years or months

        // Create a valid Period instance
        Period period = new Period(0, 0, 0, 0, 5, 0, 0, 0, type); // 5 hours

        try {
            period.normalizedStandard(type);
            fail("Expected an UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        }
    }


}