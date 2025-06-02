package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.ReadablePartial;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_append_DateTimePrinter_DateTimeParser_____cfg_path_11_Test {

    private class TestPrinter implements DateTimePrinter {
        @Override
        public void printTo(StringBuffer buf, long instant, Chronology chrono, int pivotYear, DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public void printTo(java.io.Writer out, ReadablePartial partial, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public void printTo(StringBuffer buf, ReadablePartial partial, java.util.Locale locale) {
            // Implementation for testing
        }

        @Override
        public int estimatePrintedLength() {
            return 0; // Implementation for testing
        }

        @Override
        public void printTo(java.io.Writer out, long instant, Chronology chrono, int pivotYear, DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithValidPrinterAndParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] {
            new DateTimeParser() {
                @Override
                public int parseInto(DateTimeParserBucket bucket, String text, int position) {
                    return position; // Dummy implementation for testing
                }

                @Override
                public int estimateParsedLength() {
                    return 0; // Dummy implementation for testing
                }
            }
        };

        try {
            builder.append(printer, parsers);
        } catch (Exception e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullPrinter() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeParser[] parsers = new DateTimeParser[] {
            new DateTimeParser() {
                @Override
                public int parseInto(DateTimeParserBucket bucket, String text, int position) {
                    return position; // Dummy implementation for testing
                }

                @Override
                public int estimateParsedLength() {
                    return 0; // Dummy implementation for testing
                }
            }
        };

        try {
            builder.append(null, parsers);
            fail("Expected IllegalArgumentException for null printer");
        } catch (IllegalArgumentException e) {
            assertEquals("Printer must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullParsers() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestPrinter();

        try {
            builder.append(printer, (DateTimeParser[]) null);
            fail("Expected IllegalArgumentException for null parsers");
        } catch (IllegalArgumentException e) {
            assertEquals("No parsers supplied", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithIncompleteParserArray() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimePrinter printer = new TestPrinter();
        DateTimeParser[] parsers = new DateTimeParser[] {
            null // This will cause the incomplete parser array exception
        };

        try {
            builder.append(printer, parsers);
            fail("Expected IllegalArgumentException for incomplete parser array");
        } catch (IllegalArgumentException e) {
            assertEquals("Incomplete parser array", e.getMessage());
        }
    }


}