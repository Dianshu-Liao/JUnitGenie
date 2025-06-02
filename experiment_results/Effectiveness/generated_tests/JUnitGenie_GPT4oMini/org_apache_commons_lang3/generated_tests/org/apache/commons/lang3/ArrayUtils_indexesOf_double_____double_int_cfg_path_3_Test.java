package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_double_____double_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIndexesOf() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(3);

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithNullArray() {
        double[] array = null;
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet expected = new BitSet();

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithStartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 5; // Out of bounds

        BitSet expected = new BitSet();

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithNoMatches() {
        double[] array = {1.0, 3.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 0;

        BitSet expected = new BitSet();

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

}