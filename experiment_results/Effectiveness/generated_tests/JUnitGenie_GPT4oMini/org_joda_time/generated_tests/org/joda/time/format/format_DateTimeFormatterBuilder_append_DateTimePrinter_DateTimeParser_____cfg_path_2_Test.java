package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimePrinterInternalPrinter;
import org.joda.time.format.DateTimeParserInternalParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_append_DateTimePrinter_DateTimeParser_____cfg_path_2_Test {

    private static class TestDateTimePrinter implements DateTimePrinter {
        @Override
        public void printTo(StringBuffer buf, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            buf.append(instant);
        }

        @Override
        public void printTo(java.io.Writer out, org.joda.time.ReadablePartial partial, java.util.Locale locale) {
            // Implementation for test
        }

        @Override
        public void printTo(StringBuffer buf, org.joda.time.ReadablePartial partial, java.util.Locale locale) {
            // Implementation for test
        }

        @Override
        public int estimatePrintedLength() {
            return 10; // Example length
        }

        @Override
        public void printTo(java.io.Writer out, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for test
        }
    }

    private static class TestDateTimeParser implements DateTimeParser {
        @Override
        public int parseInto(DateTimeParserBucket bucket, String text, int position) {
            // Implementation for test
            return position; // Example return
        }

        @Override
        public int estimateParsedLength() {
            return 10; // Example length
        }
    }

    @Test(timeout = 4000)
    public void testAppend_withValidPrinterAndParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = new DateTimeParser[]{new TestDateTimeParser()};

        try {
            DateTimeFormatterBuilder result = builder.append(
                printer, // Use the printer directly
                parsers[0] // Pass a single DateTimeParser
            );
            assertNotNull(result);
        } catch (Exception e) {
            fail("Append method threw an exception: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppend_withNullParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        
        builder.append(printer, (DateTimeParser[]) null); // Specify type to avoid ambiguity
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppend_withNullFirstParser() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = new DateTimeParser[]{null};

        builder.append(printer, parsers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppend_withIncompleteParsersArray() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestDateTimePrinter();
        DateTimeParser[] parsers = new DateTimeParser[]{new TestDateTimeParser(), null};

        builder.append(printer, parsers);
    }

}