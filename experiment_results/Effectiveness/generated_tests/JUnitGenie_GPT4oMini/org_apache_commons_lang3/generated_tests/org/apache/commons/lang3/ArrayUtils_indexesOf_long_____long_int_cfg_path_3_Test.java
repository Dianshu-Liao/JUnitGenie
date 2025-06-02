package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_long_____long_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_withValidParameters() {
        long[] array = {1L, 2L, 3L, 2L, 4L};
        long valueToFind = 2L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(3);

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withNullArray() {
        long[] array = null;
        long valueToFind = 2L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withEmptyArray() {
        long[] array = {};
        long valueToFind = 2L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withStartIndexOutOfBounds() {
        long[] array = {1L, 2L, 3L};
        long valueToFind = 2L;
        int startIndex = 5; // Out of bounds

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withNegativeStartIndex() {
        long[] array = {1L, 2L, 3L};
        long valueToFind = 2L;
        int startIndex = -1; // Invalid start index

        try {
            ArrayUtils.indexesOf(array, valueToFind, startIndex);
        } catch (Exception e) {
            // Expected exception
        }
    }

}