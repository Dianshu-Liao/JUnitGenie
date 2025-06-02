package org.joda.time.format;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import static org.junit.Assert.assertNotNull;

public class format_DateTimeFormat_createFormatterForPattern_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCreateFormatterForPattern_nonEmptyPattern() {
        // Arrange
        String pattern = "yyyy-MM-dd";

        try {
            // Act
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            DateTimeFormatter formatter = (DateTimeFormatter) method.invoke(null, pattern);
            
            // Assert
            assertNotNull(formatter);
        } catch (Exception e) {
            // Handle the exception for "throws Exception"
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFormatterForPattern_emptyPattern() {
        // Arrange
        String pattern = "";

        try {
            // Act
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            method.invoke(null, pattern);
        } catch (Exception e) {
            // Handle the exception for "throws Exception"
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFormatterForPattern_nullPattern() {
        // Arrange
        String pattern = null;

        try {
            // Act
            Method method = DateTimeFormat.class.getDeclaredMethod("createFormatterForPattern", String.class);
            method.setAccessible(true);
            method.invoke(null, pattern);
        } catch (Exception e) {
            // Handle the exception for "throws Exception"
            e.printStackTrace();
        }
    }

}