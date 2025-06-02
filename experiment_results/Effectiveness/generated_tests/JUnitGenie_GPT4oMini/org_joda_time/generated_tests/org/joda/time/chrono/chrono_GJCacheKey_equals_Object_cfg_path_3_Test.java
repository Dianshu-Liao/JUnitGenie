package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class chrono_GJCacheKey_equals_Object_cfg_path_3_Test {

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
        assertFalse(key.equals("Not a GJCacheKey"));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCutoverInstant() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now().plus(1000), 1); // Changed to plus milliseconds
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
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        assertTrue(key1.equals(key2));
    }


}