package org.joda.time;
import org.joda.time.Hours;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.ISOPeriodFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Hours_parseHours_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testParseHours_ValidInput() {
        String periodStr = "PT5H"; // Valid ISO-8601 period format for 5 hours
        try {
            Hours result = Hours.parseHours(periodStr);
            assertEquals(Hours.hours(5), result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParseHours_NullInput() {
        String periodStr = null; // Testing null input
        try {
            Hours result = Hours.parseHours(periodStr);
            assertEquals(Hours.ZERO, result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParseHours_ZeroHours() {
        String periodStr = "PT0H"; // Valid ISO-8601 period format for 0 hours
        try {
            Hours result = Hours.parseHours(periodStr);
            assertEquals(Hours.hours(0), result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParseHours_NegativeHours() {
        String periodStr = "PT-3H"; // Valid ISO-8601 period format for -3 hours
        try {
            Hours result = Hours.parseHours(periodStr);
            assertEquals(Hours.hours(-3), result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}