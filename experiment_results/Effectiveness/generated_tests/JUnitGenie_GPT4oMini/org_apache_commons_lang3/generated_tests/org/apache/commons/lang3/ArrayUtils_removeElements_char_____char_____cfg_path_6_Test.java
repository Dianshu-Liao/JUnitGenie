package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        char[] array = null;
        char[] values = {'a', 'b', 'c'};
        
        // Expecting the method to return null since the input array is null
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = null;
        
        // Expecting the method to return a clone of the original array since values are null
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(array, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        char[] array = {};
        char[] values = {'a', 'b', 'c'};
        
        // Expecting the method to return a clone of the original array since it is empty
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(array, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = {};
        
        // Expecting the method to return a clone of the original array since values are empty
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(array, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesPresent() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'd'};
        
        // Expecting the method to return an array without 'b' and 'd'
        char[] expected = {'a', 'c'};
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(expected, result);
    }

}