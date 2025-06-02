package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class format_DateTimeFormatter_withLocale_Locale_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithLocale_SameLocale() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("test").toFormatter(); // Using a builder to create a formatter
        Locale locale = Locale.ENGLISH;
        formatter = formatter.withLocale(locale);
        assertEquals(locale, formatter.getLocale());
    }

    @Test(timeout = 4000)
    public void testWithLocale_NullLocale() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("test").toFormatter(); // Using a builder to create a formatter
        formatter = formatter.withLocale(null);
        assertEquals(null, formatter.getLocale());
    }

    @Test(timeout = 4000)
    public void testWithLocale_DifferentLocale() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("test").toFormatter(); // Using a builder to create a formatter
        Locale locale = Locale.FRENCH;
        formatter = formatter.withLocale(locale);
        assertEquals(locale, formatter.getLocale());
    }

    @Test(timeout = 4000)
    public void testWithLocale_ExistingLocale() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("test").toFormatter(); // Using a builder to create a formatter
        Locale existingLocale = Locale.GERMAN;
        formatter = formatter.withLocale(existingLocale);
        formatter = formatter.withLocale(existingLocale); // Should return the same instance
        assertEquals(existingLocale, formatter.getLocale());
    }

}