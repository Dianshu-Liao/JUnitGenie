package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.apache.commons.lang3.mutable.MutableInt;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        char[] inputArray = null;
        char[] valuesToRemove = {'a', 'b'};

        char[] expectedResult = null; // should remain null
        char[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);

        assertArrayEquals(expectedResult, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        char[] inputArray = {'a', 'b', 'c'};
        char[] valuesToRemove = {};

        char[] expectedResult = {'a', 'b', 'c'}; // no elements should be removed
        char[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);

        assertArrayEquals(expectedResult, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesPresent() {
        char[] inputArray = {'a', 'b', 'c', 'd'};
        char[] valuesToRemove = {'b', 'd'};

        char[] expectedResult = {'a', 'c'}; // 'b' and 'd' should be removed
        char[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);

        assertArrayEquals(expectedResult, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesNotPresent() {
        char[] inputArray = {'a', 'b', 'c'};
        char[] valuesToRemove = {'d', 'e'};

        char[] expectedResult = {'a', 'b', 'c'}; // no removal
        char[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);

        assertArrayEquals(expectedResult, result);
    }

}