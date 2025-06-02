package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        long[] valuesToRemove = {2L, 4L};

        long[] expected = {1L, 3L, 5L};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        long[] array = {1L, 2L, 3L};
        long[] valuesToRemove = {};

        long[] expected = {1L, 2L, 3L};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = {};
        long[] valuesToRemove = {1L, 2L};

        long[] expected = {};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        long[] array = {1L, 2L, 3L};
        long[] valuesToRemove = {4L, 5L};

        long[] expected = {1L, 2L, 3L};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        long[] array = {1L, 2L, 3L};
        long[] valuesToRemove = {1L, 2L, 3L};

        long[] expected = {};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithDuplicates() {
        long[] array = {1L, 2L, 2L, 3L, 4L};
        long[] valuesToRemove = {2L};

        long[] expected = {1L, 3L, 4L};
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMutableInt() {
        long[] array = {1L, 2L, 3L};
        long[] valuesToRemove = {2L};

        MutableInt mutableInt = new MutableInt(2);
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(new long[]{1L, 3L}, result);
        mutableInt.increment();
        assertArrayEquals(new long[]{1L, 3L}, result);
    }

}