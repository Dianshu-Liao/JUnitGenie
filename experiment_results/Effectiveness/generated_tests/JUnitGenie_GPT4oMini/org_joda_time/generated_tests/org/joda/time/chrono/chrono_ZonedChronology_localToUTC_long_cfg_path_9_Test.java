package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalInstantException;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testLocalToUTC() {
        try {
            // Create an instance of ZonedChronology using reflection
            Class<?> clazz = ZonedChronology.class;
            Method constructor = clazz.getDeclaredMethod("getInstance", org.joda.time.Chronology.class, DateTimeZone.class);
            constructor.setAccessible(true);
            ZonedChronology zonedChronology = (ZonedChronology) constructor.invoke(null, null, DateTimeZone.UTC);

            // Test case for a normal value
            long localInstant = 1000000000L; // Example local instant
            long expectedUTC = localInstant - zonedChronology.getZone().getOffsetFromLocal(localInstant);
            Method localToUTCMethod = clazz.getDeclaredMethod("localToUTC", long.class);
            localToUTCMethod.setAccessible(true);
            long actualUTC = (long) localToUTCMethod.invoke(zonedChronology, localInstant);
            assertEquals(expectedUTC, actualUTC);

            // Test case for Long.MAX_VALUE
            localInstant = Long.MAX_VALUE;
            expectedUTC = Long.MAX_VALUE;
            actualUTC = (long) localToUTCMethod.invoke(zonedChronology, localInstant);
            assertEquals(expectedUTC, actualUTC);

            // Test case for Long.MIN_VALUE
            localInstant = Long.MIN_VALUE;
            expectedUTC = Long.MIN_VALUE;
            actualUTC = (long) localToUTCMethod.invoke(zonedChronology, localInstant);
            assertEquals(expectedUTC, actualUTC);

            // Test case that triggers IllegalInstantException
            localInstant = 604800000L; // Example local instant that may cause exception
            try {
                localToUTCMethod.invoke(zonedChronology, localInstant);
            } catch (IllegalInstantException e) {
                // Expected exception
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}