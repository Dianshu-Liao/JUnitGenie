package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Range_isBeforeRange_Range_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsBeforeRange() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);
        Range<Integer> range2 = new Range<>(6, 10, null);

        // Act
        boolean result = range1.isBeforeRange(range2);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsBeforeRangeWithNull() {
        // Arrange
        Range<Integer> range1 = new Range<>(1, 5, null);

        // Act
        boolean result = range1.isBeforeRange(null);

        // Assert
        assertTrue(!result); // should return false when otherRange is null
    }

}