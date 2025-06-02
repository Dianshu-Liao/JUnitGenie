package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case 1: Remove elements from a non-empty array
        char[] array = {'a', 'b', 'c', 'd'};
        char[] valuesToRemove = {'b', 'd'};
        char[] expected = {'a', 'c'};
        char[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);

        // Test case 2: Remove elements when values array is empty
        char[] resultEmptyValues = ArrayUtils.removeElements(array, new char[]{});
        assertArrayEquals(array, resultEmptyValues);

        // Test case 3: Remove elements when the array is empty
        char[] resultEmptyArray = ArrayUtils.removeElements(new char[]{}, valuesToRemove);
        assertArrayEquals(new char[]{}, resultEmptyArray);

        // Test case 4: Remove elements when both arrays are empty
        char[] resultBothEmpty = ArrayUtils.removeElements(new char[]{}, new char[]{});
        assertArrayEquals(new char[]{}, resultBothEmpty);

        // Test case 5: Remove elements that do not exist in the array
        char[] resultNoMatch = ArrayUtils.removeElements(array, new char[]{'e', 'f'});
        assertArrayEquals(array, resultNoMatch);

        // Test case 6: Remove all elements
        char[] resultAllRemoved = ArrayUtils.removeElements(array, new char[]{'a', 'b', 'c', 'd'});
        assertArrayEquals(new char[]{}, resultAllRemoved);
    }

}