package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_double_____double_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_withValidArrayAndValue() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet();
        expected.set(1); // index 1 has value 2.0
        expected.set(3); // index 3 has value 2.0
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withNullArray() {
        double[] array = null;
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // should return an empty BitSet
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withValueNotFound() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 4.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // should return an empty BitSet
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withStartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 5; // Out of bounds index

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        BitSet expected = new BitSet(); // should return an empty BitSet
        assertEquals(expected, result);
    }

}