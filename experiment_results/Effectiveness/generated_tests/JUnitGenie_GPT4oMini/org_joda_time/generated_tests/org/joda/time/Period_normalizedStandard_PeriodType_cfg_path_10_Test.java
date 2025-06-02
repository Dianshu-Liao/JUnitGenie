package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid PeriodType
        PeriodType periodType = PeriodType.yearMonthDay();

        // Create a valid Period instance
        Period period = new Period(1, 0, 0, 0); // 1 year, 0 months, 0 days, 0 hours, 0 minutes, 0 seconds

        // Call the method under test
        Period result = period.normalizedStandard(periodType);

        // Validate the result
        assertNotNull(result);
        assertEquals(1, result.getYears());
        assertEquals(0, result.getMonths());
        assertEquals(0, result.getDays());
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardWithUnsupportedOperationException() {
        // Create a valid PeriodType
        PeriodType periodType = PeriodType.forFields(new DurationFieldType[]{DurationFieldType.YEARS_TYPE});

        // Create a valid Period instance with months
        Period period = new Period(0, 1, 0, 0); // 0 years, 1 month, 0 days, 0 hours, 0 minutes, 0 seconds

        try {
            // Call the method under test
            period.normalizedStandard(periodType);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Expected exception
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        }
    }

}