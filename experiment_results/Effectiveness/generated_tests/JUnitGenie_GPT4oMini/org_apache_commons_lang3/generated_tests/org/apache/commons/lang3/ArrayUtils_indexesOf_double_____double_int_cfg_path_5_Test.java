package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.BitSet;

public class ArrayUtils_indexesOf_double_____double_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_NullArray() {
        double[] array = null;
        double valueToFind = 1.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(new BitSet(), result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_EmptyArray() {
        double[] array = new double[0];
        double valueToFind = 1.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(new BitSet(), result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_ValueNotFound() {
        double[] array = {2.0, 3.0, 5.0};
        double valueToFind = 1.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(new BitSet(), result);
    }

    @Test(timeout = 4000)
    public void testIndexesOf_ValueFound() {
        double[] array = {1.0, 2.0, 1.0, 3.0};
        double valueToFind = 1.0;
        int startIndex = 0;

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        BitSet expected = new BitSet();
        expected.set(0);
        expected.set(2);

        assertEquals(expected, result);
    }

}