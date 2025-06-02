package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_append_DateTimePrinter_DateTimeParser_____cfg_path_10_Test {

    private class TestDateTimePrinter implements DateTimePrinter {
        @Override
        public void printTo(StringBuffer buf, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public int estimatePrintedLength() {
            return 0; // Return an estimated length for testing
        }

        @Override
        public void printTo(java.io.Writer out, org.joda.time.ReadablePartial partial, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public void printTo(java.io.Writer out, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public void printTo(StringBuffer buf, org.joda.time.ReadablePartial partial, java.util.Locale locale) {
            // Implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithValidPrinterAndParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = new DateTimeParser[] {  };

        // This should not throw an exception
        try {
            builder.append(printer, parsers);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullPrinter() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeParser[] parsers = new DateTimeParser[] {  };

        // This should not throw an exception
        try {
            builder.append(null, parsers);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();

        // This should throw an IllegalArgumentException
        try {
            builder.append(printer, (DateTimeParser[]) null); // Explicitly cast to avoid ambiguity
            fail("Expected IllegalArgumentException for null parsers");
        } catch (IllegalArgumentException e) {
            assertEquals("No parsers supplied", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithSingleNullParser() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = new DateTimeParser[] { null };

        // This should throw an IllegalArgumentException
        try {
            builder.append(printer, parsers);
            fail("Expected IllegalArgumentException for single null parser");
        } catch (IllegalArgumentException e) {
            assertEquals("No parser supplied", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithIncompleteParserArray() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = new DateTimeParser[] { null, null }; // Fixed the array initialization

        // This should throw an IllegalArgumentException
        try {
            builder.append(printer, parsers);
            fail("Expected IllegalArgumentException for incomplete parser array");
        } catch (IllegalArgumentException e) {
            assertEquals("Incomplete parser array", e.getMessage());
        }
    }

}