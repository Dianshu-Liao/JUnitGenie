package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import static org.junit.Assert.*;

public class CachedRandomBits_nextBits_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testNextBits() {
        // Create an instance of CachedRandomBits
        CachedRandomBits cachedRandomBits = new CachedRandomBits(1024, new java.util.Random());

        // Test when bits is within valid range
        int bits = 16; // Valid number of bits
        int result = cachedRandomBits.nextBits(bits);
        assertTrue("Result should be an integer with 16 bits", (result >= 0) && (result < (1 << bits)));

        // Test for edge case where bits is 1
        bits = 1;
        result = cachedRandomBits.nextBits(bits);
        assertTrue("Result should be an integer with 1 bit", (result >= 0) && (result < (1 << bits)));

        // Test for edge case where bits is 32
        bits = 32;
        result = cachedRandomBits.nextBits(bits);
        assertTrue("Result should be an integer with 32 bits", (result >= 0) && (result < (1 << bits)));

        // Test for exception when bits > 32
        try {
            cachedRandomBits.nextBits(33);
            fail("Expected IllegalArgumentException for bits > 32");
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }

        // Test for exception when bits <= 0
        try {
            cachedRandomBits.nextBits(0);
            fail("Expected IllegalArgumentException for bits <= 0");
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

}