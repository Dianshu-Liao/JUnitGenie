package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndValues() {
        short[] array = new short[]{1, 2, 3, 4, 5};
        short[] values = new short[]{2, 4};
        short[] expected = new short[]{1, 3, 5};
        
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        short[] array = new short[]{1, 2, 3, 4, 5};
        short[] values = new short[]{};
        short[] expected = new short[]{1, 2, 3, 4, 5};
        
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        short[] array = new short[]{};
        short[] values = new short[]{2, 4};
        short[] expected = new short[]{};
        
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        short[] values = new short[]{2, 4};
        short[] expected = null;

        try {
            short[] result = ArrayUtils.removeElements(null, values);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}