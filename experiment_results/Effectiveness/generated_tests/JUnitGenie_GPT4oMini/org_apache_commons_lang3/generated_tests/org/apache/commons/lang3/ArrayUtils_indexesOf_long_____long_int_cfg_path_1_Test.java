package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_long_____long_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_WithValidInputs() {
        long[] array = {1, 2, 3, 4, 2, 5};
        long valueToFind = 2;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();
        expected.set(1); // Index of first occurrence of value 2
        expected.set(4); // Index of second occurrence of value 2

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_WithNullArray() {
        long[] array = null;
        long valueToFind = 2;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet(); // Should return an empty BitSet for null array

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_WithStartIndexGreaterThanArrayLength() {
        long[] array = {1, 2, 3, 4};
        long valueToFind = 2;
        int startIndex = 5; // Start index is out of bounds

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet(); // Should return an empty BitSet

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_WithNoOccurrences() {
        long[] array = {1, 2, 3, 4};
        long valueToFind = 5;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet(); // Should return an empty BitSet

        assertEquals(expected, result);
    }

}