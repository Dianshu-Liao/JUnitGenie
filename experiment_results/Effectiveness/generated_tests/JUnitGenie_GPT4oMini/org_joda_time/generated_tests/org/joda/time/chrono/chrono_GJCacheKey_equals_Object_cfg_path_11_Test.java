package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class chrono_GJCacheKey_equals_Object_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testEquals() {
        // Create instances of GJCacheKey for testing
        Instant instant1 = new Instant();
        Instant instant2 = new Instant();
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, instant1, 5);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, instant1, 5);
        GJCacheKey key3 = new GJCacheKey(DateTimeZone.UTC, instant2, 10);
        
        // Test for equality with the same object
        assertTrue(key1.equals(key1));
        
        // Test for equality with another object of the same state
        assertTrue(key1.equals(key2));
        
        // Test for inequality with a different state
        assertFalse(key1.equals(key3));
        
        // Test for inequality with null
        assertFalse(key1.equals(null));
        
        // Test for inequality with an object of a different class
        assertFalse(key1.equals("Not a GJCacheKey"));
    }

}