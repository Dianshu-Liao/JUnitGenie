package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class CachedRandomBits_nextBits_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testNextBitsValidInput() {
        // Arrange
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, random);
        int bits = 16; // Valid input

        // Act
        int result = cachedRandomBits.nextBits(bits);

        // Assert
        // Since the result is random, we can only assert that it is within the expected range
        assertEquals(bits, Integer.bitCount(result)); // Check that the number of bits generated is as expected
    }

    @Test(timeout = 4000)
    public void testNextBitsThrowsExceptionWhenBitsTooHigh() {
        // Arrange
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, random);
        int bits = 33; // Invalid input

        // Act & Assert
        try {
            cachedRandomBits.nextBits(bits);
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNextBitsThrowsExceptionWhenBitsTooLow() {
        // Arrange
        Random random = new Random();
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, random);
        int bits = 0; // Invalid input

        // Act & Assert
        try {
            cachedRandomBits.nextBits(bits);
        } catch (IllegalArgumentException e) {
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

}