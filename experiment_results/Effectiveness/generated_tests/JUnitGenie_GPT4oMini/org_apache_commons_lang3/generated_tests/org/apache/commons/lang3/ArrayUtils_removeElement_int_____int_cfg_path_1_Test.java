package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElement_int_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElementWithNullArray() {
        int[] array = null;
        int element = 1;
        try {
            int[] result = ArrayUtils.removeElement(array, element);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElementWithEmptyArray() {
        int[] array = new int[0];
        int element = 1;
        try {
            int[] result = ArrayUtils.removeElement(array, element);
            assertArrayEquals(new int[0], result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElementWithElementNotFound() {
        int[] array = {1, 2, 3};
        int element = 4;
        try {
            int[] result = ArrayUtils.removeElement(array, element);
            assertArrayEquals(new int[]{1, 2, 3}, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElementWithElementFound() {
        int[] array = {1, 2, 3};
        int element = 2;
        try {
            int[] result = ArrayUtils.removeElement(array, element);
            assertArrayEquals(new int[]{1, 3}, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}