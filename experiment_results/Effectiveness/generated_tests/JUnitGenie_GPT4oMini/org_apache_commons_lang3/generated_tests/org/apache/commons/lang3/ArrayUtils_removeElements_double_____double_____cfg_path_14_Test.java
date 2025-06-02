package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_removeElements_double_____double_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_BothInputsEmpty() {
        double[] result = ArrayUtils.removeElements(new double[]{}, new double[]{});
        assertArrayEquals(new double[]{}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArrayInput() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        double[] valuesToRemove = new double[]{};
        double[] result = ArrayUtils.removeElements(input, valuesToRemove);
        assertArrayEquals(input, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValuesInput() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        double[] valuesToRemove = new double[]{};
        double[] result = ArrayUtils.removeElements(input, valuesToRemove);
        assertArrayEquals(input, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_RemoveSomeValues() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        double[] valuesToRemove = new double[]{2.0};
        double[] result = ArrayUtils.removeElements(input, valuesToRemove);
        assertArrayEquals(new double[]{1.0, 3.0}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_RemoveAllValues() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        double[] valuesToRemove = new double[]{1.0, 2.0, 3.0};
        double[] result = ArrayUtils.removeElements(input, valuesToRemove);
        assertArrayEquals(new double[]{}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_NoValuesRemoved() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        double[] valuesToRemove = new double[]{4.0};
        double[] result = ArrayUtils.removeElements(input, valuesToRemove);
        assertArrayEquals(input, result, 0.0);
    }


}