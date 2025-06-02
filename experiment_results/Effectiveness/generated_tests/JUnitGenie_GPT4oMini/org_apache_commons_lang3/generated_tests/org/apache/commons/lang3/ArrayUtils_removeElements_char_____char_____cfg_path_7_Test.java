package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        char[] array = new char[] {'a', 'b', 'c', 'd'};
        char[] values = new char[] {'b', 'd'};
        
        // Expected result after removing 'b' and 'd' from the array
        char[] expected = new char[] {'a', 'c'};
        
        // Call the focal method
        char[] result = ArrayUtils.removeElements(array, values);
        
        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        char[] array = new char[] {'a', 'b', 'c', 'd'};
        char[] values = new char[] {}; // Empty values
        
        // Expected result should be the same as the original array
        char[] expected = new char[] {'a', 'b', 'c', 'd'};
        
        // Call the focal method
        char[] result = ArrayUtils.removeElements(array, values);
        
        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        char[] array = new char[] {}; // Empty array
        char[] values = new char[] {'b', 'd'};
        
        // Expected result should be the same as the original array (empty)
        char[] expected = new char[] {};
        
        // Call the focal method
        char[] result = ArrayUtils.removeElements(array, values);
        
        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        char[] array = new char[] {'a', 'b', 'c'};
        char[] values = new char[] {'d', 'e'}; // No matches
        
        // Expected result should be the same as the original array
        char[] expected = new char[] {'a', 'b', 'c'};
        
        // Call the focal method
        char[] result = ArrayUtils.removeElements(array, values);
        
        // Assert the result
        assertArrayEquals(expected, result);
    }

}