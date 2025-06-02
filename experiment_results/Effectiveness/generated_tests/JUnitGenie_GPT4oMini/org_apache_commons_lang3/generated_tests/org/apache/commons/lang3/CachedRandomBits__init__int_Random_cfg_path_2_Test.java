package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.fail;

public class CachedRandomBits__init__int_Random_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNegativeCacheSize() {
        try {
            new CachedRandomBits(-1, new Random());
            fail("Expected IllegalArgumentException for negative cacheSize");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert "cacheSize must be positive".equals(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithZeroCacheSize() {
        try {
            new CachedRandomBits(0, new Random());
            fail("Expected IllegalArgumentException for zero cacheSize");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert "cacheSize must be positive".equals(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidCacheSize() {
        try {
            new CachedRandomBits(10, new Random());
            // No exception should be thrown
        } catch (IllegalArgumentException e) {
            fail("Did not expect IllegalArgumentException for valid cacheSize");
        }
    }

}