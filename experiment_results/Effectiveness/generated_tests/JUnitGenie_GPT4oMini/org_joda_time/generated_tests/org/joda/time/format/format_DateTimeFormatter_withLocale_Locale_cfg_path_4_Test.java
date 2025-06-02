package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimeParser;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertSame;

public class format_DateTimeFormatter_withLocale_Locale_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithLocale_SameLocale_ReturnsSameInstance() {
        // Arrange
        Locale locale = Locale.ENGLISH;
        DateTimePrinter printer = null; // Assuming null for printer
        DateTimeParser parser = null; // Assuming null for parser
        DateTimeFormatter formatter = new DateTimeFormatter(printer, parser); // Specify the correct constructor

        // Set the internal locale to be the same as the input locale
        // This is a workaround since we cannot access private fields directly
        try {
            java.lang.reflect.Field field = DateTimeFormatter.class.getDeclaredField("iLocale");
            field.setAccessible(true);
            field.set(formatter, locale);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        DateTimeFormatter result = formatter.withLocale(locale);

        // Assert
        assertSame(formatter, result);
    }


}