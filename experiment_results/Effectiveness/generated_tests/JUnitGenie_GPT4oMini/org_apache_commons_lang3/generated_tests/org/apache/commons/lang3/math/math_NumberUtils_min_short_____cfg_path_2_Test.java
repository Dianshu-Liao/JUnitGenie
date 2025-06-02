package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_min_short_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinWithValidArray() {
        short[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        short expectedMin = 1;
        short actualMin = NumberUtils.min(array);
        assertEquals(expectedMin, actualMin);
    }

    @Test(timeout = 4000)
    public void testMinWithSingleElementArray() {
        short[] array = {42};
        short expectedMin = 42;
        short actualMin = NumberUtils.min(array);
        assertEquals(expectedMin, actualMin);
    }

    @Test(timeout = 4000)
    public void testMinWithNegativeNumbers() {
        short[] array = {-1, -2, -3, -4};
        short expectedMin = -4;
        short actualMin = NumberUtils.min(array);
        assertEquals(expectedMin, actualMin);
    }

    @Test(timeout = 4000)
    public void testMinWithEmptyArray() {
        short[] array = {};
        try {
            NumberUtils.min(array);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testMinWithNullArray() {
        try {
            NumberUtils.min((short[]) null); // Cast to short[] to resolve ambiguity
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }


}