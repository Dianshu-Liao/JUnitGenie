package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LocalDate_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        LocalDate date = new LocalDate(2023, 10, 1);
        assertTrue(date.equals(date)); // Testing the same instance
    }

    @Test(timeout = 4000)
    public void testEquals_EqualDates() {
        LocalDate date1 = new LocalDate(2023, 10, 1);
        LocalDate date2 = new LocalDate(2023, 10, 1);
        assertTrue(date1.equals(date2)); // Testing equal dates
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentChronology() {
        LocalDate date1 = new LocalDate(2023, 10, 1, ISOChronology.getInstance(DateTimeZone.UTC)); // Using ISOChronology
        LocalDate date2 = new LocalDate(2023, 10, 1, ISOChronology.getInstance(DateTimeZone.forID("Europe/London"))); // Using ISOChronology
        assertFalse(date1.equals(date2)); // Testing different chronology
    }

    @Test(timeout = 4000)
    public void testEquals_NonLocalDateObject() {
        LocalDate date = new LocalDate(2023, 10, 1);
        Object nonLocalDate = new Object();
        assertFalse(date.equals(nonLocalDate)); // Testing with a non-LocalDate object
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        LocalDate date = new LocalDate(2023, 10, 1);
        assertFalse(date.equals(null)); // Testing with null
    }


}