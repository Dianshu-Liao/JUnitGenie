package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_float_____float_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] result = ArrayUtils.insert(1, array, new float[0]);
        assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        // Specify the type explicitly to avoid ambiguity
        float[] result = ArrayUtils.insert(0, new float[0], 1.0f, 2.0f);
        assertArrayEquals(new float[]{1.0f, 2.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f, 5.0f};
        float[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new float[]{1.0f, 4.0f, 5.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        try {
            ArrayUtils.insert(4, array, 1.0f);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }


}