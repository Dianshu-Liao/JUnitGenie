package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.Chronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LocalDate_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        LocalDate date = new LocalDate(2023, 10, 1);
        assertTrue(date.equals(date));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        LocalDate date = new LocalDate(2023, 10, 1);
        String notALocalDate = "Not a LocalDate";
        assertFalse(date.equals(notALocalDate));
    }

    @Test(timeout = 4000)
    public void testEquals_SameChronologyAndMillis() {
        Chronology chronology = LocalDate.now().getChronology();
        LocalDate date1 = new LocalDate(2023, 10, 1, chronology);
        LocalDate date2 = new LocalDate(2023, 10, 1, chronology);
        assertTrue(date1.equals(date2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentMillis() {
        Chronology chronology = LocalDate.now().getChronology();
        LocalDate date1 = new LocalDate(2023, 10, 1, chronology);
        LocalDate date2 = new LocalDate(2023, 10, 2, chronology);
        assertFalse(date1.equals(date2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentChronology() {
        LocalDate date1 = new LocalDate(2023, 10, 1);
        LocalDate date2 = new LocalDate(2023, 10, 1, ISOChronology.getInstance()); // Use ISOChronology.getInstance()
        assertFalse(date1.equals(date2));
    }


}