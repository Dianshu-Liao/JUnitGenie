package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_WithNonEmptyArrayAndEmptyValues() {
        short[] array = new short[] {1, 2, 3};
        short[] values = new short[] {}; // empty values
        
        short[] expected = new short[] {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}