package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexOf_double_____double_int_double_cfg_path_2_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testIndexOfEmptyArray() {
        double[] array = new double[0]; // External_Method_Parameters_Constraints: must be an empty array
        double valueToFind = 1.0;
        int startIndex = 0; // External_Method_Parameters_Constraints: valid integer
        double tolerance = 0.5;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}