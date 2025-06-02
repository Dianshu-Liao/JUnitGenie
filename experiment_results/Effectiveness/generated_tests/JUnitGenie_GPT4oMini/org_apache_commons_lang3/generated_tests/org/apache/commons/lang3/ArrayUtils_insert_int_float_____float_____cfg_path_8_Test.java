package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_insert_int_float_____float_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        try {
            // Specify the type explicitly to avoid ambiguity
            float[] result = ArrayUtils.insert(0, new float[0], 1.0f, 2.0f);
            // Use assertArrayEquals with the correct method for float arrays
            assertArrayEquals(new float[] {1.0f, 2.0f}, result, 0.0f);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }
    }

}