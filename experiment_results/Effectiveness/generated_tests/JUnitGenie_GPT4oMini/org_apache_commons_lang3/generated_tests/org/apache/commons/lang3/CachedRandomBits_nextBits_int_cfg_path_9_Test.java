package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import static org.junit.Assert.*;

public class CachedRandomBits_nextBits_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testNextBits_ValidInput() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(8, new java.util.Random());
        int bits = 8; // Valid input

        // Act
        int result = cachedRandomBits.nextBits(bits);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testNextBits_ThrowsIllegalArgumentException_WhenBitsGreaterThan32() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(8, new java.util.Random());
        int bits = 33; // Invalid input

        // Act
        try {
            cachedRandomBits.nextBits(bits);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNextBits_ThrowsIllegalArgumentException_WhenBitsLessThanOrEqualToZero() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(8, new java.util.Random());
        int bits = 0; // Invalid input

        // Act
        try {
            cachedRandomBits.nextBits(bits);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

}