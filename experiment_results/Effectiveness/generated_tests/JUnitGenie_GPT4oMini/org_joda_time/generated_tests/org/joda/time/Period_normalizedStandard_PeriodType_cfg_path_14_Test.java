package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_14_Test {
    
    @Test(timeout = 4000)
    public void testNormalizedStandard() {
        Period period = new Period(1, 0, 0, 0); // 1 day
        PeriodType periodType = PeriodType.yearMonthDay(); // Valid PeriodType
        
        Period result = null;
        try {
            result = period.normalizedStandard(periodType);
        } catch (UnsupportedOperationException e) {
            fail("Exception should not be thrown for a valid normalization.");
        }
        
        assertNotNull(result);
        assertEquals(0, result.getYears());
        assertEquals(0, result.getMonths());
        assertEquals(1, result.getDays());
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardWithMonths() {
        Period period = new Period(0, 1, 0, 0); // 1 month
        PeriodType periodType = PeriodType.yearMonthDay(); // Valid PeriodType
        
        Period result = null;
        try {
            result = period.normalizedStandard(periodType);
        } catch (UnsupportedOperationException e) {
            fail("Exception should not be thrown for a valid normalization.");
        }
        
        assertNotNull(result);
        assertEquals(0, result.getYears());
        assertEquals(1, result.getMonths());
        assertEquals(0, result.getDays());
    }

    @Test(timeout = 4000)
    public void testNormalizedStandardThrowsException() {
        Period period = new Period(1, 1, 0, 0); // 1 year, 1 month
        PeriodType periodTypeMissingMonths = new PeriodType("CustomType", 
                new DurationFieldType[] {DurationFieldType.YEARS_TYPE}, 
                new int[] {}); // Custom PeriodType missing months
        
        try {
            period.normalizedStandard(periodTypeMissingMonths);
            fail("Expected UnsupportedOperationException to be thrown.");
        } catch (UnsupportedOperationException e) {
            // Exception is expected
        }
    }

}