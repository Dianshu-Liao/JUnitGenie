package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addFirst_short_____short_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddFirstWithNonNullArray() {
        short[] array = {2, 3, 4};
        short element = 1;
        short[] expected = {1, 2, 3, 4};
        
        short[] result = ArrayUtils.addFirst(array, element);
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddFirstWithNullArray() {
        short[] array = null;
        short element = 1;
        short[] expected = {1};
        
        short[] result = ArrayUtils.addFirst(array, element);
        
        assertArrayEquals(expected, result);
    }

}