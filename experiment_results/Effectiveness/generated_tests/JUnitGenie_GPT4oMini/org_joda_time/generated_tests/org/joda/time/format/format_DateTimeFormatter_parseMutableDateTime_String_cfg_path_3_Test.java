package org.joda.time.format;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatter_parseMutableDateTime_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testParseMutableDateTime() {
        // Arrange
        String text = "2023-10-01T10:00:00"; // Example input
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss"); // Use a concrete formatter

        try {
            // Act
            MutableDateTime result = formatter.parseMutableDateTime(text);

            // Assert
            assertNotNull(result);
            // Additional assertions can be made here based on expected output
        } catch (IllegalArgumentException e) {
            // Handle the exception if thrown
            fail("Expected valid MutableDateTime but got an exception: " + e.getMessage());
        }
    }


}