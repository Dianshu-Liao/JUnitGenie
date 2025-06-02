package org.joda.time.format;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class format_DateTimeFormatter_parseMutableDateTime_String_cfg_path_9_Test {

    private final DateTimeZone testZone = DateTimeZone.forID("UTC");
    private final Integer testPivotYear = 2021;
    private final Locale testLocale = Locale.ENGLISH; 
    private final int testDefaultYear = 2021;
    private final boolean testOffsetParsed = true;

    private DateTimeFormatter createFormatter() {
        // Using the public constructor instead of reflection
        return DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .withLocale(testLocale)
                .withPivotYear(testPivotYear)
                .withZone(testZone);
    }

    @Test(timeout = 4000)
    public void testParseMutableDateTime_ValidInput() {
        DateTimeFormatter formatter = createFormatter();
        String validDateTime = "2021-10-01T10:00:00Z";
        
        try {
            MutableDateTime result = formatter.parseMutableDateTime(validDateTime);
            assertNotNull(result);
            assertEquals("2021-10-01T10:00:00.000Z", result.toString());
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid input: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseMutableDateTime_InvalidInput() {
        DateTimeFormatter formatter = createFormatter();
        String invalidDateTime = "invalid-date-time";

        try {
            formatter.parseMutableDateTime(invalidDateTime);
            fail("Expected IllegalArgumentException for invalid input");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

}