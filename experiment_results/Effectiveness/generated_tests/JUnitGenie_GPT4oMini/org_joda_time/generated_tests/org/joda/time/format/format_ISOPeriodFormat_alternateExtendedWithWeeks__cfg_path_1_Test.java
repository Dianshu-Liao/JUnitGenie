package org.joda.time.format;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class format_ISOPeriodFormat_alternateExtendedWithWeeks__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAlternateExtendedWithWeeks() {
        // Ensure that the static method returns a non-null PeriodFormatter
        PeriodFormatter formatter = ISOPeriodFormat.alternateExtendedWithWeeks();
        assertNotNull("The returned PeriodFormatter should not be null", formatter);
    }

}