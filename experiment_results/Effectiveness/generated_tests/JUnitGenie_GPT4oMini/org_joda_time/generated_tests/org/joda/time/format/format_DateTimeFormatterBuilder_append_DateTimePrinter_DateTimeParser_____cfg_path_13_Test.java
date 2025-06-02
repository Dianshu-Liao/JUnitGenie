package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserInternalParser;
import org.joda.time.format.DateTimePrinterInternalPrinter;
import org.joda.time.format.InternalParser;
import org.joda.time.format.DateTimeFormatterBuilder.MatchingParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_append_DateTimePrinter_DateTimeParser_____cfg_path_13_Test {

    private static class TestPrinter implements DateTimePrinter {
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
            return 0; // Example length
        }

        @Override
        public void printTo(java.io.Writer out, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }
    }

    private static class TestParser implements DateTimeParser {
        @Override
        public int parseInto(DateTimeParserBucket bucket, String text, int position) {
            // Implementation for testing
            return position; // Example implementation
        }

        @Override
        public int estimateParsedLength() {
            return 0; // Example length
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithValidPrinterAndParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] {
            new TestParser() // Use the TestParser implementation
        };

        try {
            builder.append(printer, parsers);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullPrinter() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeParser[] parsers = new DateTimeParser[] {
            new TestParser() // Use the TestParser implementation
        };

        try {
            builder.append(null, parsers);
            fail("Expected IllegalArgumentException for null printer");
        } catch (IllegalArgumentException e) {
            assertEquals("No printer supplied", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestPrinter();

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
        DateTimePrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] { null };

        try {
            builder.append(printer, parsers);
            fail("Expected IllegalArgumentException for null parser");
        } catch (IllegalArgumentException e) {
            assertEquals("No parser supplied", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithIncompleteParserArray() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] {
            new TestParser(), // Use the TestParser implementation
            null // Incomplete parser
        };

        try {
            builder.append(printer, parsers);
            fail("Expected IllegalArgumentException for incomplete parser array");
        } catch (IllegalArgumentException e) {
            assertEquals("Incomplete parser array", e.getMessage());
        }
    }

}