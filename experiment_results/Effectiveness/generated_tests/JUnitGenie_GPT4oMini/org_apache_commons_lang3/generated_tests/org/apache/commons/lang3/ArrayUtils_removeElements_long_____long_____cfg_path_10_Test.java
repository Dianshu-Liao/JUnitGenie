package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        long[] array = {1, 2, 3, 4, 5};
        long[] valuesToRemove = {2, 4};

        long[] expected = {1, 3, 5};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = {};
        long[] valuesToRemove = {2, 4};

        long[] expected = {};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        long[] array = {1, 2, 3, 4, 5};
        long[] valuesToRemove = {};

        long[] expected = {1, 2, 3, 4, 5};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        long[] array = {1, 2, 3, 4, 5};
        long[] valuesToRemove = {6, 7};

        long[] expected = {1, 2, 3, 4, 5};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        long[] array = {1, 2, 3, 4, 5};
        long[] valuesToRemove = {1, 2, 3, 4, 5};

        long[] expected = {};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        assertArrayEquals(expected, result);
    }

}