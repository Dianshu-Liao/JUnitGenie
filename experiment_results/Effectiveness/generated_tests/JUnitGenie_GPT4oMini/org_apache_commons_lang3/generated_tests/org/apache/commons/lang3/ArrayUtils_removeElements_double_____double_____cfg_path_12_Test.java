package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] valuesToRemove = {2.0, 3.0};

        // Expected output after removing 2.0 and 3.0
        double[] expected = {1.0, 4.0, 5.0};

        double[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        // Validate that the result matches expected output
        assertArrayEquals(expected, result, 0.01);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        double[] array = {};
        double[] valuesToRemove = {1.0, 2.0};

        // Expected output should be an empty array
        double[] expected = {};

        double[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        // Validate that the result matches expected output
        assertArrayEquals(expected, result, 0.01);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = null;

        // Expected output should be the same as the original array
        double[] expected = {1.0, 2.0, 3.0};

        double[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        // Validate that the result matches expected output
        assertArrayEquals(expected, result, 0.01);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoValuesToRemove() {
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {};

        // Expected output should be the same as the original array
        double[] expected = {1.0, 2.0, 3.0};

        double[] result = ArrayUtils.removeElements(array, valuesToRemove);
        
        // Validate that the result matches expected output
        assertArrayEquals(expected, result, 0.01);
    }

}