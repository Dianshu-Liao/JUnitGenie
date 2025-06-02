package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElement_short_____short_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElement() {
        short[] array = {1, 2, 3, 4, 5};
        short elementToRemove = 3;
        short[] expected = {1, 2, 4, 5};
        
        // Execute the method under test
        short[] result = ArrayUtils.removeElement(array, elementToRemove);
        
        // Verify the result
        assertArrayEquals(expected, result);
    }

}