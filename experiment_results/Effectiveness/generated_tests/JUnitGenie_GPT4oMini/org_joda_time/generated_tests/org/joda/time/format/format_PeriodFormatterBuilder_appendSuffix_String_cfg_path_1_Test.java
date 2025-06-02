package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_PeriodFormatterBuilder_appendSuffix_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendSuffix_withValidString() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        String suffix = "suffix";
        
        try {
            PeriodFormatterBuilder result = builder.appendSuffix(suffix);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid string input.");
        }
    }

    @Test(timeout = 4000)
    public void testAppendSuffix_withNullString() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        
        try {
            builder.appendSuffix(null);
            fail("Expected IllegalArgumentException for null input.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got a different exception: " + e);
        }
    }

}