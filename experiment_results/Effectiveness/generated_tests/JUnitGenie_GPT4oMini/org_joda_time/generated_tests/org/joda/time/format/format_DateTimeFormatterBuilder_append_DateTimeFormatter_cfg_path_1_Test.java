package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.ReadablePartial;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Writer;
import java.util.Locale;

public class format_DateTimeFormatterBuilder_append_DateTimeFormatter_cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testAppend_NullFormatter() {
        // Arrange
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();

        // Act & Assert
        try {
            builder.append((DateTimePrinter) null); // Specify the type to avoid ambiguity
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No formatter supplied", e.getMessage());
        }
    }


}
