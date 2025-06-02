package org.joda.time.format;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class format_ISOPeriodFormat_alternate__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAlternateMethodReturnsNonNullFormatter() {
        // Call the static method to get the PeriodFormatter
        PeriodFormatter formatter = ISOPeriodFormat.alternate();
        
        // Assert that the returned formatter is not null
        assertNotNull("The returned PeriodFormatter should not be null", formatter);
    }

}