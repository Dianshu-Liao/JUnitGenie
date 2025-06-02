package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class chrono_GJCacheKey_equals_Object_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        assertTrue(key.equals(key));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        assertFalse(key.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        String differentClassObject = "Not a GJCacheKey";
        assertFalse(key.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCutoverInstant() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        // Use a method that exists in Instant to create a new Instant
        Instant cutoverInstant = Instant.now().plus(1000); // Use plus instead of plusMillis
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, cutoverInstant, 5);
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentMinDaysInFirstWeek() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 10);
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentZone() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.forID("America/New_York"), Instant.now(), 5);
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValues() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 5);
        // Use a method that exists in Instant to create a comparable Instant
        Instant sameCutoverInstant = Instant.now(); // This is already valid
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, sameCutoverInstant, 5);
        assertTrue(key1.equals(key2));
    }

}