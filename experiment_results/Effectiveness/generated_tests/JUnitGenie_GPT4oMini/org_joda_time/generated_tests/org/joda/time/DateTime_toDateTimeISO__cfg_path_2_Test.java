package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DateTime_toDateTimeISO__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToDateTimeISO_withISOChronology() {
        DateTime dateTime = new DateTime(ISOChronology.getInstance());
        DateTime result = dateTime.toDateTimeISO();
        assertEquals(dateTime, result);
    }

    @Test(timeout = 4000)
    public void testToDateTimeISO_withDifferentChronology() {
        DateTimeZone timeZone = DateTimeZone.forID("UTC");
        DateTime dateTime = new DateTime(timeZone);
        DateTime result = dateTime.toDateTimeISO();
        
        // Since the chronology is not ISOChronology, it should call the super method
        // We cannot assert the exact value without knowing the super implementation,
        // but we can check that the result is not equal to the original dateTime.
        assertNotSame(dateTime, result); // Using assertNotSame instead of assertNotEquals
    }


}