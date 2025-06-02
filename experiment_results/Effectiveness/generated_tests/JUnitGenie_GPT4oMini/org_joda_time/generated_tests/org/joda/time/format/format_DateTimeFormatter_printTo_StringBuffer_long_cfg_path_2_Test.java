package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatter_printTo_StringBuffer_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrintTo() {
        StringBuffer buf = new StringBuffer();
        long instant = System.currentTimeMillis(); // valid long value

        // Use DateTimeFormatterBuilder to create a DateTimeFormatter instance
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("Timestamp: ").toFormatter();

        try {
            formatter.printTo(buf, instant);
        } catch (Exception ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }

        // Additional assertions can be added here to verify the content of buf if needed
    }


}