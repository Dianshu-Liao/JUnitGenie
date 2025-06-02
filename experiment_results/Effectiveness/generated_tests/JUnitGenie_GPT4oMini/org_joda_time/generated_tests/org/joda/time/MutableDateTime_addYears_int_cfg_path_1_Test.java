package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableDateTime_addYears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddYears_NonZeroYears() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        int yearsToAdd = 5;

        dateTime.addYears(yearsToAdd);

        long expectedMillis = dateTime.getChronology().years().add(initialMillis, yearsToAdd);
        assertEquals(expectedMillis, dateTime.getMillis());
    }

    @Test(timeout = 4000)
    public void testAddYears_ZeroYears() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        int yearsToAdd = 0;

        dateTime.addYears(yearsToAdd);

        assertEquals(initialMillis, dateTime.getMillis());
    }

    @Test(timeout = 4000)
    public void testAddYears_NegativeYears() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        int yearsToAdd = -3;

        dateTime.addYears(yearsToAdd);

        long expectedMillis = dateTime.getChronology().years().add(initialMillis, yearsToAdd);
        assertEquals(expectedMillis, dateTime.getMillis());
    }

}