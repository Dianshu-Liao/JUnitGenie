package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addFirst_short_____short_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddFirstWithNonNullArray() {
        short[] originalArray = {2, 3, 4};
        short elementToAdd = 1;
        short[] expectedArray = {1, 2, 3, 4};

        short[] resultArray = ArrayUtils.addFirst(originalArray, elementToAdd);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test(timeout = 4000)
    public void testAddFirstWithNullArray() {
        short[] originalArray = null;
        short elementToAdd = 1;
        short[] expectedArray = {1};

        short[] resultArray = ArrayUtils.addFirst(originalArray, elementToAdd);
        assertArrayEquals(expectedArray, resultArray);
    }

}