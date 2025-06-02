package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElement_int_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElement_ElementExists() {
        int[] array = {1, 2, 3, 4, 5};
        int elementToRemove = 3;
        int[] expected = {1, 2, 4, 5};
        int[] result = ArrayUtils.removeElement(array, elementToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElement_ElementNotExists() {
        int[] array = {1, 2, 3, 4, 5};
        int elementToRemove = 6;
        int[] expected = {1, 2, 3, 4, 5}; // Expecting the original array
        int[] result = ArrayUtils.removeElement(array, elementToRemove);
        assertArrayEquals(expected, result);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElement_EmptyArray() {
        int[] array = {};
        int elementToRemove = 1;
        int[] expected = {}; // Expecting an empty array
        int[] result = ArrayUtils.removeElement(array, elementToRemove);
        assertArrayEquals(expected, result);
    }

}