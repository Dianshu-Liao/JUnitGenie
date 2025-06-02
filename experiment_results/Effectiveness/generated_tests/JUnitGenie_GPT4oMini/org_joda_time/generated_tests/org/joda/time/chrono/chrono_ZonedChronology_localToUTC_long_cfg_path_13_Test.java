package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.joda.time.Chronology;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testLocalToUTC_LongMaxValue() {
        try {
            // Create an instance of ZonedChronology using reflection
            Class<?> clazz = ZonedChronology.class;
            Method constructor = clazz.getDeclaredMethod("getInstance", Chronology.class, DateTimeZone.class);
            constructor.setAccessible(true);
            ZonedChronology zonedChronology = (ZonedChronology) constructor.invoke(null, null, DateTimeZone.UTC); // Use UTC as a default timezone

            // Access the private method localToUTC
            Method localToUTCMethod = clazz.getDeclaredMethod("localToUTC", long.class);
            localToUTCMethod.setAccessible(true);

            // Test with Long.MAX_VALUE
            long result = (long) localToUTCMethod.invoke(zonedChronology, Long.MAX_VALUE);
            assertEquals(Long.MAX_VALUE, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}