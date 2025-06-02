package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        short[] array = new short[0]; // @parameter0 must be an empty short[] array
        short[] values = {1, 2, 3}; // values can be any short values

        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new short[0], result); // Expecting an empty array as output
    }

    @Test(timeout = 4000)
    public void testRemoveElements_NullArray() {
        short[] array = null; // @parameter0 can be null
        short[] values = {1, 2, 3}; // values can be any short values

        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(null, result); // Expecting null as output
    }

}