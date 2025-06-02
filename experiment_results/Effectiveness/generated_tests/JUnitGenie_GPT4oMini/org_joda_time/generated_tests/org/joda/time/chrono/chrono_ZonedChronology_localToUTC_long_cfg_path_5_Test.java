package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testLocalToUTC() {
        try {
            // Create an instance of ZonedChronology using reflection
            Class<?> clazz = ZonedChronology.class;
            Method constructor = clazz.getDeclaredMethod("getInstance", org.joda.time.Chronology.class, DateTimeZone.class);
            constructor.setAccessible(true);
            ZonedChronology zonedChronology = (ZonedChronology) constructor.invoke(null, null, DateTimeZone.UTC);

            // Access the private method localToUTC using reflection
            Method localToUTCMethod = clazz.getDeclaredMethod("localToUTC", long.class);
            localToUTCMethod.setAccessible(true);

            // Test case 1: Normal case
            long localInstant1 = 1622548800000L; // Example local time
            long expectedUTC1 = localInstant1 - DateTimeZone.UTC.getOffsetFromLocal(localInstant1);
            long actualUTC1 = (long) localToUTCMethod.invoke(zonedChronology, localInstant1);
            assertEquals(expectedUTC1, actualUTC1);

            // Test case 2: Edge case with Long.MAX_VALUE
            long localInstant2 = Long.MAX_VALUE;
            long actualUTC2 = (long) localToUTCMethod.invoke(zonedChronology, localInstant2);
            assertEquals(Long.MAX_VALUE, actualUTC2);

            // Test case 3: Edge case with Long.MIN_VALUE
            long localInstant3 = Long.MIN_VALUE;
            long actualUTC3 = (long) localToUTCMethod.invoke(zonedChronology, localInstant3);
            assertEquals(Long.MIN_VALUE, actualUTC3);

            // Test case 4: Near zero positive
            long localInstant4 = 1L; // Just above NEAR_ZERO
            long expectedUTC4 = localInstant4 - DateTimeZone.UTC.getOffsetFromLocal(localInstant4);
            long actualUTC4 = (long) localToUTCMethod.invoke(zonedChronology, localInstant4);
            assertEquals(expectedUTC4, actualUTC4);

            // Test case 5: Near zero negative
            long localInstant5 = -1L; // Just below NEAR_ZERO
            long expectedUTC5 = localInstant5 - DateTimeZone.UTC.getOffsetFromLocal(localInstant5);
            long actualUTC5 = (long) localToUTCMethod.invoke(zonedChronology, localInstant5);
            assertEquals(expectedUTC5, actualUTC5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}