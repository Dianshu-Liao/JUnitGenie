package org.joda.time;
import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LocalDate_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        LocalDate date = new LocalDate();
        assertTrue(date.equals(date));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        LocalDate date = new LocalDate();
        String notALocalDate = "Not a LocalDate";
        assertFalse(date.equals(notALocalDate));
    }

    @Test(timeout = 4000)
    public void testEquals_SameChronologyAndMillis() {
        LocalDate date1 = new LocalDate(2023, 10, 1);
        LocalDate date2 = new LocalDate(2023, 10, 1);
        assertTrue(date1.equals(date2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentChronology() {
        LocalDate date1 = new LocalDate(2023, 10, 1);
        LocalDate date2 = new LocalDate(2023, 10, 1, null); // Assuming null is a different chronology
        assertFalse(date1.equals(date2));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        LocalDate date = new LocalDate();
        assertFalse(date.equals(null));
    }

}