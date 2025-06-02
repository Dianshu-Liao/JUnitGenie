package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import java.util.BitSet;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_indexesOf_long_____long_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIndexesOfWithValidInput() {
        long[] array = { 1L, 2L, 3L, 2L, 4L };
        long valueToFind = 2L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();
        expected.set(1); // index of first occurrence
        expected.set(3); // index of second occurrence

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithNullArray() {
        long[] array = null;
        long valueToFind = 5L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet(); // should return empty BitSet

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithOutOfBoundsStartIndex() {
        long[] array = { 1L, 2L, 3L, 4L };
        long valueToFind = 2L;
        int startIndex = 5; // starting index out of bounds

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet(); // should return empty BitSet

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithValueNotInArray() {
        long[] array = { 1L, 2L, 3L, 4L };
        long valueToFind = 5L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet(); // should return empty BitSet

        assertEquals(expected, result);
    }

}