package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class format_DateTimeFormat_createFormatterForPattern_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_ValidPattern() {
        String pattern = "yyyy-MM-dd";

        try {
            // Access the private static method using reflection
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);

            DateTimeFormatter formatter = (DateTimeFormatter) method.invoke(null, pattern);
            assertNotNull(formatter);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFormatterForPattern_NullPattern() {
        String pattern = null;

        try {
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            method.invoke(null, pattern);
        } catch (Exception e) {
            // Do nothing, the expected exception has been thrown.
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFormatterForPattern_EmptyPattern() {
        String pattern = "";

        try {
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            method.invoke(null, pattern);
        } catch (Exception e) {
            // Do nothing, the expected exception has been thrown.
        }
    }

}