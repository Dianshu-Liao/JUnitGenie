package org.joda.time.chrono;
import org.joda.time.chrono.GJCacheKey;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class chrono_GJCacheKey_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SimilarObjects_ReturnsTrue() {
        // Setting up parameters for creating two identical GJCacheKey objects
        DateTimeZone zone = DateTimeZone.forID("Europe/London");
        Instant cutoverInstant = new Instant(1622505600000L); // Example timestamp
        int minDaysInFirstWeek = 1;

        // Creating two GJCacheKey objects with the same values
        GJCacheKey key1 = new GJCacheKey(zone, cutoverInstant, minDaysInFirstWeek);
        GJCacheKey key2 = new GJCacheKey(zone, cutoverInstant, minDaysInFirstWeek);

        // Verifying the equals method returns true for identical objects
        try {
            assertTrue(key1.equals(key2));
        } catch (Exception e) {
            // Handle the potential exception
            e.printStackTrace();
        }
    }

}