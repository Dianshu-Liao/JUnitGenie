package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_float_____float_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInsertThrowsIndexOutOfBoundsException() {
        float[] array = new float[]{1.0f, 2.0f, 3.0f};
        float[] values = new float[]{4.0f, 5.0f};

        try {
            // This should throw an IndexOutOfBoundsException since the index is out of bounds
            ArrayUtils.insert(4, array, values);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        float[] array = new float[]{1.0f, 2.0f, 3.0f};
        float[] values = new float[]{};

        float[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        float[] result = ArrayUtils.insert(0, null, new float[]{1.0f});
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        float[] array = new float[]{1.0f, 2.0f, 3.0f};
        float[] values = new float[]{4.0f, 5.0f};

        float[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new float[]{1.0f, 4.0f, 5.0f, 2.0f, 3.0f}, result, 0.0f);
    }

}