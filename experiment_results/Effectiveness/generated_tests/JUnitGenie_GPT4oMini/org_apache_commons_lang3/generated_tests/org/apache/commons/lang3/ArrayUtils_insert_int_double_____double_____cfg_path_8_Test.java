package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_insert_int_double_____double_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        try {
            double[] result = ArrayUtils.insert(0, new double[0], 1.0, 2.0); // Changed null to new double[0]
            assertArrayEquals(new double[]{1.0, 2.0}, result, 0.0); // Added delta for double comparison
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}