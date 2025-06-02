package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_removeElement_boolean_____boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElement() {
        // Test case where the element exists in the array
        boolean[] inputArray = {true, false, true, false};
        boolean elementToRemove = false;
        boolean[] expectedOutput = {true, true}; // Expected output after removing the element
        boolean[] actualOutput = ArrayUtils.removeElement(inputArray, elementToRemove);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveElement_ElementNotFound() {
        // Test case where the element does not exist in the array
        boolean[] inputArray = {true, true, true};
        boolean elementToRemove = false;
        boolean[] expectedOutput = {true, true, true}; // Expected output is the same array
        boolean[] actualOutput = ArrayUtils.removeElement(inputArray, elementToRemove);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}