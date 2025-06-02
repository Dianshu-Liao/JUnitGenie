package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        char[] array = new char[] {'a', 'b', 'c', 'd', 'e'};
        char[] valuesToRemove = new char[] {'b', 'd'};
        
        char[] expected = new char[] {'a', 'c', 'e'};
        char[] result = null;
        
        try {
            result = ArrayUtils.removeElements(array, valuesToRemove);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        char[] array = new char[] {};
        char[] valuesToRemove = new char[] {'b', 'd'};
        
        char[] expected = new char[] {};
        char[] result = null;
        
        try {
            result = ArrayUtils.removeElements(array, valuesToRemove);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        char[] array = new char[] {'a', 'b', 'c'};
        char[] valuesToRemove = new char[] {};
        
        char[] expected = new char[] {'a', 'b', 'c'};
        char[] result = null;
        
        try {
            result = ArrayUtils.removeElements(array, valuesToRemove);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        char[] array = new char[] {'a', 'b', 'c'};
        char[] valuesToRemove = new char[] {'d', 'e'};
        
        char[] expected = new char[] {'a', 'b', 'c'};
        char[] result = null;
        
        try {
            result = ArrayUtils.removeElements(array, valuesToRemove);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertArrayEquals(expected, result);
    }

}