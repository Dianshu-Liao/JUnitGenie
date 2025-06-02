package org.joda.time.chrono;
import org.joda.time.chrono.GJCacheKey;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class chrono_GJCacheKey_equals_Object_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, new Instant(), 1);
        Object nullObject = null;

        try {
            boolean result = key.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, new Instant(), 1);
        Object differentTypeObject = new Object();

        try {
            boolean result = key.equals(differentTypeObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}