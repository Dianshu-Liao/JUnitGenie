package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;
import static org.junit.Assert.*;

public class CachedRandomBits_nextBits_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextBitsThrowsIllegalArgumentExceptionWhenBitsGreaterThan32() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new java.util.Random());
        int bits = 33;

        // Act
        try {
            cachedRandomBits.nextBits(bits);
            fail("Expected IllegalArgumentException for bits greater than 32");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testNextBitsThrowsIllegalArgumentExceptionWhenBitsLessThanEqualToZero() {
        // Arrange
        CachedRandomBits cachedRandomBits = new CachedRandomBits(32, new java.util.Random());
        int bits = 0;

        // Act
        try {
            cachedRandomBits.nextBits(bits);
            fail("Expected IllegalArgumentException for bits less than or equal to 0");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("number of bits must be between 1 and 32", e.getMessage());
        }
    }

}