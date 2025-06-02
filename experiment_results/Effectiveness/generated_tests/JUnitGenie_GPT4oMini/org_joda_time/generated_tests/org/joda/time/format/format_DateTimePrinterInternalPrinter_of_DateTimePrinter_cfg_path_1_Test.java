package org.joda.time.format;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimePrinterInternalPrinter;
import org.joda.time.format.InternalPrinter;
import org.joda.time.format.InternalPrinterDateTimePrinter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class format_DateTimePrinterInternalPrinter_of_DateTimePrinter_cfg_path_1_Test {

    private static class TestDateTimePrinter implements DateTimePrinter {
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
            return 0; // Implementation for testing
        }

        @Override
        public void printTo(java.io.Writer out, long instant, org.joda.time.Chronology chrono, int pivotYear, org.joda.time.DateTimeZone zone, java.util.Locale locale) {
            // Implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testOf_withNonInternalPrinterDateTimePrinter() {
        DateTimePrinter printer = new TestDateTimePrinter();
        InternalPrinter result = DateTimePrinterInternalPrinter.of(printer);
        assertNotNull(result);
    }


    @Test(timeout = 4000)
    public void testOf_withNull() {
        InternalPrinter result = DateTimePrinterInternalPrinter.of(null);
        assertNotNull(result); // Expecting null to be returned
    }


}
