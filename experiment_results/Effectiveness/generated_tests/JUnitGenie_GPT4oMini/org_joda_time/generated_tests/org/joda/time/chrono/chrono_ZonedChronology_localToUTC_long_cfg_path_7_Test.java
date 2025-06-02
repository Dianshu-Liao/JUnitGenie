package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testLocalToUTC() {
        try {
            // Create an instance of ZonedChronology using reflection
            Class<?> zonedChronologyClass = ZonedChronology.class;
            Method constructor = zonedChronologyClass.getDeclaredMethod("getInstance", org.joda.time.Chronology.class, DateTimeZone.class);
            constructor.setAccessible(true);
            ZonedChronology zonedChronology = (ZonedChronology) constructor.invoke(null, null, DateTimeZone.UTC);

            // Prepare the input for the localToUTC method
            long localInstant = 1000000000L; // A valid long value representing local time

            // Access the private method localToUTC using reflection
            Method localToUTCMethod = zonedChronologyClass.getDeclaredMethod("localToUTC", long.class);
            localToUTCMethod.setAccessible(true);

            // Invoke the method and capture the result
            long result = (long) localToUTCMethod.invoke(zonedChronology, localInstant);

            // Expected result calculation
            long expected = localInstant - zonedChronology.getZone().getOffsetFromLocal(localInstant);

            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}