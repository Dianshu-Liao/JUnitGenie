package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where array is not empty and values to remove are present
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'd'};
        char[] expected = {'a', 'c'};
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);

        // Test case where array is empty
        char[] emptyArray = {};
        char[] valuesToRemove = {'a', 'b'};
        char[] expectedEmpty = {};
        char[] resultEmpty = ArrayUtils.removeElements(emptyArray, valuesToRemove);
        assertArrayEquals(expectedEmpty, resultEmpty);

        // Test case where values to remove are empty
        char[] valuesEmpty = {};
        char[] resultWithEmptyValues = ArrayUtils.removeElements(array, valuesEmpty);
        assertArrayEquals(array, resultWithEmptyValues);

        // Test case where both array and values are empty
        char[] resultBothEmpty = ArrayUtils.removeElements(emptyArray, valuesEmpty);
        assertArrayEquals(emptyArray, resultBothEmpty);
        
        // Test case where values to remove are not present in the array
        char[] valuesNotPresent = {'e', 'f'};
        char[] resultNotPresent = ArrayUtils.removeElements(array, valuesNotPresent);
        assertArrayEquals(array, resultNotPresent);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMutableInt() {
        // Test case to ensure MutableInt is used correctly
        MutableInt count = new MutableInt(1);
        assert count.getValue() == 1;
        count.increment();
        assert count.getValue() == 2;
        count.decrementAndGet();
        assert count.getValue() == 1;
    }

}