package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DurationFieldType;
import org.joda.time.field.FieldUtils;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Initializing PeriodType to represent both years and months
        PeriodType type = PeriodType.yearMonthDay(); // Corrected to use yearMonthDay()
        // Creating an instance of Period with a non-zero year and month
        Period period = new Period(1, 1, 0, 0, 0, 0, 0, 0); // 1 year, 1 month

        try {
            // Call the method under test
            Period result = period.normalizedStandard(type); // Using the corrected PeriodType
            // Verifying the normalized result
            assertNotNull(result);
            assertEquals(1, result.getYears());
            assertEquals(1, result.getMonths());
        } catch (UnsupportedOperationException e) {
            fail("Method threw an exception: " + e.getMessage());
        }

        // Testing with PeriodType that doesn't support years or months
        PeriodType noYearsOrMonthsType = PeriodType.seconds();

        try {
            period = new Period(1, 1, 0, 0, 0, 0, 0, 0); // 1 year, 1 month
            period.normalizedStandard(noYearsOrMonthsType);
            fail("Expected an UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }

}