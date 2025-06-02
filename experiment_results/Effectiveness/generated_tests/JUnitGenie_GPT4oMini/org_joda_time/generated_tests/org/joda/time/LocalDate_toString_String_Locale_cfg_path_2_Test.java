package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class LocalDate_toString_String_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringWithValidPatternAndLocale() {
        LocalDate localDate = new LocalDate(2023, 10, 1); // Valid instance of LocalDate
        String pattern = "yyyy-MM-dd"; // Valid pattern
        Locale locale = Locale.US; // Valid locale

        String result = localDate.toString(pattern, locale);
        String expected = DateTimeFormat.forPattern(pattern).withLocale(locale).print(localDate);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToStringWithNullPattern() {
        LocalDate localDate = new LocalDate(2023, 10, 1); // Valid instance of LocalDate
        Locale locale = Locale.US; // Valid locale

        String result = localDate.toString(null, locale);
        String expected = localDate.toString(); // Calls the no-arg toString method
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToStringWithInvalidPattern() {
        LocalDate localDate = new LocalDate(2023, 10, 1); // Valid instance of LocalDate
        String pattern = "invalid-pattern"; // Invalid pattern
        Locale locale = Locale.US; // Valid locale

        try {
            localDate.toString(pattern, locale);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}