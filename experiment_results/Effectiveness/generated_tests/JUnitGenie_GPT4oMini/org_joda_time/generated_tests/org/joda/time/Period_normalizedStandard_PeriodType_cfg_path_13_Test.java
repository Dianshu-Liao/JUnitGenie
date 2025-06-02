package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandardWithValidPeriodType() {
        Period period = new Period(1, 2, 3, 4, 5, 6, 7, 8); // Example initialization
        PeriodType type = PeriodType.yearMonthDayTime(); // Example PeriodType

        try {
            Period result = period.normalizedStandard(type);
            assertNotNull(result);
            // Additional assertions can be added here to verify the result
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardWithUnsupportedOperationException() {
        Period period = new Period(1, 0, 0, 0); // Example initialization with years but no months
        PeriodType type = PeriodType.yearMonthDay(); // Example PeriodType that does not support months

        try {
            period.normalizedStandard(type);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        } catch (Exception e) {
            fail("Expected UnsupportedOperationException, but got: " + e.getMessage());
        }
    }

}