package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class CachedRandomBits__init__int_Random_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorValidParameters() {
        int cacheSize = 10;
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(cacheSize, random);
        assertNotNull(cachedRandomBits);
    }

    @Test(timeout = 4000)
    public void testConstructorCacheSizeZero() {
        int cacheSize = 0;
        Random random = new Random();
        try {
            new CachedRandomBits(cacheSize, random);
            fail("Expected IllegalArgumentException for cacheSize <= 0");
        } catch (IllegalArgumentException e) {
            assertEquals("cacheSize must be positive", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorCacheSizeNegative() {
        int cacheSize = -5;
        Random random = new Random();
        try {
            new CachedRandomBits(cacheSize, random);
            fail("Expected IllegalArgumentException for cacheSize <= 0");
        } catch (IllegalArgumentException e) {
            assertEquals("cacheSize must be positive", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorRandomNull() {
        int cacheSize = 10;
        try {
            new CachedRandomBits(cacheSize, null);
            fail("Expected NullPointerException for random being null");
        } catch (NullPointerException e) {
            assertEquals("random", e.getMessage());
        }
    }

}