package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.IllegalInstantException;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testLocalToUTC() {
        try {
            // Accessing private method using reflection
            ZonedChronology zonedChronology = ZonedChronology.getInstance(null, DateTimeZone.UTC);
            java.lang.reflect.Method method = ZonedChronology.class.getDeclaredMethod("localToUTC", long.class);
            method.setAccessible(true);
            
            // Test case for `localInstant` that is Long.MAX_VALUE
            long localInstantMax = Long.MAX_VALUE;
            long resultMax = (long) method.invoke(zonedChronology, localInstantMax);
            assertEquals(Long.MAX_VALUE, resultMax);
            
            // Test case for `localInstant` that is Long.MIN_VALUE
            long localInstantMin = Long.MIN_VALUE;
            long resultMin = (long) method.invoke(zonedChronology, localInstantMin);
            assertEquals(Long.MIN_VALUE, resultMin);
            
            // Test case for normal input within valid range
            long validLocalInstant = 1000000000000L; // some valid local instant
            long expectedUtcInstant = validLocalInstant - zonedChronology.getZone().getOffsetFromLocal(validLocalInstant);
            long resultValid = (long) method.invoke(zonedChronology, validLocalInstant);
            assertEquals(expectedUtcInstant, resultValid);
            
            // Test case for localInstant close to NEAR_ZERO
            long nearZeroLocalInstant = 604799999L; // just under 1 week in milliseconds
            long resultNearZero = (long) method.invoke(zonedChronology, nearZeroLocalInstant);
            assertNotEquals(Long.MAX_VALUE, resultNearZero);
            
            // Test case for localInstant below -NEAR_ZERO
            long belowNearZeroLocalInstant = -604799999L; // just under -1 week in milliseconds
            long resultBelowNearZero = (long) method.invoke(zonedChronology, belowNearZeroLocalInstant);
            assertNotEquals(Long.MIN_VALUE, resultBelowNearZero);
            
            // Test case for check on throw exception scenario (assuming specific offsets)
            long throwLocalInstant = 100000000L; // defined to cross the offset check
            try {
                method.invoke(zonedChronology, throwLocalInstant);
                fail("Expected IllegalInstantException to be thrown");
            } catch (IllegalInstantException e) {
                // Expected exception
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during testing: " + e.getMessage());
        }
    }


}