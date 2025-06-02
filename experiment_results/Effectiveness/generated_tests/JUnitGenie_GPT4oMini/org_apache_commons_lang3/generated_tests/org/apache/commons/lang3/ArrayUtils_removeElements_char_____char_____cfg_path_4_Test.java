package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;

public class ArrayUtils_removeElements_char_____char_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        char[] inputArray = {'a', 'b', 'c', 'd'};
        char[] valuesToRemove = {'b', 'c'};
        
        // The 'removeElements' method should remove 'b' and 'c' from the inputArray
        char[] expectedOutput = {'a', 'd'};
        char[] actualOutput = ArrayUtils.removeElements(inputArray, valuesToRemove);
        
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        char[] inputArray = {};
        char[] valuesToRemove = {'a'};
        
        // When the input array is empty, the output should also be an empty array
        char[] expectedOutput = {};
        char[] actualOutput = ArrayUtils.removeElements(inputArray, valuesToRemove);
        
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_NoValuesToRemove() {
        char[] inputArray = {'x', 'y', 'z'};
        char[] valuesToRemove = {};
        
        // If no values are provided to remove, the output should be the same as the input
        char[] expectedOutput = {'x', 'y', 'z'};
        char[] actualOutput = ArrayUtils.removeElements(inputArray, valuesToRemove);
        
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_NonExistentValues() {
        char[] inputArray = {'p', 'q', 'r'};
        char[] valuesToRemove = {'a', 'b'};
        
        // Removing non-existent values should result in the same array
        char[] expectedOutput = {'p', 'q', 'r'};
        char[] actualOutput = ArrayUtils.removeElements(inputArray, valuesToRemove);
        
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_OneValueExists() {
        char[] inputArray = {'a', 'b', 'c', 'd'};
        char[] valuesToRemove = {'d'};
        
        // The result should remove 'd', resulting in 'a', 'b', 'c'
        char[] expectedOutput = {'a', 'b', 'c'};
        char[] actualOutput = ArrayUtils.removeElements(inputArray, valuesToRemove);
        
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElements_AllValuesRemoved() {
        char[] inputArray = {'x', 'y', 'z'};
        char[] valuesToRemove = {'x', 'y', 'z'};
        
        // All values are removed, resulting in an empty array
        char[] expectedOutput = {};
        char[] actualOutput = ArrayUtils.removeElements(inputArray, valuesToRemove);
        
        assertArrayEquals(expectedOutput, actualOutput);
    }

}