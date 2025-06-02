package org.joda.time.format;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormat_createFormatterForPattern_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_NullPattern() {
        try {
            // Accessing the private static method using reflection
            java.lang.reflect.Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            method.invoke(null, (String) null);
            fail("Expected IllegalArgumentException for null pattern");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid pattern specification: Pattern is null or empty", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_EmptyPattern() {
        try {
            // Accessing the private static method using reflection
            java.lang.reflect.Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            method.invoke(null, "");
            fail("Expected IllegalArgumentException for empty pattern");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid pattern specification: Pattern is null or empty", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}