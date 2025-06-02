package org.joda.time.format;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class format_DateTimeFormat_createFormatterForPattern_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_ValidPattern() {
        try {
            // Accessing the private static method using reflection
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);

            // Test with a valid pattern
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter formatter = (DateTimeFormatter) method.invoke(null, pattern);
            assertNotNull(formatter);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_NullPattern() {
        try {
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);

            // Test with null pattern
            method.invoke(null, (String) null);
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
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);

            // Test with empty pattern
            method.invoke(null, "");
            fail("Expected IllegalArgumentException for empty pattern");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}