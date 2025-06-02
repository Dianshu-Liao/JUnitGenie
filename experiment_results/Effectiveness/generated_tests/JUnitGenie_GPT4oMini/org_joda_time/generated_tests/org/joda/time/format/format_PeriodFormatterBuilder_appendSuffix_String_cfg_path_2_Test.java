package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;

public class format_PeriodFormatterBuilder_appendSuffix_String_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffix_NullInput_ThrowsIllegalArgumentException() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        try {
            builder.appendSuffix(null);
        } catch (IllegalArgumentException e) {
            // Exception is expected, test passes
            throw e; // rethrow to satisfy the expected exception
        }
    }

}