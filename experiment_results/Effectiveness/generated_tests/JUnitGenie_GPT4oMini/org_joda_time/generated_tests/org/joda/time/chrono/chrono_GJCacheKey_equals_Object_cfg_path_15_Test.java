package org.joda.time.chrono;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class chrono_GJCacheKey_equals_Object_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testEqualsSameObject() {
        GJCacheKey key = new GJCacheKey(null, null, 0);
        assertTrue(key.equals(key));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentObject() {
        GJCacheKey key1 = new GJCacheKey(null, null, 0);
        Object obj = new Object();
        try {
            // This will cover the case where 'this != obj'
            boolean result = key1.equals(obj);
            assertTrue(!result); // Expecting false since they are different types
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}