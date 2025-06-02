package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class CachedRandomBits_nextBits_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testNextBitsValidInput() {
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new Random());
        int result = cachedRandomBits.nextBits(16);
        assertTrue("Result should be within the range of generated bits", result >= 0 && result < (1 << 16));
    }

    @Test(timeout = 4000)
    public void testNextBitsThrowsExceptionWhenBitsGreaterThan32() {
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new Random());
        try {
            cachedRandomBits.nextBits(33);
            fail("Expected IllegalArgumentException for bits greater than 32");
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNextBitsThrowsExceptionWhenBitsLessThan1() {
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new Random());
        try {
            cachedRandomBits.nextBits(0);
            fail("Expected IllegalArgumentException for bits less than 1");
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

}