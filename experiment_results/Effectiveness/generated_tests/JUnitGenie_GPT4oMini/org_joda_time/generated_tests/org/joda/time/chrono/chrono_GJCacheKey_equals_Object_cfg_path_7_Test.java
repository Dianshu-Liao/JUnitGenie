package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class chrono_GJCacheKey_equals_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        assertTrue(key.equals(key));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        assertFalse(key.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        String differentClassObject = "Not a GJCacheKey";
        assertFalse(key.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCutoverInstant() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        // Assuming GJCacheKey has a method to get the cutover instant, 
        // if not, we need to create a new instance with a different instant.
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now().plus(1), 1); // Corrected line
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentMinDaysInFirstWeek() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 2);
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentZone() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.forID("America/New_York"), Instant.now(), 1);
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValues() {
        Instant instant = Instant.now();
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, instant, 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, instant, 1);
        assertTrue(key1.equals(key2));
    }

}