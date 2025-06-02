package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        char[] array = new char[0]; // @parameter0 must be an empty array
        char[] values = {'a', 'b', 'c'};
        
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new char[0], result); // Expecting an empty array as output
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValues() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'd'}; // Values to remove
        
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new char[]{'a', 'c'}, result); // Expecting 'a' and 'c' to remain
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = {}; // No values to remove
        
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new char[]{'a', 'b', 'c'}, result); // Expecting the original array
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = {'a', 'b', 'c'}; // All values to remove
        
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new char[0], result); // Expecting an empty array as output
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithRepeatedValues() {
        char[] array = {'a', 'b', 'b', 'c'};
        char[] values = {'b'}; // Remove 'b' once
        
        char[] result = ArrayUtils.removeElements(array, values);
        
        assertArrayEquals(new char[]{'a', 'b', 'c'}, result); // Expecting one 'b' to remain
    }

}