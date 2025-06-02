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

public class format_DateTimeFormatterBuilder_append_DateTimePrinter_DateTimeParser_____cfg_path_14_Test {

    private class TestPrinter implements DateTimePrinter {
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
            return 0; // Return an estimated length
        }

        @Override
        public void printTo(java.io.Writer out, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }
    }

    private class TestParser implements DateTimeParser {
        @Override
        public int parseInto(DateTimeParserBucket bucket, String text, int position) {
            // Implementation for testing
            return position; // Return the position for testing
        }

        @Override
        public int estimateParsedLength() {
            return 0; // Return an estimated length for parsing
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithValidPrinterAndParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        TestPrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] { new TestParser() };

        try {
            builder.append(printer, parsers);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendWithNullPrinter() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeParser[] parsers = new DateTimeParser[] { new TestParser() };

        builder.append(null, parsers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendWithNullParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        TestPrinter printer = new TestPrinter();

        builder.append(printer, (DateTimeParser[]) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendWithEmptyParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        TestPrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[0];

        builder.append(printer, parsers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendWithNullParserInArray() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        TestPrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] { null };

        builder.append(printer, parsers);
    }

}