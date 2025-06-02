package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_append_DateTimePrinter_DateTimeParser_____cfg_path_1_Test {

    private class TestDateTimePrinter implements DateTimePrinter {
        @Override
        public void printTo(StringBuffer buf, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public void printTo(java.io.Writer out, org.joda.time.ReadablePartial partial, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public void printTo(StringBuffer buf, org.joda.time.ReadablePartial partial, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public int estimatePrintedLength() {
            return 0; // Example implementation
        }

        @Override
        public void printTo(java.io.Writer out, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = null;

        try {
            builder.append(printer, parsers);
            fail("Expected IllegalArgumentException for null parsers");
        } catch (IllegalArgumentException e) {
            assertEquals("No parsers supplied", e.getMessage());
        }
    }

}