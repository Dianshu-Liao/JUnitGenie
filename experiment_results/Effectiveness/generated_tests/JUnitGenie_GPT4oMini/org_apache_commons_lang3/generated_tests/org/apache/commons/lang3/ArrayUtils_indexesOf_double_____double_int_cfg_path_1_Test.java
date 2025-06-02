package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_double_____double_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_withValidInputs() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet expected = new BitSet();
        expected.set(1); // indexes of the value 2.0
        expected.set(3);
        
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withNullArray() {
        double[] array = null;
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet expected = new BitSet(); // should be empty due to null array

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withStartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 5; // start index is out of bounds

        BitSet expected = new BitSet(); // should remain empty as we start outside bounds

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_withNoOccurrences() {
        double[] array = {1.0, 3.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet expected = new BitSet(); // no occurrences of 2.0 in the array

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        
        assertEquals(expected, result);
    }

}