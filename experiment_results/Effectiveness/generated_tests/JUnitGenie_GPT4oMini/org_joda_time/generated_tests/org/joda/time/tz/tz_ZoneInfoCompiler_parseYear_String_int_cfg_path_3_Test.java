package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_ZoneInfoCompiler_parseYear_String_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testParseYearWithMaxYearLookup() {
        String testInput = "maximum"; // Should trigger the MAX_YEAR_LOOKUP
        int defaultYear = 2020;
        try {
            int result = ZoneInfoCompiler.parseYear(testInput, defaultYear);
            assertEquals(Integer.MAX_VALUE, result);
        } catch (Exception e) {
            // Handle any exceptions that might occur during parsing
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testParseYearWithMinYearLookup() {
        String testInput = "minimum"; // Should trigger the MIN_YEAR_LOOKUP
        int defaultYear = 2020;
        try {
            int result = ZoneInfoCompiler.parseYear(testInput, defaultYear);
            assertEquals(Integer.MIN_VALUE, result);
        } catch (Exception e) {
            // Handle any exceptions that might occur during parsing
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testParseYearWithDefault() {
        String testInput = "only"; // Should trigger the ONLY_YEAR_LOOKUP
        int defaultYear = 2021; 
        try {
            int result = ZoneInfoCompiler.parseYear(testInput, defaultYear);
            assertEquals(defaultYear, result);
        } catch (Exception e) {
            // Handle any exceptions that might occur during parsing
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testParseYearWithNormalYear() {
        String testInput = "2023"; // A normal year input
        int defaultYear = 2020;
        try {
            int result = ZoneInfoCompiler.parseYear(testInput, defaultYear);
            assertEquals(2023, result);
        } catch (Exception e) {
            // Handle any exceptions that might occur during parsing
            e.printStackTrace();
        }
    }

}