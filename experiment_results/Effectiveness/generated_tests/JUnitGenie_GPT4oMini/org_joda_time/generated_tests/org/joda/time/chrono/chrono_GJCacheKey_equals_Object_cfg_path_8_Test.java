package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class chrono_GJCacheKey_equals_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testEquals() {
        // Arrange
        DateTimeZone zone = DateTimeZone.forID("UTC");
        Instant cutoverInstant = Instant.now();
        int minDaysInFirstWeek = 1;

        GJCacheKey key1 = new GJCacheKey(zone, cutoverInstant, minDaysInFirstWeek);
        GJCacheKey key2 = new GJCacheKey(zone, cutoverInstant, minDaysInFirstWeek);

        // Act
        boolean result = false;
        try {
            result = key1.equals(key2);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertTrue(result);
    }

}