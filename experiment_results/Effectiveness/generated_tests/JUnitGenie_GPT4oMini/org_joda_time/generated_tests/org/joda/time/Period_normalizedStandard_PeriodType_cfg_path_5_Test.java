package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        // Create a valid PeriodType that supports years and months
        PeriodType type = PeriodType.yearMonthDay(); // Corrected method name to yearMonthDay
        
        // Create a valid Period instance with years and months
        Period period = new Period(1, 2, 0, 0, 0, 0, 0, 0); // 1 year, 2 months
        
        // Call the normalizedStandard method
        Period result = period.normalizedStandard(type);
        
        // Validate the result
        assertNotNull(result);
        assertEquals(1, result.getYears());
        assertEquals(2, result.getMonths());
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardThrowsException() {
        // Create a PeriodType that does not support years or months
        PeriodType type = PeriodType.seconds(); // Only supports seconds
        
        // Create a valid Period instance with non-zero years and months
        Period period = new Period(1, 2, 0, 0, 0, 0, 0, 0); // 1 year, 2 months
        
        try {
            // Call the normalizedStandard method
            period.normalizedStandard(type);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Validate the exception message
            assertTrue(e.getMessage().contains("Unable to normalize as PeriodType is missing either years or months"));
        }
    }


}