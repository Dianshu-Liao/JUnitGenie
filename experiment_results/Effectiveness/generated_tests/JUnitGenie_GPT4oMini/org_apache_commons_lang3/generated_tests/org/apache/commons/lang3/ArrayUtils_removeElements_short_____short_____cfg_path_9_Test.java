package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_removeElements_short_____short_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        short[] array = new short[0]; // condition for isEmpty(array) to be true
        short[] values = new short[]{1, 2};

        short[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new short[0], result); // should return an empty array
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValues() {
        short[] array = new short[]{1, 2, 3}; // valid input
        short[] values = new short[0]; // condition for isEmpty(values) to be true

        short[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new short[]{1, 2, 3}, result); // should return the original array
    }

    @Test(timeout = 4000)
    public void testRemoveElements_RemoveValues() {
        short[] array = new short[]{1, 2, 3, 4}; // original array
        short[] values = new short[]{2, 3}; // values to remove

        short[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new short[]{1, 4}, result); // should return array without values 2 and 3
    }

    @Test(timeout = 4000)
    public void testRemoveElements_MultipleOccurrences() {
        short[] array = new short[]{1, 2, 2, 3, 4}; // array with duplicates
        short[] values = new short[]{2}; // value to remove

        short[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new short[]{1, 3, 4}, result); // should remove one occurrence of 2
    }

    @Test(timeout = 4000)
    public void testRemoveElements_NoMatch() {
        short[] array = new short[]{1, 2, 3}; // original array
        short[] values = new short[]{4, 5}; // values not in array

        short[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new short[]{1, 2, 3}, result); // should return original array
    }

}