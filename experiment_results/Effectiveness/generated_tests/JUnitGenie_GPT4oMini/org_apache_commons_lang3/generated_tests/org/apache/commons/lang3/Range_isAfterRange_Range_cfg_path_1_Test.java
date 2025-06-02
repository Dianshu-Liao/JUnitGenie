package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Range_isAfterRange_Range_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsAfterRange_NonNullOtherRange() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);
        Range<Integer> range2 = new Range<>(6, 10, null);

        // Act
        boolean result = range1.isAfterRange(range2);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsAfterRange_NullOtherRange() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);

        // Act
        boolean result = range1.isAfterRange(null);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAfterRange_EqualMaximum() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);
        Range<Integer> range2 = new Range<>(5, 10, null);

        // Act
        boolean result = range1.isAfterRange(range2);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAfterRange_LessThanMaximum() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);
        Range<Integer> range2 = new Range<>(4, 10, null);

        // Act
        boolean result = range1.isAfterRange(range2);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAfterRange_GreaterThanMaximum() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);
        Range<Integer> range2 = new Range<>(7, 10, null);

        // Act
        boolean result = range1.isAfterRange(range2);

        // Assert
        assertTrue(result);
    }

}