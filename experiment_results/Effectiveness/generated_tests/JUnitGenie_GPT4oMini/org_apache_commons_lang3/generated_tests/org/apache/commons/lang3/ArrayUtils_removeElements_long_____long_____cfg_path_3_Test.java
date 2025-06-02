package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_removeElements_long_____long_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = {};
        long[] values = {1, 2, 3};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndEmptyValues() {
        long[] array = {1, 2, 3};
        long[] values = {};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{1, 2, 3}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesPresentInArray() {
        long[] array = {1, 2, 3, 4, 5};
        long[] values = {2, 4};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{1, 3, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesNotPresentInArray() {
        long[] array = {1, 2, 3};
        long[] values = {4, 5};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{1, 2, 3}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllValuesPresentInArray() {
        long[] array = {1, 2, 3};
        long[] values = {1, 2, 3};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        long[] values = {1, 2, 3};
        try {
            ArrayUtils.removeElements(null, values);
            fail("Expected an NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullValues() {
        long[] array = {1, 2, 3};
        try {
            ArrayUtils.removeElements(array, null);
            fail("Expected an NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}