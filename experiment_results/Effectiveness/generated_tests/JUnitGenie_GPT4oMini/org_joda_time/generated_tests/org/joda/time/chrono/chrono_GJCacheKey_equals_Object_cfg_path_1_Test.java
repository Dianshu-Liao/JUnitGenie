package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJCacheKey;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class chrono_GJCacheKey_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameReference() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        assertTrue(key.equals(key)); // Testing self-reference
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        assertFalse(key.equals(null)); // Testing against null
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        Object other = new Object();
        assertFalse(key.equals(other)); // Testing against different class
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCutoverInstant() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now().plus(1000), 1); // Changed to use Instant.now().plus(1000)
        assertFalse(key1.equals(key2)); // Different `cutoverInstant`
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentMinDaysInFirstWeek() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 2);
        assertFalse(key1.equals(key2)); // Different `minDaysInFirstWeek`
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentZone() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.forID("America/New_York"), Instant.now(), 1);
        assertFalse(key1.equals(key2)); // Different `zone`
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, Instant.now(), 1); // Changed to use Instant.now() for equality
        assertTrue(key1.equals(key2)); // Same values for fields
    }


}