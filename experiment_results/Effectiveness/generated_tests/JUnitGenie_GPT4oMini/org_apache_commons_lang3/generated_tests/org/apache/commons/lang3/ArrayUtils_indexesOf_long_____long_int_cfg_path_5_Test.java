package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_long_____long_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_withValidInput() {
        long[] array = {1, 2, 3, 4, 2, 5};
        long valueToFind = 2;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet();
        expected.set(1); // Index of first occurrence of 2
        expected.set(4); // Index of second occurrence of 2
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withNullArray() {
        long[] array = null;
        long valueToFind = 2;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // Should return an empty BitSet
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withValueNotFound() {
        long[] array = {1, 3, 4, 5};
        long valueToFind = 2;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // Should return an empty BitSet
        
        assertEquals(expected, result);
    }

}