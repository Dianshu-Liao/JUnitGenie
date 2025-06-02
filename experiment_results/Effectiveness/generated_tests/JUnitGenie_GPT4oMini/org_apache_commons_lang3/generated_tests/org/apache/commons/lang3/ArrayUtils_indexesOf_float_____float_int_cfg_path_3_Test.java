package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexesOf_float_____float_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIndexesOf() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 4.0f};
        float valueToFind = 2.0f;
        int startIndex = 0;

        BitSet expected = new BitSet();
        expected.set(1);
        expected.set(3);

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithNullArray() {
        float[] array = null;
        float valueToFind = 2.0f;
        int startIndex = 0;

        BitSet expected = new BitSet();

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithStartIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = 5; // Out of bounds

        BitSet expected = new BitSet();

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testIndexesOfWithNoMatches() {
        float[] array = {1.0f, 3.0f, 4.0f};
        float valueToFind = 2.0f;
        int startIndex = 0;

        BitSet expected = new BitSet();

        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);
        assertEquals(expected, result);
    }

}