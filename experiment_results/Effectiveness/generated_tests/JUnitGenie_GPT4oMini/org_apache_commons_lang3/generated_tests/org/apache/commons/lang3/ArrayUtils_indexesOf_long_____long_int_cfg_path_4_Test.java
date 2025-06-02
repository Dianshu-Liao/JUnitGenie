package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_long_____long_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIndexesOf() {
        long[] array = {1L, 2L, 3L, 2L, 4L};
        long valueToFind = 2L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet();
        expected.set(1); // index of first occurrence of 2
        expected.set(3); // index of second occurrence of 2
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithNullArray() {
        long[] array = null;
        long valueToFind = 2L;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // should return an empty BitSet
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithStartIndexOutOfBounds() {
        long[] array = {1L, 2L, 3L};
        long valueToFind = 2L;
        int startIndex = 5; // out of bounds

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // should return an empty BitSet
        
        assertEquals(expected, result);
    }

}