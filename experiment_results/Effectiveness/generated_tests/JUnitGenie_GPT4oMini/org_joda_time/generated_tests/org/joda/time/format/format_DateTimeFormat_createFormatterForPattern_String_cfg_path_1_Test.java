package org.joda.time.format;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.fail;

public class format_DateTimeFormat_createFormatterForPattern_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_NullPattern() {
        try {
            // Accessing the private static method using reflection
            DateTimeFormatter formatter = (DateTimeFormatter) DateTimeFormat.class
                    .getDeclaredMethod("createFormatterForPattern", String.class)
                    .invoke(null, (String) null);
            fail("Expected IllegalArgumentException for null pattern");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_EmptyPattern() {
        try {
            // Accessing the private static method using reflection
            DateTimeFormatter formatter = (DateTimeFormatter) DateTimeFormat.class
                    .getDeclaredMethod("createFormatterForPattern", String.class)
                    .invoke(null, "");
            fail("Expected IllegalArgumentException for empty pattern");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}