package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_ZoneInfoCompiler_parseYear_String_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testParseYearWithMinYear() {
        String input = "minimum"; // This should return Integer.MIN_VALUE
        int defaultYear = 2020;
        try {
            int result = ZoneInfoCompiler.parseYear(input, defaultYear);
            assertEquals(Integer.MIN_VALUE, result);
        } catch (Exception e) {
            // Handle unexpected exception
        }
    }

    @Test(timeout = 4000)
    public void testParseYearWithMaxYear() {
        String input = "maximum"; // This should return Integer.MAX_VALUE
        int defaultYear = 2020;
        try {
            int result = ZoneInfoCompiler.parseYear(input, defaultYear);
            assertEquals(Integer.MAX_VALUE, result);
        } catch (Exception e) {
            // Handle unexpected exception
        }
    }

    @Test(timeout = 4000)
    public void testParseYearWithOnlyYear() {
        String input = "only"; // This should return the default year
        int defaultYear = 2020;
        try {
            int result = ZoneInfoCompiler.parseYear(input, defaultYear);
            assertEquals(defaultYear, result);
        } catch (Exception e) {
            // Handle unexpected exception
        }
    }

}