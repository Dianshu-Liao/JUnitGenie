package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import static org.junit.Assert.*;

public class CachedRandomBits_nextBits_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNextBitsValidInput() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new java.util.Random());
        int bits = 16; // Valid input

        // Act
        int result = cachedRandomBits.nextBits(bits);

        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testNextBitsInputTooHigh() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new java.util.Random());
        int bits = 33; // Invalid input

        // Act
        try {
            cachedRandomBits.nextBits(bits);
            fail("Expected IllegalArgumentException for bits > 32");
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNextBitsInputTooLow() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new java.util.Random());
        int bits = 0; // Invalid input

        // Act
        try {
            cachedRandomBits.nextBits(bits);
            fail("Expected IllegalArgumentException for bits <= 0");
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

}