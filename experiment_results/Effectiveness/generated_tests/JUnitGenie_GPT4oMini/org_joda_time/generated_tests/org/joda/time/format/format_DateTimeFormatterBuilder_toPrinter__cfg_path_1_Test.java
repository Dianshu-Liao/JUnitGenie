package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.InternalPrinter;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_toPrinter__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToPrinterThrowsUnsupportedOperationException() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        
        // Mocking the behavior of getFormatter() to return an object that is not an InternalPrinter
        Object mockFormatter = new Object() {
            // This object is not an instance of InternalPrinter
        };

        // Using reflection to set the private field or method to return the mockFormatter
        try {
            // Assuming we have a way to set the formatter in the builder
            // This is a placeholder for the actual implementation
            // builder.setFormatter(mockFormatter); // Hypothetical method to set the formatter
            
            // Call the method under test
            builder.toPrinter();
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Printing is not supported", e.getMessage());
        } catch (Exception e) {
            fail("Expected UnsupportedOperationException, but got: " + e.getClass().getSimpleName());
        }
    }

}