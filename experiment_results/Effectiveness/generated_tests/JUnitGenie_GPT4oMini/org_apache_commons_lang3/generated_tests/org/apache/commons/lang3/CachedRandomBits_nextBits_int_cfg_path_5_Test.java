package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class CachedRandomBits_nextBits_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testNextBitsValidInput() {
        // Arrange
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, random);
        int bits = 16; // Valid input

        // Act
        int result = cachedRandomBits.nextBits(bits);

        // Assert
        assertNotNull(result);
        assertTrue(result >= 0); // Assuming the result should be non-negative
    }

    @Test(timeout = 4000)
    public void testNextBitsThrowsIllegalArgumentExceptionWhenBitsGreaterThan32() {
        // Arrange
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, random);
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
    public void testNextBitsThrowsIllegalArgumentExceptionWhenBitsLessThanOrEqualToZero() {
        // Arrange
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, random);
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