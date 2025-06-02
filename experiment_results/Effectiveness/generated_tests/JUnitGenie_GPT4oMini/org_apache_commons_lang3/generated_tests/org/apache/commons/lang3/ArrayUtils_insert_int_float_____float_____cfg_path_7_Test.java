package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_float_____float_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {}; // Empty values
        float[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndex() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f, 5.0f};
        float[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new float[]{1.0f, 4.0f, 5.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f, 5.0f};
        try {
            ArrayUtils.insert(4, array, values); // Index out of bounds
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        float[] result = ArrayUtils.insert(0, null, new float[]{1.0f}); // Specify float array
        assertNull(result);
    }


}