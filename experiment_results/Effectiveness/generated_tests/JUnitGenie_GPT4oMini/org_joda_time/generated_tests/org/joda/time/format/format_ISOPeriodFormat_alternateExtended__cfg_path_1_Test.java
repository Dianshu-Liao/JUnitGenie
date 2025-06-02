package org.joda.time.format;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class format_ISOPeriodFormat_alternateExtended__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAlternateExtended() {
        // Call the method to be tested
        PeriodFormatter formatter = ISOPeriodFormat.alternateExtended();
        
        // Assert that the returned formatter is not null
        assertNotNull("The PeriodFormatter should not be null", formatter);
    }

}