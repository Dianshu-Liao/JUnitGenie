package org.joda.time.format;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatter_parseMutableDateTime_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testParseMutableDateTimeValidInput() {
        // Using DateTimeFormat to create a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss"); // Use appropriate pattern
        
        String dateTimeText = "2023-10-15T10:00:00"; // Valid datetime string
        
        // Execution
        MutableDateTime result = formatter.parseMutableDateTime(dateTimeText);
        
        // Verify
        assertNotNull(result);
        // Additional assertions can be made to check if the result corresponds to expected values.
    }

    @Test(timeout = 4000)
    public void testParseMutableDateTimeInvalidInput() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss"); // Use appropriate pattern
        
        String invalidDateTimeText = "invalid-date"; // Invalid datetime string

        // Execution and verification of exception
        try {
            formatter.parseMutableDateTime(invalidDateTimeText);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Verify that we caught the expected exception
            assertTrue(e.getMessage().contains("Error parsing"));
        }
    }
    
    // Additional tests can be added here for edge cases as required.


}