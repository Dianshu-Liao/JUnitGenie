package org.joda.time.format;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.ReadablePartial;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;

public class format_DateTimeFormatterBuilder_toPrinter__cfg_path_2_Test {


    @Test(timeout = 4000)
    public void testToPrinter_UnsupportedOperationException() {
        // Arrange
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        // Assuming the default behavior of getFormatter() returns null or a non-printer object

        // Act
        try {
            builder.toPrinter();
            fail("Expected toPrinter() to throw UnsupportedOperationException, but it did not.");
        } catch (UnsupportedOperationException e) {
            // Assert
            assertEquals("Printing is not supported", e.getMessage());
        }
    }

}
