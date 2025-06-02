package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_min_short_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinWithValidArray() {
        // Arrange
        short[] array = {3, 5, 1, 7, 2};

        // Act
        short result = NumberUtils.min(array);

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testMinWithSingleElementArray() {
        // Arrange
        short[] array = {4};

        // Act
        short result = NumberUtils.min(array);

        // Assert
        assertEquals(4, result);
    }

    @Test(timeout = 4000)
    public void testMinWithNegativeValues() {
        // Arrange
        short[] array = {-1, -5, -3, -7};

        // Act
        short result = NumberUtils.min(array);

        // Assert
        assertEquals(-7, result);
    }

    @Test(expected = NullPointerException.class)
    public void testMinWithNullArray() {
        // Act
        NumberUtils.min((short[]) null); // Cast to short[] to resolve ambiguity
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        // Act
        short[] array = {};
        NumberUtils.min(array);
    }


}