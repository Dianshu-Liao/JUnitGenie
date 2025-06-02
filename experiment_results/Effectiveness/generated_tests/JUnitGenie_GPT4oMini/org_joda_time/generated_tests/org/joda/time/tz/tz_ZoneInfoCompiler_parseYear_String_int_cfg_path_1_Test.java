package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_ZoneInfoCompiler_parseYear_String_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testParseYearWithMinimumYearLookup() {
        String input = "minimum";
        int defaultYear = 2020;
        int expected = Integer.MIN_VALUE;
        int actual = ZoneInfoCompiler.parseYear(input, defaultYear);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testParseYearWithMaximumYearLookup() {
        String input = "maximum";
        int defaultYear = 2020;
        int expected = Integer.MAX_VALUE;
        int actual = ZoneInfoCompiler.parseYear(input, defaultYear);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testParseYearWithOnlyYearLookup() {
        String input = "only";
        int defaultYear = 2020;
        int expected = defaultYear;
        int actual = ZoneInfoCompiler.parseYear(input, defaultYear);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testParseYearWithValidYearString() {
        String input = "2021";
        int defaultYear = 2020;
        int expected = 2021;
        int actual = ZoneInfoCompiler.parseYear(input, defaultYear);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testParseYearWithInvalidYearString() {
        String input = "invalid";
        int defaultYear = 2020;
        try {
            ZoneInfoCompiler.parseYear(input, defaultYear);
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

}