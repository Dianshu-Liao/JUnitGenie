package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.DateTimeUtils;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_normalizedStandard_PeriodType_cfg_path_2_Test {



    @Test(timeout = 4000)
    public void testNormalizedStandardThrowsException() {
        // Arrange
        PeriodType type = PeriodType.forFields(new DurationFieldType[]{DurationFieldType.years(), DurationFieldType.months()}); // Include both years and months
        Period period = new Period(1, 5, 0, 0, 0, 0, 0, 0); // 1 year and 5 months

        // Act & Assert
        try {
            period.normalizedStandard(type);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + period.toString(), e.getMessage());
        }
    }


}
