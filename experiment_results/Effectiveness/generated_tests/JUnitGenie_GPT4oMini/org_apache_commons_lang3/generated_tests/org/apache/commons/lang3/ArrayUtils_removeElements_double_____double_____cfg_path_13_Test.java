package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_removeElements_double_____double_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrays() {
        double[] inputArray = {1.0, 2.0, 3.0, 4.0};
        double[] valuesToRemove = {2.0, 3.0};
        double[] expectedOutput = {1.0, 4.0};

        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        double[] inputArray = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {};
        double[] expectedOutput = {1.0, 2.0, 3.0};

        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        double[] inputArray = {};
        double[] valuesToRemove = {2.0, 3.0};
        double[] expectedOutput = {};

        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        double[] inputArray = null;
        double[] valuesToRemove = {2.0, 3.0};
        double[] expectedOutput = null;

        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllElementsRemoved() {
        double[] inputArray = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {1.0, 2.0, 3.0};
        double[] expectedOutput = {};

        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }
    
    @Test(timeout = 4000)
    public void testRemoveElementsWithNonDoubleValues() {
        // This is to ensure the method only works properly with double values.
        double[] inputArray = {1.0, 2.0, 3.0, 4.0};
        double[] valuesToRemove = {5.0}; // 5.0 is not in inputArray
        double[] expectedOutput = {1.0, 2.0, 3.0, 4.0}; // Should remain unchanged

        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithVariableInstances() {
        MutableInt count1 = new MutableInt(1);
        MutableInt count2 = new MutableInt(0);

        double[] inputArray = {1.0, 2.0, 3.0, 4.0};
        double[] valuesToRemove = {2.0, 3.0}; 

        count1.increment(); // Just to ensure it's initialized
        count2.decrementAndGet(); // This would lead to a negative value if used
        
        // Ensuring the functionality still works despite separate instances
        double[] expectedOutput = {1.0, 4.0};
        double[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expectedOutput, result, 0.001);
    }

}