package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class format_DateTimeFormatterBuilder_append_DateTimeFormatter_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppend_NullFormatter_ThrowsIllegalArgumentException() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        try {
            builder.append((DateTimeFormatter) null); // Explicitly casting to DateTimeFormatter
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("No formatter supplied", e.getMessage());
        }
    }


}