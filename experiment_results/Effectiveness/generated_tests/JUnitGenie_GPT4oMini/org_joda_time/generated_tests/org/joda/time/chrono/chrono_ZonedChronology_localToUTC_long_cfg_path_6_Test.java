package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalInstantException;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testLocalToUTC_throwsIllegalInstantException() {
        try {
            // Create an instance of ZonedChronology using reflection
            Class<?> clazz = ZonedChronology.class;
            Method getZoneMethod = clazz.getDeclaredMethod("getZone");
            getZoneMethod.setAccessible(true);
            DateTimeZone zone = (DateTimeZone) getZoneMethod.invoke(null); // Assuming a static context for simplicity

            // Create an instance of ZonedChronology
            Constructor<?> constructor = clazz.getDeclaredConstructor(org.joda.time.Chronology.class, DateTimeZone.class);
            constructor.setAccessible(true);
            ZonedChronology zonedChronology = (ZonedChronology) constructor.newInstance(null, zone);

            // Access the private method localToUTC using reflection
            Method localToUTCMethod = clazz.getDeclaredMethod("localToUTC", long.class);
            localToUTCMethod.setAccessible(true);

            // Prepare a test case that will throw IllegalInstantException
            long localInstant = 604800000L; // Example value that will lead to an exception
            localToUTCMethod.invoke(zonedChronology, localInstant);
        } catch (IllegalInstantException e) {
            // Expected exception
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // If we reach this point, the exception was not thrown
        assertEquals("Expected IllegalInstantException to be thrown", true, false);
    }

    @Test(timeout = 4000)
    public void testLocalToUTC_validConversion() {
        try {
            // Create an instance of ZonedChronology using reflection
            Class<?> clazz = ZonedChronology.class;
            Method getZoneMethod = clazz.getDeclaredMethod("getZone");
            getZoneMethod.setAccessible(true);
            DateTimeZone zone = (DateTimeZone) getZoneMethod.invoke(null); // Assuming a static context for simplicity

            // Create an instance of ZonedChronology
            Constructor<?> constructor = clazz.getDeclaredConstructor(org.joda.time.Chronology.class, DateTimeZone.class);
            constructor.setAccessible(true);
            ZonedChronology zonedChronology = (ZonedChronology) constructor.newInstance(null, zone);

            // Access the private method localToUTC using reflection
            Method localToUTCMethod = clazz.getDeclaredMethod("localToUTC", long.class);
            localToUTCMethod.setAccessible(true);

            // Prepare a valid test case
            long localInstant = 0L; // Example value for valid conversion
            long expectedUTC = localInstant - zone.getOffsetFromLocal(localInstant);
            long actualUTC = (long) localToUTCMethod.invoke(zonedChronology, localInstant);

            // Assert the expected and actual values
            assertEquals(expectedUTC, actualUTC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}